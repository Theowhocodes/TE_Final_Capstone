package com.techelevator.dao;

import com.techelevator.model.List;



public interface ListDao {

    List getByGroupId(int groupId);

    List createList(List list);

    List claimList(int groupId);

}