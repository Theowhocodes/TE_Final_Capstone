package com.techelevator.dao;

import com.techelevator.model.List;
import com.techelevator.model.ListDto;


public interface ListDao {

    List getByGroupId(int groupId);

    List createList(ListDto listDto);

    List claimList(int groupId, ListDto listDto);

}