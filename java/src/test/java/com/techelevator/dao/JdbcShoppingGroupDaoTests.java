package com.techelevator.dao;

import com.techelevator.model.ShoppingGroup;
import com.techelevator.model.ShoppingGroupDto;
import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcShoppingGroupDaoTests extends BaseDaoTests {
    protected static final User USER_1 = new User(1, "testuser1", "12345", "ROLE_USER");
    protected static final User USER_2 = new User(2, "testuser2", "12345", "ROLE_USER");

    protected static final ShoppingGroup GROUP_1 = new ShoppingGroup(1, "test group 1", "2022-12-12");
    protected static final ShoppingGroup GROUP_2 = new ShoppingGroup(2, "test group 2", "2022-12-12");

    protected static final ShoppingGroupDto GROUP_DTO = new ShoppingGroupDto();
    protected static final ShoppingGroupDto GROUP_DTO2 = new ShoppingGroupDto();

    private JdbcShoppingGroupDao sut;

    @Before
    public void setup(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcShoppingGroupDao(jdbcTemplate);

    }

    @Test
    public void createGroup_Returns_Proper_GroupId(){

        GROUP_DTO.setGroupId(GROUP_1.getGroupId());
        GROUP_DTO.setGroupName(GROUP_1.getGroupName());
        GROUP_DTO.setInvitationCode(GROUP_1.getInvitationCode());

        ShoppingGroup groupId = sut.createGroup(GROUP_DTO);

        Assert.assertEquals(1, groupId.getGroupId());

    }

    @Test
    public void getAllShoppingGroups_Returns_Groups_Involving_User(){
        int inviteCode = 9651;

        GROUP_DTO.setGroupId(GROUP_1.getGroupId());
        GROUP_DTO.setGroupName(GROUP_1.getGroupName());
        GROUP_DTO.setInvitationCode(GROUP_1.getInvitationCode());

        ShoppingGroup fakeGroup = sut.createGroup(GROUP_DTO);

        sut.joinGroup(fakeGroup.getGroupId(), USER_1.getId());

        GROUP_DTO2.setGroupId(GROUP_2.getGroupId());
        GROUP_DTO2.setInvitationCode(inviteCode);
        GROUP_DTO2.setGroupName(GROUP_2.getGroupName());

        ShoppingGroup fakeGroup2 = sut.createGroup(GROUP_DTO2);


        sut.joinGroup(fakeGroup2.getGroupId(), USER_1.getId());

        List<ShoppingGroup> userGroups = sut.getAllShoppingGroupsByUser(USER_1.getId());

        Assert.assertEquals(2, userGroups.size());

    }

    @Test
    public void getGroupById_Returns_Correct_Group(){
        GROUP_DTO.setGroupId(GROUP_1.getGroupId());
        GROUP_DTO.setGroupName(GROUP_1.getGroupName());
        GROUP_DTO.setInvitationCode(GROUP_1.getInvitationCode());

        ShoppingGroup fake = sut.createGroup(GROUP_DTO);

        Assert.assertEquals(GROUP_1.getGroupName(), sut.getGroupById(fake.getGroupId()).getGroupName());

    }
}
