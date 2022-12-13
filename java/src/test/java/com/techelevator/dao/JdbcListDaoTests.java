package com.techelevator.dao;

import com.techelevator.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class JdbcListDaoTests extends BaseDaoTests{
    protected static final User USER_1 = new User(1, "testuser1", "12345", "ROLE_USER");
    protected static final User USER_2 = new User(2, "testuser2", "12345", "ROLE_USER");

    protected static final ShoppingGroup GROUP_1 = new ShoppingGroup(1, "test group 1", "2022-12-12");
    protected static final ShoppingGroup GROUP_2 = new ShoppingGroup(2, "test group 2", "2022-12-12");

    protected static final ShoppingGroupDto GROUP_DTO = new ShoppingGroupDto();
    protected static final ShoppingGroupDto GROUP_DTO2 = new ShoppingGroupDto();


    protected static final Lists LIST_1 = new Lists(1,"list1",1,false,1,false,1,USER_1.getUsername());
    protected static final Lists LIST_2 = new Lists(2,"list2",1,false,2,false,2,null);

    private ListDto listDto = new ListDto();

    private JdbcListDao sut;
    private JdbcShoppingGroupDao sut2;

    @Before
    public void setup(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcListDao(jdbcTemplate);

        JdbcTemplate jdbcTemplate2 = new JdbcTemplate(dataSource);
        sut2 = new JdbcShoppingGroupDao(jdbcTemplate2);

        GROUP_DTO.setGroupName(GROUP_1.getGroupName());
        GROUP_DTO.setGroupId(GROUP_1.getGroupId());
        GROUP_DTO.setInvitationCode(GROUP_1.getInvitationCode());

        listDto.setGroupId(GROUP_1.getGroupId());
        listDto.setListName(LIST_1.getListName());
        listDto.setListId(LIST_1.getListId());
        listDto.setClaimed(LIST_1.isClaimed());
        listDto.setListOwner(USER_1.getId());
        listDto.setListOwnerName(USER_1.getUsername());

    }

    @Test
    public void createList_Returns_Correct_List_Info(){
        sut2.createGroup(GROUP_DTO);

        Lists newList1 = sut.createList(listDto);

        Assert.assertEquals(LIST_1.getListId(), newList1.getListId());
    }

    @Test
    public void getAllListsByGroupId_Returns_Only_Groups_Lists(){
        ShoppingGroup groupId = sut2.createGroup(GROUP_DTO);
        sut.createList(listDto);

        List<Lists> testList = sut.getAllListsByGroupId(groupId.getGroupId());

        Assert.assertEquals(1, testList.size());

    }

    @Test
    public void getListById_Returns_Correct_Listing(){
        sut2.createGroup(GROUP_DTO);
        listDto.setListOwnerName(USER_1.getUsername());
        listDto.setListId(LIST_1.getListId());
        sut.createList(listDto);

        Lists newListID = sut.getListById(1);

        Assert.assertNotNull(newListID);
        Assert.assertEquals(LIST_1.getListId(), newListID.getListId());
    }


}
