package com.techelevator.dao;

import com.techelevator.model.Lists;
import com.techelevator.model.ListDto;

import java.util.List;


public interface ListDao {
    List <Lists> getAllListsByGroupId(int groupId);

<<<<<<< HEAD
    Lists getByGroupId(int groupId);

    Lists createList(ListDto listDto);

    Lists claimList(int groupId, ListDto listDto);

}
=======
    Lists getListByGroupId(int groupId);

    Lists getListById(int listId);

    Lists createList(ListDto listDto);

    Lists claimList(int groupId, ListDto listDto);
>>>>>>> 8f884ce7c0a5d954495fecd4dce5d6e54fddba82

