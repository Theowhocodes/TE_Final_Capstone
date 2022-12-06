package com.techelevator.dao;

import com.techelevator.model.ShoppingGroupDto;
import com.techelevator.model.ShoppingGroup;

import java.util.List;

public interface ShoppingGroupDao {
    // SHOW ALL GROUPS A USER BELONGS TO

    List<ShoppingGroup> getAllShoppingGroupsByUser(int userId);

    // GET ONE GROUP BY ID
    ShoppingGroup getGroupById(int groupId);

    // CREATE A GROUP
    ShoppingGroup createGroup(ShoppingGroupDto newGroupDto);

    // JOIN A GROUP
    boolean joinGroup(int groupId, int userId);

    // LEAVE A GROUP
    void leaveGroup(int groupId, int userId);




}
