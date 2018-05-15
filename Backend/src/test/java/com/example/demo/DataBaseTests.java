package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class DataBaseTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void databaceTest() {
        Item item1 = new Item();
        item1.setName("koer");
        System.out.println(jdbcTemplate);
        jdbcTemplate.update("insert into items value item " );

        Item item =  jdbcTemplate.queryForObject("select * from student", new Object[] {},
                new BeanPropertyRowMapper< Item >(Item.class));
        Assert.assertEquals(item.getName(), item1.getName());
    }

}


