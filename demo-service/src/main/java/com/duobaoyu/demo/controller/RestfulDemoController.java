package com.duobaoyu.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.duobaoyu.demo.model.params.DemoTemplateQueryParamDto;
import com.duobaoyu.demo.model.result.DemoTemplateDto;
import com.duobaoyu.demo.model.result.PageResultDto;
import com.duobaoyu.demo.util.LogUtil;
import com.duobaoyu.middleware.common.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Restful 风格API（推荐使用）
 * HTTP METHOD：GET POST PUT DELETE 表示业务的CRUD
 * 1）GET 查询
 * 2）POST 新增
 * 3）PUT 更新
 * 4）DELETE 删除
 *
 * URL路径体现资源访问
 *
 * demo API 请描述该类具体的作用
 * @author chengchen
 * @date 2020/7/1 15:28
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/v1/outer/demo")
@Api(tags = "demo服务接口")
@Slf4j
public class RestfulDemoController {

    @GetMapping("/templates")
    @ApiOperation("分页查询")
    public Result<PageResultDto<DemoTemplateDto>> listTemplate(DemoTemplateQueryParamDto smsTemplateQueryParamDto) {
        LogUtil.param(smsTemplateQueryParamDto);
        return Result.success().data(new PageResultDto<DemoTemplateDto>()).build();
    }

    @GetMapping("/templates/{id}")
    @ApiOperation("分页查询")
    public Result<DemoTemplateDto> getTemplate(Integer id) {
        LogUtil.param(id);
        return Result.success().data(new DemoTemplateDto()).build();
    }

    @PostMapping("/templates")
    @ApiOperation("新增模板")
    public Result<Boolean> addTemplate(@RequestBody DemoTemplateDto smsTemplateResultDto) {
        LogUtil.param(smsTemplateResultDto);
        return Result.success().data(Boolean.TRUE).build();
    }

    @DeleteMapping("/templates/{id}")
    @ApiOperation("删除模板")
    public Result<Boolean> deleteTemplate(@PathVariable("id") Integer id) {
        return Result.success().data(Boolean.TRUE).build();
    }

    @PutMapping("/templates/{id}")
    @ApiOperation("更新模板")
    public Result<Boolean> updateTemplate(@PathVariable("id") Integer id, DemoTemplateDto smsTemplateResultDto) {
        LogUtil.param(smsTemplateResultDto);
        return Result.success().data(Boolean.TRUE).build();
    }
}
