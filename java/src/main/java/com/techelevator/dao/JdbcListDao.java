package com.techelevator.dao;

import com.techelevator.model.Lists;
import com.techelevator.model.ListDto;

import com.techelevator.model.ShoppingGroup;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcListDao implements ListDao {

    private final JdbcTemplate jdbcTemplate;
    private ListDao listDao;

    public JdbcListDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate; }

<<<<<<< HEAD

    public Lists getByGroupId(int groupId){
        String sql = "SELECT group_id, COUNT(item.item_quantity) as item_count FROM list JOIN item ON item.list_id = list.list_id GROUP BY group_id ORDER BY group_id ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, groupId);
        results.next();
        Lists lists = mapRowToList(results);
        return lists;

    }
=======
    // GET ONE LIST BY ID
    public Lists getListById(int listId){
        Lists oneListById = new Lists();
        String sql = "SELECT * FROM list WHERE listId = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, listId);
        if (results.next()) {
            oneListById= mapRowToList(results);}
        return oneListById;
    }

    public Lists getListByGroupId(int groupId){
        Lists singleList = new Lists();
        String sql = "SELECT group_id, COUNT(item.item_quantity) as item_count FROM list JOIN item ON item.list_id = list.list_id GROUP BY group_id ORDER BY group_id ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, groupId);
        if (results.next()) {
            singleList = mapRowToList(results);}
        return singleList;
>>>>>>> 8f884ce7c0a5d954495fecd4dce5d6e54fddba82

    public List<Lists> getAllListsByGroupId(int groupId) {
        List<Lists> allGroupLists = new ArrayList<>();
        String sql = "SELECT list_id, list_name, group_id, claimed, list_owner, completed " +
                "FROM list WHERE group_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, groupId);
        while (results.next()) {
            allGroupLists.add(mapRowToList(results));
        }
        return allGroupLists;
    }


    public List<Lists> getAllListsByGroupId(int groupId) {
        List<Lists> allGroupLists = new ArrayList<>();
        String sql = "SELECT list_id, list_name, group_id, claimed, list_owner, completed " +
                "FROM list WHERE group_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, groupId);
        while (results.next()) {
            allGroupLists.add(mapRowToList(results));
        }
        return allGroupLists;
    }

    @Override
    public Lists createList(ListDto listDto) {
<<<<<<< HEAD
        String sql = "INSERT into list (list_id, list_name, group_id, claimed, list_owner, completed) values(?, ?, ?, ?, ?, ?) RETURNING list_id;";
        Integer newList = jdbcTemplate.queryForObject(sql, Integer.class, listDto.getListId(), listDto.getListName(), listDto.getGroupId(), listDto.getListOwner());
        return getByGroupId(newList);
=======
        String sql = "INSERT into list (list_name, group_id, claimed, list_owner, completed) values (?, ?, ?, null, ?) RETURNING list_id;";
        Integer newListId = jdbcTemplate.queryForObject(sql, Integer.class, listDto.getListName(), listDto.getGroupId(), listDto.isClaimed(), listDto.isCompleted());
        return listDao.getListById(newListId);
>>>>>>> 8f884ce7c0a5d954495fecd4dce5d6e54fddba82
    }


    public Lists claimList(int groupId, ListDto listDto) {
        String sql = "UPDATE list SET claimed = ?, list_owner = ? where group_id = ?;";
        jdbcTemplate.update(sql, listDao.claimList(groupId, listDto), groupId);

        return null;
    }

    private Lists mapRowToList(SqlRowSet rowSet){
        Lists lists = new Lists();
        lists.setListId(rowSet.getInt("list_id"));
        lists.setListName(rowSet.getString("list_name"));
        lists.setGroupId(rowSet.getInt("group_id"));
        lists.setClaimed(rowSet.getBoolean("claimed"));
        lists.setListOwner(rowSet.getInt("list_owner"));
        lists.setCompleted(rowSet.getBoolean("completed"));
        return lists;
    }
}