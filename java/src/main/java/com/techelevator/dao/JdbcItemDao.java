package com.techelevator.dao;

import com.techelevator.model.Item;

import java.util.List;

public class JdbcItemDao implements ItemDao {

    public List<Item> listAll() {
        return null;
    }

    public Item getItemById() {
        return null;
    }

    public Item getItemByItemName() {
        return null;
    }

    public int changeQuantity() {//maybe dont need this, just use modify
        return 0;
    }

    public Item modifyItem() {
        return null;
    }

    public Item mapRowToItem() {
        return null;
    }
}
