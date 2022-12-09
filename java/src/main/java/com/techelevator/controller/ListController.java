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

<<<<<<< HEAD

    @GetMapping({"/lists/{id}"})
    public Lists getByGroupId(@PathVariable("id") int groupId) {
        return listDao.getByGroupId(groupId);
    }

    @GetMapping("/{groupId}")
    public List<Lists> getAllListsByGroupId(@PathVariable("groupId") int groupId) {
        return listDao.getAllListsByGroupId(groupId);
    }

    //List createList(List list);
    @PostMapping("/path")
=======
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
>>>>>>> 8f884ce7c0a5d954495fecd4dce5d6e54fddba82
    @ResponseStatus(HttpStatus.CREATED)
    public Lists createList(@RequestBody ListDto listDto) {
        return listDao.createList(listDto);
    }

    //List claimList(int groupId);
<<<<<<< HEAD
    @GetMapping("/somethingdifferent/{id}")
    public Lists claimList(@RequestBody ListDto listDto, @PathVariable("id") int groupId) {
=======
    @GetMapping("/{listId}/claim")
    public Lists claimList(@RequestBody ListDto listDto, @PathVariable("id") int groupId){
>>>>>>> 8f884ce7c0a5d954495fecd4dce5d6e54fddba82
        listDao.claimList(groupId, listDto);
        return getByGroupId(groupId);
    }
}
