package com.techelevator.dao;

import com.techelevator.model.Lists;
import com.techelevator.model.ListDto;

import java.util.List;


public interface ListDao {
    List <Lists> getAllListsByGroupId(int groupId);

    Lists getListByGroupId(int groupId);

    Lists getListById(int listId);

    Lists createList(ListDto listDto);

    Lists claimList(int groupId, ListDto listDto);

}

