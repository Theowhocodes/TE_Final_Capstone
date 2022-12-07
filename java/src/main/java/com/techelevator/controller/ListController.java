package com.techelevator.controller;

import com.techelevator.dao.ListDao;
import com.techelevator.model.List;
import com.techelevator.model.ListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "home/group{id}/list{id}")
public class ListController {

    @Autowired
    private ListDao listDao;

    //List getByGroupId(int groupId);
    @GetMapping("/{id}")
    public List getByGroupId(@PathVariable("id") int groupId) {
        return listDao.getByGroupId(groupId);
    }

    //List createList(List list);
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public List createList(@RequestBody ListDto listDto) {
        return listDao.createList(listDto);
    }

    //List claimList(int groupId);
    @GetMapping("/{id}")
    public List claimList(@RequestBody ListDto listDto, @PathVariable int groupId){
        listDao.claimList(groupId, listDto);
        return getByGroupId(groupId);
    }



}
