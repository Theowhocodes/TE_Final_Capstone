package com.techelevator.dao;

import com.techelevator.model.ShoppingGroupDto;
import com.techelevator.model.ShoppingGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcShoppingGroupDao implements ShoppingGroupDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    private ShoppingGroupDao shoppingGroupDao;

    public JdbcShoppingGroupDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Get list of all user's groups by userId
    //@Override

   public List<ShoppingGroup> getAllShoppingGroupsByUser(int userId) {
        List<ShoppingGroup> shoppingGroups = new ArrayList<>();
        String sql = "SELECT group_id, group_name, invitation_code, to_char(date_joined,'mm-dd-yy')AS member_since FROM shopping_group_users " +
                "JOIN shopping_group USING (group_id) " +
                "JOIN users USING (user_id) " +
                "WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            shoppingGroups.add(mapRowToShoppingGroupWithMemberSince(results));   // map to ShoppingGroup object
        }
        return shoppingGroups;
    }

    /*
    public List<ShoppingGroup> getAllShoppingGroupsByUser(int userId) {
        List<ShoppingGroup> shoppingGroups = new ArrayList<>();
        String sql = "SELECT group_id, group_name, invitation_code, (current_date - date_joined)AS membership_age FROM shopping_group_users " +
                "JOIN shopping_group USING (group_id) " +
                "JOIN users USING (user_id) " +
                "WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            shoppingGroups.add(mapRowToShoppingGroup(results));   // map to ShoppingGroup object
        }
        return shoppingGroups;
    } */

    // GET ONE GROUP BY ID
    @Override
    public ShoppingGroup getGroupById(int groupId) {
        ShoppingGroup singleShoppingGroup = new ShoppingGroup();
        String sql = "SELECT group_id, group_name, invitation_code FROM shopping_group WHERE group_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, groupId);
        if (results.next()) {
            singleShoppingGroup = mapRowToShoppingGroup(results);
        }

        return singleShoppingGroup;
    }

    @Override
    public ShoppingGroup createGroup(ShoppingGroupDto shoppingGroupDto) {
        String sql = "INSERT into shopping_group (group_name, invitation_code) values (?, ?) "
                + "RETURNING group_id";
        Integer newShoppingGroupId = jdbcTemplate.queryForObject(sql, Integer.class, shoppingGroupDto.getGroupName(), shoppingGroupDto.getInvitationCode());

        return shoppingGroupDao.getGroupById(newShoppingGroupId);
    }

    @Override
    public boolean joinGroup(int groupId, int userId) {

        String sql = "INSERT INTO shopping_group_users (group_id, user_id) VALUES (?, ?) " +
                    "RETURNING shopping_group_users_id";

        Integer shoppingGroupUsersId = jdbcTemplate.queryForObject(sql, Integer.class, groupId, userId);

        return shoppingGroupUsersId != null;
    }//do we need a separate DAO for shopping_group_users???

    @Override
    public void leaveGroup(int groupId, int userId) {

        String sql = "DELETE FROM shopping_group_users WHERE (group_id = ? and user_id = ?";

    }

    // Join a shopping group
//    public boolean joinGroup(int groupId, int userId){
//        String sql = "INSERT INTO SHOPPING_GROUP_USERS (group_id, user_id)" +
//                "VALUES ((SELECT group_id FROM shopping_group WHERE group_id = '?')," +
//                "(SELECT user_id FROM  users WHERE user_id = '?'))" +
//                "RETURNING shopping_group_users_id";
//        Integer shoppingGroupUserId = 0;
//        return true;
  //  }

    private ShoppingGroup mapRowToShoppingGroupWithMemberSince(SqlRowSet rowSet) {
        ShoppingGroup shoppingGroup = new ShoppingGroup();
        shoppingGroup.setGroupId(rowSet.getInt("group_id"));
        shoppingGroup.setGroupName(rowSet.getString("group_name"));
        shoppingGroup.setInvitationCode(rowSet.getInt("invitation_code"));
        shoppingGroup.setMemberSince(rowSet.getString("member_since"));
        //shoppingGroup.setMembershipAge(rowSet.getInt("membership_age"));

        return shoppingGroup;

    }

    private ShoppingGroup mapRowToShoppingGroup(SqlRowSet rowSet) {
        ShoppingGroup shoppingGroup = new ShoppingGroup();
        shoppingGroup.setGroupId(rowSet.getInt("group_id"));
        shoppingGroup.setGroupName(rowSet.getString("group_name"));
        shoppingGroup.setInvitationCode(rowSet.getInt("invitation_code"));

        return shoppingGroup;

    }
}
