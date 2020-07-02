package com.duobaoyu.demoproject.controller;

import com.duobaoyu.demoproject.model.params.SmsTemplateQueryParamDto;
import com.duobaoyu.demoproject.model.result.PageResultDto;
import com.duobaoyu.demoproject.model.result.SmsTemplateDto;
import com.duobaoyu.demoproject.util.LogUtil;
import com.duobaoyu.middleware.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * demo API
 * 
 * @author chengchen
 * @version 1.0
 * @date 2020/7/1 15:28
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/v1/outer/demo")
@Api(tags = "demo服务接口")
@Slf4j
public class DemoController {

    @GetMapping("/templates/{id}")
    @ApiOperation("分页查询")
    public Result<PageResultDto<SmsTemplateDto>> listTemplate(@PathVariable("id") Integer id,
        SmsTemplateQueryParamDto smsTemplateQueryParamDto) {
        LogUtil.param(smsTemplateQueryParamDto);
        return Result.success().data(new PageResultDto<SmsTemplateDto>()).build();
    }


    @PostMapping("/templates/add")
    @ApiOperation("新增模板")
    public Result<PageResultDto<SmsTemplateDto>>
        addTemplate(@RequestBody SmsTemplateDto smsTemplateResultDto) {
        LogUtil.param(smsTemplateResultDto);
        return Result.success().data(new PageResultDto<SmsTemplateDto>()).build();
    }
}
