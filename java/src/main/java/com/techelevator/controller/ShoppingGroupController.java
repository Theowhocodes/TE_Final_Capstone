package com.techelevator.controller;

import com.techelevator.dao.ShoppingGroupDao;
import com.techelevator.model.ShoppingGroup;
import com.techelevator.model.ShoppingGroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/groups")
public class ShoppingGroupController {

    @Autowired
    private ShoppingGroupDao shoppingGroupDao;

    // GET one shopping group by group_id
    @GetMapping("/{id}")
    public ShoppingGroup getGroupById(@PathVariable("id") int groupId) {
        return shoppingGroupDao.getGroupById(groupId);
    }

    // CREATE NEW SHOPPING GROUP
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingGroup createGroup(@RequestBody ShoppingGroupDto shoppingGroupDto) {
        // receive ShoppingGroupDTO object -> make new ShoppingGroup object
    return shoppingGroupDao.createGroup(shoppingGroupDto);
    }
}