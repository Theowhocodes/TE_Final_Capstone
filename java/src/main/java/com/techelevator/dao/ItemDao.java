package com.techelevator.dao;

import com.techelevator.model.Item;

import java.util.List;

public interface ItemDao {

    List<Item> listAll();

    Item getItemById();

    Item getItemByItemName();

    int changeQuantity(); //maybe dont need this, just use modify

    Item modifyItem();






}
