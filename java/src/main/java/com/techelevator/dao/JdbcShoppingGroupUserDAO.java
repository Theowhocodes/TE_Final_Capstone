package com.techelevator.dao;

import com.techelevator.model.ShoppingGroup;
import com.techelevator.model.ShoppingGroupDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcShoppingGroupUserDAO implements ShoppingGroupUserDAO{

    private final JdbcTemplate jdbcTemplate;

    public JdbcShoppingGroupUserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ShoppingGroup> getAllShoppingGroupsByUser(int userId) {
        List<ShoppingGroup> allGroups = new ArrayList<>();
        String sql = "select group_name from shopping_group " +
                "JOIN shopping_group_users USING (group_id) " +
                "WHERE user_id = ? ;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        if(rowSet.next()){
            ShoppingGroup shoppingGroup = mapRowToShoppingGroup(rowSet);
            allGroups.add(shoppingGroup);
        }

        return allGroups;
    }

    @Override
    public boolean createGroup(String groupName, int userId) {
        String sql = "INSERT INTO shopping_group(group_name) " +
                "VALUES (?) returning group_id;";
        Integer groupId = jdbcTemplate.queryForObject(sql, Integer.class, groupName);

        String sql2 = "INSERT INTO shopping_group_users(group_id, user_id) " +
                "VALUES (?, ?);";
        jdbcTemplate.queryForObject(sql2, Integer.class, userId, groupId);

        return false;
    }

    @Override
    public boolean joinGroup(int groupId, int userId) {
        String sql = "INSERT INTO shopping_group_users(group_id, user_id) " +
                "VALUES (?, ?);";
        Integer row = jdbcTemplate.queryForObject(sql, Integer.class, groupId, userId);

        if (row != null) {
            return true;
        } else
            return false;
    }

    @Override
    public void leaveGroup(int groupId, int userId) {
        String sql = "DELETE FROM shopping_group_users " +
                "WHERE group_id = ? AND user_id = ?;";
        Integer success = jdbcTemplate.queryForObject(sql, Integer.class, groupId, userId);

    }

    public ShoppingGroup mapRowToShoppingGroup(SqlRowSet rowSet){
        ShoppingGroup shoppingGroup = new ShoppingGroup();

        shoppingGroup.setGroupId(rowSet.getByte("group_id"));
        shoppingGroup.setGroupName(rowSet.getString("group_name"));
        shoppingGroup.setInvitationCode(rowSet.getInt("invitation_code"));

        return shoppingGroup;
    }
}
