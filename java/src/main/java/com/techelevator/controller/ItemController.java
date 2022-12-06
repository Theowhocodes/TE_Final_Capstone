package com.techelevator.controller;

import com.techelevator.dao.ItemDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ItemController {

    private ItemDao itemDao;


}
