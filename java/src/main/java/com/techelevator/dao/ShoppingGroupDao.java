package com.techelevator.dao;

import com.techelevator.model.ShoppingGroup;

import java.util.List;

public interface ShoppingGroupDao {
    // SHOW ALL GROUPS A USER BELONGS TO

    List<ShoppingGroup> getAllShoppingGroups(int userId);

    // CREATE A GROUP
    ShoppingGroup createGroup();

    // JOIN A GROUP
    ShoppingGroup joinGroup();

    // LEAVE A GROUP
    ShoppingGroup leaveGroup();


}
