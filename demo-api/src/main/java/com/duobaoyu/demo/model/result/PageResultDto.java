package com.duobaoyu.demo.model.result;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页结果对象
 *
 * @author: chengchen
 * @date: 2018/12/10 17:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "分页查询结果对象")
public class PageResultDto<T> implements Serializable {

    /**
     * 数据总数
     */
    @ApiModelProperty(value="数据总数")
    private Long total;

    @ApiModelProperty(value="分页列表数据")
    private List<T> list;
}