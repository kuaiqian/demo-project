package com.duobaoyu.demoproject.model.params;

import java.io.Serializable;

import com.duobaoyu.demoproject.model.result.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * XXXXX类说明
 *
 * @author chengchen
 * @version 1.0
 * @date 2020/7/3 17:31
 */
@Data
@ApiModel(value = "查询短信模板请求参数")
public class SmsTemplateQueryParamDto extends Page implements Serializable {

    @ApiModelProperty(value = "模板编号 模板编号")
    private String templateNo;

    @ApiModelProperty(value = "模板类型 1：验证码 2：通知类 3：营销类 4 提醒类")
    private Integer templateType;

    @ApiModelProperty(value = "模板标题 模板标题")
    private String templateTitle;

}
