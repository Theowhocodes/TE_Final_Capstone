package com.techelevator.dao;

import com.techelevator.model.Item;
import com.techelevator.model.ItemDto;

import java.util.List;

public interface ItemDao {

    List<Item> listAll(int list_id);

    Item getItemById(int itemId);

    Item getItemByItemName(String itemName);

    void changeQuantity(ItemDto itemDto); //maybe dont need this, just use modify

    Item modifyItem(ItemDto itemDto);

    void deleteItem(ItemDto itemDto);





}
