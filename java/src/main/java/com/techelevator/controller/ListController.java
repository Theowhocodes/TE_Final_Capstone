package com.techelevator.controller;

import com.techelevator.dao.ItemDao;
import com.techelevator.dao.ListDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Lists;
import com.techelevator.model.ListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
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
    @Autowired
    private ItemDao itemDao;

    //get one list by listId
    @GetMapping("/list/{listId}")
    public Lists getListByID(@PathVariable("listId") int listId){
        return listDao.getListById(listId);
    }

//    // get one list by group id
//    @GetMapping("/list/{groupId}")
//    public Lists getByGroupId(@PathVariable("id") int groupId) {
//        return listDao.getListByGroupId(groupId);
//    }

    // show all lists belonging to one group
    @GetMapping("/{groupId}")
    public List <Lists> getAllListsByGroupId(@PathVariable("groupId") int groupId){
        return listDao.getAllListsByGroupId(groupId);
    }

    // create a new list
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Lists createList(@Valid @RequestBody ListDto listDto) {
        if (listDto.getListName().length() > 0) {
            return listDao.createList(listDto);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    // claim a list
    @PutMapping("/{listId}/claim")
    public void claimList(@RequestBody @PathVariable("listId") int listId, Principal principal){
        listDao.claimList(listId, userDao.findIdByUsername(principal.getName()));

    }

    // unclaim a list
    @PutMapping("/{listId}/unclaim")
    public void unclaimList(@RequestBody @PathVariable("listId") int listId){
        listDao.unclaimList(listId);

    }

    // clear all items from a list
    @DeleteMapping("/list/{listId}/clear")
    public void clearList(@PathVariable("listId") int listId){
        listDao.clearList(listId);
    }

    @DeleteMapping("/list/{listId}/delete")
    public boolean deleteList(@PathVariable("listId") int listId, Principal principal) {
        if(!listDao.getListById(listId).isClaimed()) {
            return false;
        } else if (!(principal.getName()).equals(listDao.getListById(listId).getListOwnerName())) {
            return false;
        } else {
            listDao.clearList(listId);
            listDao.deleteList(listId);
        } return true;

    }
}
