package com.javakz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 *  .--,       .--,
 * ( (  \.---./  ) )
 *  '.__/o   o\__.'
 *     {=  ^  =}
 *      >  -  <
 *     /       \
 *    //       \\
 *   //|   .   |\\
 *   "'\       /'"_.-~^`'-.
 *      \  _  /--'         `
 *    ___)( )(___
 *   (((__) (__)))    高山仰止,景行行止.虽不能至,心向往之。
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * @Author: yandq
 * @Description: 这是list类型操作测试类
 * @Date: Create in 19:20 2018/7/25
 * @Modified By: 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-redis.xml")
public class TestList {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 左压栈：后添加的对象排在前边
     */
    @Test
    public void setLeftValue() {
        redisTemplate.boundListOps("name").leftPush("111");
        redisTemplate.boundListOps("name").leftPush("222");
        redisTemplate.boundListOps("name").leftPush("333");
        redisTemplate.boundListOps("name").leftPush("444");
        redisTemplate.boundListOps("name").leftPush("555");
    }

    /**
     * 显示左压栈集合
     */
    @Test
    public void getLeftValue() {
        // list: 有序的 可重复
        List list = redisTemplate.boundListOps("name").range(0,10);
        System.out.println(list);
    }

    /**
     * 右压栈：后添加的对象排在后边
     */
    @Test
    public void setRightValue() {
        redisTemplate.boundListOps("name2").rightPush("111");
        redisTemplate.boundListOps("name2").rightPush("222");
        redisTemplate.boundListOps("name2").rightPush("333");
        redisTemplate.boundListOps("name2").rightPush("444");
        redisTemplate.boundListOps("name2").rightPush("555");
    }

    /**
     * 显示右压栈集合
     */
    @Test
    public void getRightValue() {
        // list: 有序的 可重复
        List list = redisTemplate.boundListOps("name2").range(0,10);
        System.out.println(list);
    }

    /**
     * 根据索引查询元素
     */
    @Test
    public void searchValueByIndex() {
        String str = (String)redisTemplate.boundListOps("name").index(1);
        System.out.println(str);
    }

    /**
     * 移除集合某个元素
     */
    @Test
    public void removeByIndex() {
        redisTemplate.boundListOps("name").remove(1,"555");
    }

    /**
     * 删除所有
     */
    @Test
    public void delAllValue() {
        redisTemplate.delete("name2");
    }
}
