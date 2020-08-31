package com.duobaoyu.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duobaoyu.demo.model.params.DemoTemplateQueryParamDto;
import com.duobaoyu.demo.model.result.DemoTemplateDto;
import com.duobaoyu.demo.model.result.PageResultDto;
import com.duobaoyu.demo.util.LogUtil;
import com.duobaoyu.middleware.common.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 非Restful风格定义的Controller: API的url命名规范： <br/>
 * 1）类级别url路径需要和类名前缀保持一致
 *
 * 2）方法级别url命名需要和方法名保持一致
 *
 * @author chengchen
 * @date 2020/8/24
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/v1/outer/demo")
@Api(tags = "demo服务接口")
@Slf4j
public class DemoController {

    @PostMapping("/listTemplates")
    @ApiOperation("分页查询模板")
    public Result<PageResultDto<DemoTemplateDto>> listTemplates(DemoTemplateQueryParamDto smsTemplateQueryParamDto) {
        LogUtil.param(smsTemplateQueryParamDto);
        return Result.success().data(new PageResultDto<DemoTemplateDto>()).build();
    }

    @PostMapping("/getTemplate")
    @ApiOperation("单条查询模板")
    public Result<PageResultDto<DemoTemplateDto>> getTemplate(Integer id) {
        LogUtil.param(id);
        return Result.success().data(new PageResultDto<DemoTemplateDto>()).build();
    }

    @PostMapping("/addTemplate")
    @ApiOperation("新增模板")
    public Result<Boolean> addTemplate(DemoTemplateDto DemoTemplateDto) {
        LogUtil.param(DemoTemplateDto);
        return Result.success().data(Boolean.TRUE).build();
    }

    @PostMapping("/updateTemplate")
    @ApiOperation("修改模板")
    public Result<Boolean> updateTemplate(DemoTemplateDto DemoTemplateDto) {
        LogUtil.param(DemoTemplateDto);
        return Result.success().data(Boolean.TRUE).build();
    }

    @PostMapping("/deleteTemplate")
    @ApiOperation("删除模板")
    public Result<Boolean> deleteTemplate(Integer id) {
        LogUtil.param(id);
        return Result.success().data(Boolean.TRUE).build();
    }
}
