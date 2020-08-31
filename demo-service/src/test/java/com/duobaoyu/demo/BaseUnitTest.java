package com.duobaoyu.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 单测公共父类
 *
 * @author chengchen
 * @date 2020/8/17
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BaseUnitTest {

    @Before
    public void testBefore(){
        System.out.println("==========================TEST开始");
    }

    @After
    public void testAfter(){
        System.out.println("==========================TEST结束");
    }
}
