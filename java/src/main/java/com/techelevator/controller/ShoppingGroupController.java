package com.techelevator.controller;

import com.techelevator.dao.ShoppingGroupDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.ShoppingGroup;
import com.techelevator.model.ShoppingGroupDto;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/groups")
public class ShoppingGroupController {

    @Autowired
    private ShoppingGroupDao shoppingGroupDao;
    @Autowired
    private UserDao userDao;

    // get one shopping group by group_id
    @GetMapping("/{groupId}")
    public ShoppingGroup getGroupById(@PathVariable("groupId") int groupId) {
        return shoppingGroupDao.getGroupById(groupId);
    }

    // get one shopping group by invitation_code
    @GetMapping("/invitation/{invitationCode}")
    public ShoppingGroup getGroupByInvitationCode(@PathVariable("invitationCode") int invitationCode){
        return shoppingGroupDao.getGroupByInvitationCode(invitationCode);
    }

    //get list of all groups by user_id

    @GetMapping("/users/{userId}")
    public List <ShoppingGroup> getAllShoppingGroupsByUser(Principal principal){
        return shoppingGroupDao.getAllShoppingGroupsByUser(userDao.findIdByUsername(principal.getName()));
    }
    //@GetMapping("/users/{userId}")
    //public List <ShoppingGroup> getAllShoppingGroupsByUser(@PathVariable("userId") int userId){
        //return shoppingGroupDao.getAllShoppingGroupsByUser(userId);
    //}

    // join a group
    @PostMapping("/{groupId}/join")
    @ResponseStatus(HttpStatus.OK)
    public void joinGroup(@RequestBody @PathVariable("groupId") int groupId, Principal principal){
         shoppingGroupDao.joinGroup(groupId, userDao.findIdByUsername(principal.getName()));
        

    }

    // create new shopping group
   @PostMapping("/create")
   @ResponseStatus(HttpStatus.CREATED)
   public ShoppingGroup createGroup(@Valid @RequestBody ShoppingGroupDto shoppingGroupDto, Principal principal) {
       // receive ShoppingGroupDTO object -> make new ShoppingGroup object
        if (shoppingGroupDto.getGroupName().length() > 0) {
       ShoppingGroup newGroup = shoppingGroupDao.createGroup(shoppingGroupDto);
       // after creating group, insert user as the first member
       shoppingGroupDao.joinGroup(newGroup.getGroupId(), userDao.findIdByUsername(principal.getName()));
       return newGroup; } else{
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
       }
       }

   // leave a group
    @DeleteMapping("/{groupId}/leave")
    public void leaveGroup(@PathVariable("groupId") int groupId, Principal principal) {
        shoppingGroupDao.leaveGroup(groupId, userDao.findIdByUsername(principal.getName()));
    }

    // get all usernames by groupId
    @GetMapping("/{groupId}/users")
    public List<User> getAllUsersByGroupId(@PathVariable("groupId") int groupId){
       return userDao.findAllUsersByGroupId(groupId);
    }



   }

