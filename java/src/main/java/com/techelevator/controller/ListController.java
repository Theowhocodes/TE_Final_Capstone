package com.techelevator.controller;

import com.techelevator.dao.ListDao;
import com.techelevator.model.List;
import com.techelevator.model.ListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
<<<<<<< HEAD
@RequestMapping(path = "/groups/list")
=======
@RequestMapping(path = "/lists")
>>>>>>> 8fe12aba0c0ed9d54715706d887c79c46fed16b8
public class ListController {

    @Autowired
    private ListDao listDao;

    //List getByGroupId(int groupId);
<<<<<<< HEAD
    @GetMapping("groups/{id}")
=======
    @GetMapping("/groups/{id}")
>>>>>>> 8fe12aba0c0ed9d54715706d887c79c46fed16b8
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
