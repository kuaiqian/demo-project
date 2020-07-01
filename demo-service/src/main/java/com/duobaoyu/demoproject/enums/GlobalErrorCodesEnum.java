package com.duobaoyu.demoproject.enums;

/**
 *  公共异常码枚举
 *
 * @author chengchen
 * @version 1.0
 * @date 2020/7/1 16:11
 */
public enum GlobalErrorCodesEnum {

    PARAMS_VALIAD_ERROR("999999","请求参数校验错误"),
    REQUEST_METHOD_ERROR("999998","请求方式错误"),
    PARAM_TYPE_TRANSFORM_ERROR("999997","参数类型转换错误"),
    ILLEGAL_ARGUMENT("999996","参数非法"),
    REQUEST_BIND_ERROR("999995","参数绑定错误"),

    ;

    private String code;
    private String message;

    GlobalErrorCodesEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
