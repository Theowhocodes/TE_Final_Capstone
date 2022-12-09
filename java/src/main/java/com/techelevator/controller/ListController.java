package com.techelevator.controller;

import com.techelevator.dao.ListDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Lists;
import com.techelevator.model.ListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin

@RequestMapping(path = "/groups/lists")
public class ListController {

    @Autowired
    private ListDao listDao;
    @Autowired
    private UserDao userDao;

    // get one list by group id
    @GetMapping("/list/{groupId}")
    public Lists getByGroupId(@PathVariable("id") int groupId) {
        return listDao.getListByGroupId(groupId);
    }

    // show all lists belonging to one group
    @GetMapping("/{groupId}")
    public List <Lists> getAllListsByGroupId(@PathVariable("groupId") int groupId){
        return listDao.getAllListsByGroupId(groupId);
    }

    // create a new list
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Lists createList(@Valid @RequestBody ListDto listDto) {
        return listDao.createList(listDto);
    }

    @PutMapping("/{listId}/claim")
    public void claimList(@RequestBody @PathVariable("listId") int listId, Principal principal){
        listDao.claimList(listId, userDao.findIdByUsername(principal.getName()));

    }

    @PutMapping("/{listId}/unclaim")
    public void unclaimList(@RequestBody @PathVariable("listId") int listId){
        listDao.unclaimList(listId);

    }

}
