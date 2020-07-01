package com.duobaoyu.demoproject.model.result;

import java.io.Serializable;

import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页对象
 *
 * @author: chengchen
 * @date: 2018/12/10 17:37
 */
@Data
@ApiModel("分页参数")
public class Page implements Serializable {

    private static final long serialVersionUID = -2937537029915876600L;

    /**
     * 第几页 前端传递
     */
    @ApiModelProperty(value = "第几页")
    @Min(value = 1)
    private Integer currentPage;

    /**
     * 页面容量 前端传递
     */
    @ApiModelProperty(value = "页面容量")
    @Min(value = 1)
    private Integer pageSize;

    /**
     * 分页开始 sql使用
     */
    @ApiModelProperty(value = "冗余字段，不需要传递")
    private Integer pageStart;

    /**
     * 限制条数 sql使用
     */
    @ApiModelProperty(value = "冗余字段，不需要传递")
    private Integer limit;

    protected Page() {

    }

    public Page(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    /**
     * 初始化分页
     *
     * @param page
     *            分页
     */
    public static void initPage(Page page) {
        if (page == null) {
            page = new Page();
        }
        if (page.getCurrentPage() == null) {
            page.setCurrentPage(1);
        }
        if (page.getPageSize() == null) {
            page.setPageSize(20);
        }
        page.setPageStart((page.getCurrentPage() - 1) * page.getPageSize());
        page.setLimit(page.getPageSize());
    }

    /**
     * poi表格分页初始化方法 默认500页
     *
     * @param page
     *            分页
     */
    public static void initPagePoi(Page page) {
        if (page == null) {
            page = new Page();
        }
        if (page.getCurrentPage() == null) {
            page.setCurrentPage(1);
        }
        if (page.getPageSize() == null) {
            page.setPageSize(1000);
        }
        page.setPageStart((page.getCurrentPage() - 1) * page.getPageSize());
    }

    /**
     * 自定义分页
     *
     * @param page
     *            分页
     * @param defaultPageSize
     *            默认数量
     */
    public static void initPage(Page page, int defaultPageSize) {
        if (page == null) {
            page = new Page();
        }
        if (page.getCurrentPage() == null) {
            page.setCurrentPage(1);
        }
        if (page.getPageSize() == null) {
            page.setPageSize(defaultPageSize);
        }

    }
}
