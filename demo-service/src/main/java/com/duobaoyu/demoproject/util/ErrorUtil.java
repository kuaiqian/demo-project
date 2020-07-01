package com.duobaoyu.demoproject.util;

import com.duobaoyu.demoproject.enums.GlobalErrorCodesEnum;
import com.duobaoyu.middleware.common.GlobalConstants;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;

import com.duobaoyu.demoproject.exception.AppBizException;
import com.duobaoyu.middleware.common.Result;

import lombok.extern.slf4j.Slf4j;

import static com.duobaoyu.demoproject.enums.GlobalErrorCodesEnum.*;

/**
 * 全局异常处理类
 *
 * @author chengchen
 * @version 1.0
 * @date 2020/7/1 15:28
 */
@Slf4j
public class ErrorUtil {

    public static Result<String> handException(Exception ex) {
        try {
            // 自定义业务异常，不需要打印错误堆栈信息，直接返回处理结果
            // 对于可以捕获的框架异常，可以按需转成自定义异常抛出来
            if (ex instanceof AppBizException) {
                return Result.success().code(((AppBizException)ex).getCode()).message(ex.getMessage()).build();
            }
            log.error("message-center error:{}", ex);
            throw ex;
        } catch (MethodArgumentNotValidException e) {
            // 框架参数校验异常，不需要打印错误堆栈
            return Result.failure().code(PARAMS_VALIAD_ERROR.getCode()).message(getParamErrorMessage(e)).build();
        } catch (HttpRequestMethodNotSupportedException e) {
            // 用户请求方式错误，返回相应的描述信息，可以拼接上对应的e.getMessage()信息
            return Result.failure().code(REQUEST_METHOD_ERROR.getCode()).message(String.format("%s:%s", REQUEST_METHOD_ERROR.getMessage(), e.getMessage())).build();
        } catch (HttpMessageConversionException e) {
            return Result.failure().code(PARAM_TYPE_TRANSFORM_ERROR.getCode()).message(PARAM_TYPE_TRANSFORM_ERROR.getMessage()).build();
        } catch (IllegalArgumentException e) {
            return Result.failure().code(ILLEGAL_ARGUMENT.getCode()).message(ILLEGAL_ARGUMENT.getMessage()).build();
        } catch (ServletRequestBindingException e) {
            return Result.failure().code(REQUEST_BIND_ERROR.getCode()).message(REQUEST_BIND_ERROR.getMessage()).build();
        } catch (Exception e) {
            // 系统异常，服务不可用、数据库异常等，必须有兜底措施
            return Result.failure().code(GlobalConstants.RESULT_CODE_FAILURE).message("系统未知错误").build();
        }
    }

    private static String getParamErrorMessage(MethodArgumentNotValidException e) {
        // 按需重新封装需要返回的错误信息
        StringBuilder stringBuilder = new StringBuilder();
        // 解析原错误信息，封装后返回，此处返回非法的字段名称，错误信息
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            if (stringBuilder.length() > 1) {
                stringBuilder.append(";  ");
            }
            stringBuilder.append(error.getDefaultMessage());
        }
        return stringBuilder.toString();
    }
}