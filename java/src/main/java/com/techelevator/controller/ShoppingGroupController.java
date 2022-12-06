package com.techelevator.controller;

import com.techelevator.dao.ShoppingGroupDao;
import com.techelevator.model.ShoppingGroup;
import com.techelevator.model.ShoppingGroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //GET all lists by user_id - I think this should go into the ShoppingGroupUsersController ?
    @GetMapping("/{userId}")
    public List <ShoppingGroup> getAllShoppingGroupsByUser(@PathVariable("userId") int userId){
        return shoppingGroupDao.getAllShoppingGroupsByUser(userId);
    }

    // CREATE NEW SHOPPING GROUP
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingGroup createGroup(@RequestBody ShoppingGroupDto shoppingGroupDto) {
        // receive ShoppingGroupDTO object -> make new ShoppingGroup object
    return shoppingGroupDao.createGroup(shoppingGroupDto);
    }
}