package com.techelevator.dao;

import com.techelevator.model.Item;
import com.techelevator.model.ItemDto;
import com.techelevator.model.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class JdbcItemDaoTests extends BaseDaoTests{


    protected static final Lists LIST_1 = new Lists(1,"list1",1,false,1,false,1, "testUser1");

    private JdbcItemDao sut;
    private JdbcUserDao sut2;

    private ItemDto itemDto = new ItemDto();

    @Before
    public void setup(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcItemDao(jdbcTemplate, sut2);
        itemDto.setListId(1);
        itemDto.setItemName("Pencils");
        itemDto.setItemQuantity(5);
        itemDto.setAddedBy(1);
        itemDto.setDateAdded((Date.valueOf("2022-12-13")));
        sut.createItem(itemDto);
    }

    @Test
    public void modifyItem_Updates_Correct_Item(){
        itemDto.setItemQuantity(3);
        Item ITEM_1 = sut.modifyItem(itemDto);


        Assert.assertEquals(3, ITEM_1.getItemQuantity());
    }
}
