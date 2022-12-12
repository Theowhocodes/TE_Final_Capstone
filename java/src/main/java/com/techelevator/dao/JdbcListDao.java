package com.techelevator.dao;

import com.techelevator.model.Lists;
import com.techelevator.model.ListDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcListDao implements ListDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcListDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // GET ONE LIST BY ID
    public Lists getListById(int listId){
        Lists oneListById = new Lists();
        String sql = "SELECT * FROM list WHERE list_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, listId);
        if (results.next()) {
            oneListById= mapRowToList(results);}
        return oneListById;
    }

//    public Lists getListByGroupId(int groupId){
//        Lists singleList = new Lists();
//        String sql = "SELECT group_id, COUNT(item.item_quantity) as item_count FROM list JOIN item ON item.list_id = list.list_id GROUP BY group_id ORDER BY group_id ASC;";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, groupId);
//        if (results.next()) {
//            singleList = mapRowToList(results);}
//        return singleList;
//
//    }

    public List<Lists> getAllListsByGroupId(int groupId) {
        List<Lists> allGroupLists = new ArrayList<>();
        String sql = "SELECT list_id, list_name, group_id, claimed, list_owner, list.completed, COUNT(item_name)::int " +
        "FROM list JOIN item USING (list_id) JOIN shopping_group USING (group_id) " +
        "WHERE group_id = ? GROUP BY list_id ORDER BY list_name asc;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, groupId);
        while (results.next()) {
            allGroupLists.add(mapRowToListWithItemCount(results));
        }
        return allGroupLists;
    }



    public Lists getByGroupId(int groupId) {
        return null;
    }

//    public List<Lists> getAllListsByGroupId(int groupId) {
//        List<Lists> allGroupLists = new ArrayList<>();
//        String sql = "SELECT list_id, list_name, group_id, claimed, list_owner, completed " +
//                "FROM list WHERE group_id = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, groupId);
//        while (results.next()) {
//            allGroupLists.add(mapRowToList(results));
//        }
//        return allGroupLists;
//    }


    @Override
    public Lists createList(ListDto listDto) {
        String sql = "INSERT into list (list_name, group_id, claimed, list_owner, completed) values (?, ?, ?, null, ?) RETURNING list_id;";
        Integer newListId = jdbcTemplate.queryForObject(sql, Integer.class, listDto.getListName(), listDto.getGroupId(), listDto.isClaimed(), listDto.isCompleted());
        return this.getListById(newListId);
    }


    public void claimList(int listId, int listOwner) {
        String sql = "UPDATE list SET claimed = true, list_owner = ? where list_id = ?;";
        jdbcTemplate.update(sql, listOwner, listId);
    }

    public void unclaimList(int listId) {
        String sql = "UPDATE list SET claimed = false, list_owner = null where list_id = ?;";
        jdbcTemplate.update(sql, listId);

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

    private Lists mapRowToListWithItemCount(SqlRowSet rowSet){
        Lists lists = new Lists();
        lists.setListId(rowSet.getInt("list_id"));
        lists.setListName(rowSet.getString("list_name"));
        lists.setGroupId(rowSet.getInt("group_id"));
        lists.setClaimed(rowSet.getBoolean("claimed"));
        lists.setListOwner(rowSet.getInt("list_owner"));
        lists.setCompleted(rowSet.getBoolean("completed"));
        lists.setCount(rowSet.getInt("count"));
        return lists;
    }


}
