package com.techelevator.dao;

import com.techelevator.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcItemDao implements ItemDao {

    private final JdbcTemplate jdbcTemplate;


    public JdbcItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }
    @Override
    public List<Item> listAll(int list_id) {
        String sql = "SELECT * FROM item where list_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, list_id);
        while (results.next()) {
        //map row to item
        }
        return null;
    }
    @Override
    public Item getItemById(int itemId) {
        String sql = "SELECT * FROM items where item_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itemId);
        while (results.next()) {
            //map row to item
        }
        return null;
    }
    @Override
    public Item getItemByItemName() {
        String sql = "SELECT * FROM ";

        return null;
    }
    @Override
    public int changeQuantity() {//maybe dont need this, just use modify
        return 0;
    }
    @Override
    public Item modifyItem() {
        return null;
    }

    public Item mapRowToItem() {
        return null;
    }
}
