package com.javakz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
 * @Description: 这是set类型操作测试类
 * @Date: Create in 19:07 2018/7/25
 * @Modified By: 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-redis.xml")
public class TestSet {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue() {
        redisTemplate.boundSetOps("name").add("111");
        redisTemplate.boundSetOps("name").add("222");
        redisTemplate.boundSetOps("name").add("333");
        redisTemplate.boundSetOps("name").add("444");
        redisTemplate.boundSetOps("name").add("555");
    }
    @Test
    public void getValue() {
        // set: 无序的 不重复
        Set members = redisTemplate.boundSetOps("name").members();
        System.out.println(members);
    }

    @Test
    public void delOneValue() {
        redisTemplate.boundSetOps("name").remove("333");
    }

    @Test
    public void delAllValue() {
        redisTemplate.delete("name");
    }
}
