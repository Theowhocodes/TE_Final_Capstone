package com.techelevator.controller;

import com.techelevator.dao.ItemDao;
import com.techelevator.model.Item;
import com.techelevator.model.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/items")
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @GetMapping("/{itemId}")
    public Item getItemById(@PathVariable("itemId") int itemId) {
        return itemDao.getItemById(itemId);
    }

    @GetMapping("/list/{listId}")
    public List<Item> listAllItemsInList(@PathVariable("listId") int listId) {
        return itemDao.listAll(listId);
    }

    @GetMapping("/name/{itemName}")
    public Item getItemByItemName(@PathVariable("itemName") String itemName) {
        return itemDao.getItemByItemName(itemName);
    }

    @PutMapping("/{itemId}/quantity")
    public Item changeQuantity(@PathVariable("itemId") int itemId, @Valid @RequestBody ItemDto itemDto) {
        Item item = itemDao.getItemById(itemId);

        if(item.getItemQuantity() != itemDto.getItemQuantity() && itemDto.getItemQuantity() > 0) {
            item.setItemQuantity(itemDto.getItemQuantity());
        }
        return item;
    }

    @PostMapping("")//not sure this is what the path should be
    public Item createItem(ItemDto itemDto) {
        return itemDao.createItem(itemDto);
    }

//
//    @DeleteMapping("/{itemId}")
//    public void deleteItem(@PathVariable("itemId") int itemId) {
//
//    }





}
