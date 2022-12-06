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
    public List<ShoppingGroup> getAllShoppingGroups(int userId) {
        List<ShoppingGroup> shoppingGroups = new ArrayList<>();
        String sql = "SELECT group_name, date_joined FROM shopping_group" +
                "JOIN shopping_group_users USING (group_id)" +
                "JOIN USERS USING (user_id)" +
                "WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            //shoppingGroups.add(mapRowToShoppingGroup(results));   // map to ShoppingGroup object
        }
        return shoppingGroups;

    }

    @Override
    public boolean createGroup(ShoppingGroupDto newGroupDto) {

        String sql = "INSERT into shopping_group (group_name, invitation_code) values (?, 100)";

        Integer newGroupId = jdbcTemplate.queryForObject(sql, Integer.class, newGroupDto.getGroupName());

        return newGroupId != null;
    } //is this right or are we returning a shopping group object?

    @Override
    public boolean joinGroup(int groupId, int userId) {

        String sql = "INSERT INTO shopping_group_users (group_id, user_id) VALUES (?, ?) " +
                    "RETURNING shopping_group_users_id";

        Integer shoppingGroupUsersId = jdbcTemplate.queryForObject(sql, Integer.class, groupId, userId)

        return shoppingGroupUsersId != null;
    }

    @Override
    public ShoppingGroup leaveGroup() {
        return null;
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
    private ShoppingGroup mapRowToShoppingGroup(SqlRowSet rowSet) {
        ShoppingGroup shoppingGroup = new ShoppingGroup();
        shoppingGroup.setGroupName(rowSet.getString("group_name"));
        shoppingGroup.setDateJoined(LocalDate.parse(rowSet.getString("date_joined")));
        return shoppingGroup;

    }
}
