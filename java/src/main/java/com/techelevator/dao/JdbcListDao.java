package com.techelevator.dao;

import com.techelevator.model.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcListDao implements ListDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    private ListDao listDao;

    public JdbcListDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List getByGroupId(int groupId){
        String sql = "SELECT group_id, COUNT(item.item_quantity) as item_count FROM list JOIN item ON item.list_id = list.list_id GROUP BY group_id ORDER BY group_id ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, groupId);
        results.next();
        List list = mapRowToList(results);
        return list;

    }

    @Override
    public List createList(List list) {
        String sql = "INSERT into list (list_id, list_name, group_id, claimed, list_owner, completed) values(?, ?, ?, ?, ?, ?) RETURNING list_id;";
        Integer newList = jdbcTemplate.queryForObject(sql, Integer.class, list.getListId(), list.getListName(), list.getGroupId(), list.getListOwner());
        return getByGroupId(newList);
    }


    public List claimList(int groupId) {
        String sql = "UPDATE list SET claimed = ?, list_owner = ? where group_id = ?;";
        jdbcTemplate.update(sql, listDao.claimList(groupId), groupId);

        return null;
    }

    private List mapRowToList(SqlRowSet rowSet){
        List list = new List();
        list.setListId(rowSet.getInt("list_id"));
        list.setListName(rowSet.getString("list_name"));
        list.setGroupId(rowSet.getInt("group_id"));
        list.setClaimed(rowSet.getBoolean("claimed"));
        list.setListOwner(rowSet.getInt("list_owner"));
        list.setCompleted(rowSet.getBoolean("completed"));
        return list;
    }


}