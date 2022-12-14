package com.techelevator.dao;

import com.techelevator.model.Lists;
import com.techelevator.model.ListDto;

import java.util.List;


public interface ListDao {
    List <Lists> getAllListsByGroupId(int groupId);

    Lists getListById(int listId);

    Lists createList(ListDto listDto);

    void claimList(int listId, int listOwner);

    void unclaimList(int listId);

    void clearList(int listId);

    void deleteList(int listId);

}

