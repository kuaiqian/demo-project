package com.duobaoyu.demoproject.model.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "模板对象")
public class SmsTemplateResultDto extends Page {

        private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "主键")
        private Long id;

        @ApiModelProperty(value = "模板编号")
        private String templateNo;

        @ApiModelProperty(value = "第三方模板编号")
        private String thirdTemplateNo;

        @ApiModelProperty(value = "模板类型")
        private Integer templateType;

        @ApiModelProperty(value = "模板类型中文描述")
        private String templateTypeDesc;

        @ApiModelProperty(value = "模板标题")
        private String templateTitle;

        @ApiModelProperty(value = "短信服务商")
        private Integer serviceProvider;

        @ApiModelProperty(value = "短信服务商 ")
        private String serviceProviderDesc;

        @ApiModelProperty(value = "模板内容")
        private String templateContent;

        @ApiModelProperty(value = "变量标识符")
        private String variableIdentifier;

        @ApiModelProperty(value = "变量个数")
        private Integer variableCount;

        @ApiModelProperty(value = "推送类型")
        private Integer pushType;

}
