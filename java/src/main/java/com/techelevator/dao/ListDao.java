package com.techelevator.dao;

import com.techelevator.model.List;

import java.util.List;

public interface ListDao {

    List<List> getByGroupId(int groupId);

    List createList(List list);

    List claimList(int groupId);

}