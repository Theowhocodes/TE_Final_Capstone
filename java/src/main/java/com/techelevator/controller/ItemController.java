package com.techelevator.controller;

import com.techelevator.dao.ItemDao;
import com.techelevator.model.Item;
import com.techelevator.model.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/items/")
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @GetMapping("{itemId}")//worked in postman
    public Item getItemById(@PathVariable("itemId") int itemId) {
        return itemDao.getItemById(itemId);
    }

    @GetMapping("list/{listId}")//worked in postman
    public List<Item> listAllItemsInList(@PathVariable("listId") int listId) {
        return itemDao.listAll(listId);
    }

    @GetMapping("name/{itemName}")//worked in postman
    public Item getItemByItemName(@PathVariable("itemName") String itemName) {
        return itemDao.getItemByItemName(itemName);
    }

    @PutMapping("{itemId}/quantity")//worked in postman
    public Item changeQuantity(@PathVariable("itemId") int itemId, @Valid @RequestBody ItemDto itemDto) {
        Item item = itemDao.getItemById(itemId);

        if(item.getItemQuantity() != itemDto.getItemQuantity() && itemDto.getItemQuantity() > 0) {
            item.setItemQuantity(itemDto.getItemQuantity());
        }
        return item;
    }

    @PostMapping("/create")//not sure this is what the path should be
    @ResponseStatus(HttpStatus.CREATED)//worked in postman
    public void createItem( @Valid @RequestBody ItemDto itemDto) {
        if (itemDto.getItemName().length() > 0 && itemDto.getItemQuantity() > 0) {
            itemDao.createItem(itemDto);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{itemId}/modify")//worked in postman
    public Item modifyItem(@Valid @RequestBody ItemDto itemDto) {
       return itemDao.modifyItem(itemDto);
    }

    @DeleteMapping("/{itemId}/delete")//worked in postman
    public void deleteItem(@PathVariable("itemId") int itemId) {
        itemDao.deleteItem(itemId);
    }

}
