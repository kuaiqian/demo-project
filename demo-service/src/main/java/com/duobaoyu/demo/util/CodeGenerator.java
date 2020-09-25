package com.duobaoyu.demo.util;


import com.duobaoyu.middleware.repository.CodeTools;

/**
 * @program: edas-example
 * @description: 代码生成器
 * @author: guanyannan
 * @create: 2019-06-18 11:19
 */
public class CodeGenerator {

    /**
     * ★★★最关键的表名:
     */
    private final static String[] TABLE_NAMES = new String[]{
            // *************************这块代码请不要提交，使用完记得rollback ***********************
            "customer_task_plan"
    };

    public static void main(String[] args) throws Exception {
        CodeTools.genSimpleDataSource(true,true,TABLE_NAMES);
    }
}