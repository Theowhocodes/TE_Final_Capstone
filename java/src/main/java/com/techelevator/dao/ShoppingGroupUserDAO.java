package com.techelevator.dao;

import com.techelevator.model.ShoppingGroup;
import com.techelevator.model.ShoppingGroupDto;

import java.util.List;

public interface ShoppingGroupUserDAO {

    // Retrieve all groups user belongs to

    List<ShoppingGroup> getAllShoppingGroupsByUser(int userId);

    // Create a new shopping Group
    boolean createGroup(String groupName, int userId);

    // Join a shopping Group
    boolean joinGroup(int groupId, int userId);

    // Leave a shopping group
    void leaveGroup(int groupId, int userId);



}
