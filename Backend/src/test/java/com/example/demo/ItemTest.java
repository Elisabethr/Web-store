package com.example.demo;

import org.junit.Assert;
import org.junit.Test;


public class  ItemTest {

    @Test
    public void itemTests() {
        Item item = new Item();
        item.setName("koer");
        //item.getImageAddress("https://lauhingman");
        item.setPrice(200);
        item.setCategory("koerlased");
        item.setDescription("karvane");
        Assert.assertEquals(item.getName(), "koer");
        Assert.assertEquals(item.getPrice(), 200);
        Assert.assertEquals(item.getCategory(), "koerlased");
        Assert.assertEquals(item.getDescription(), "karvane");
    }

}