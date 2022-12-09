package com.techelevator.controller;

import com.techelevator.dao.ListDao;
import com.techelevator.model.Lists;
import com.techelevator.model.ListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

@RequestMapping(path = "/groups/lists")
public class ListController {

    @Autowired
    private ListDao listDao;


    @GetMapping({"/list/{id}"})
    public Lists getByGroupId(@PathVariable("id") int groupId) {
        return listDao.getByGroupId(groupId);
    }

    //show all lists belonging to one group
    @GetMapping("/{groupId}")
    public List <Lists> getAllListsByGroupId(@PathVariable("groupId") int groupId){
    return listDao.getAllListsByGroupId(groupId);
    }

    //List createList(List list);
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Lists createList(@RequestBody ListDto listDto) {
        return listDao.createList(listDto);
    }

    //List claimList(int groupId);
    @GetMapping("/somethingdifferent/{id}")
    public Lists claimList(@RequestBody ListDto listDto, @PathVariable("id") int groupId){
        listDao.claimList(groupId, listDto);
        return getByGroupId(groupId);
    }



}
