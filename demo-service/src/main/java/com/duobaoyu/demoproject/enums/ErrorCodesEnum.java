package com.duobaoyu.demoproject.enums;

/**
 * 自定义业务异常码枚举
 *
 * @author chengchen
 * @version 1.0
 * @date 2020/6/1 17:34
 */
public enum ErrorCodesEnum {

    TEMPLATE_NOT_EXSITS("MS0001","模版不存在"),
    TEMPLATE_NO_NUll("MS0002","模板编号为空"),
    VARIABLE_COUNT_EMPTY("MS0003","变量标识为空"),
    VARIABLE_COUNT_ERROR("MS0004","模板设置变量个数配置错误"),
    REQUEST_VARIABLE_COUNT_ERROR("MS0005","请求变量个数与模板配置变量数不符"),
    NO_SUPPORT_SERVICE_PROVIDER("MS1001","不支持的短信渠道服务商"),
    NO_SUPPORT_MSGTYPE("MS1002","不支持的消息类型"),
    RECIEVE_PERSON_EMPTY("MS1003","消息接收人不能为空"),
    DINGDING_USER_ID_EMPTY("MS1004","钉钉人员信息为空"),
    REQUEST_CHANNEL_ERROR("MS1005","渠道异常"),
    REMOTE_SERVICE_ERROR("MS1006","远程服务异常"),

    PARAMS_VALIAD_ERROR("MS9999","请求参数校验错误"),
    REQUEST_METHOD_ERROR("MS9998","请求方式错误"),
    PARAM_TYPE_TRANSFORM_ERROR("MS9997","参数类型转换错误"),
    ILLEGAL_ARGUMENT("MS9996","参数非法"),
    REQUEST_BIND_ERROR("MS9995","参数绑定错误"),


    ;

    private String code;
    private String message;

    ErrorCodesEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorCodesEnum getErrorCodeEnum(String code) {
        for (ErrorCodesEnum item : ErrorCodesEnum.values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }

        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
