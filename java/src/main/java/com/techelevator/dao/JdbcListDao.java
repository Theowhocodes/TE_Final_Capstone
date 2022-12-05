package com.techelevator.dao;

import com.techelevator.model.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

@Component
public class JdbcListDao implements ListDao {
    private final JdbcTemplate jdbcTemplate;

    private ListDao listDao;

    public JdbcListDao(JdbcTemplate jdbcTemplate, ListDao listDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.listDao = listDao;
    }

    public void getByGroupId(int groupId){
        String sql = "SELECT list_id,list_name, group_id, claimed, list_owner, completed FROM list WHERE group_id = ? ORDER BY ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, groupId);
        results.next();
        List list - mapRowToList(results);
        return list;

    }
    public void createList(List list){
        String sql = "INSERT into list (list_id, list_name, group_id, claimed, list_owner, completed) values(?, ?, ?, ?, ?, ?) RETURNING list_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, list.getlistId, list.getlistName, list.getgroupId, list.getclaimed, list.getlistOwner, list.getcompleted);

        return list(newId);

    }
    public void claimList(int groupId){
        String sql = "UPDATE list SET claimed = ?, list_owner = ? where group_id = ?;";
        jdbcTemplate.update(sql, dto.claimList(), groupId);



    }


}