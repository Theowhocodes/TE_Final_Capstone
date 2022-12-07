package com.techelevator.controller;

import com.techelevator.dao.ItemDao;
import com.techelevator.model.Item;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/items")
public class ItemController {

    private ItemDao itemDao;

    @GetMapping("/{itemId}")
    public Item getItemById(@PathVariable ("itemId") int itemId) {
        return itemDao.getItemById(itemId);
    }



}
