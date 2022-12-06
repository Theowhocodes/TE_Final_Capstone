package com.techelevator.dao;

import com.techelevator.model.Item;

import java.util.List;

public interface ItemDao {

    List<Item> listAll(int list_id);

    Item getItemById(int itemId);

    Item getItemByItemName();

    int changeQuantity(); //maybe dont need this, just use modify

    Item modifyItem();






}
