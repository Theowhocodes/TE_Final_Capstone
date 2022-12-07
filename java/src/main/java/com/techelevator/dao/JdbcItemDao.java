package com.techelevator.dao;

import com.techelevator.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcItemDao implements ItemDao {

    private final JdbcTemplate jdbcTemplate;


    public JdbcItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }
    @Override
    public List<Item> listAll(int listId) {
        List<Item> allItemsInList = new ArrayList<>();
        String sql = "SELECT * FROM item where list_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, listId);
        while (results.next()) {
            Item item = mapRowToItem(results);
            allItemsInList.add(item);
        }
        return allItemsInList;
    }
    @Override
    public Item getItemById(int itemId) {
        String sql = "SELECT * FROM item where item_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itemId);

        Item item = new Item();
        while (results.next()) {
           item = mapRowToItem(results);
        }
        return item;
    }
    @Override
    public Item getItemByItemName(String itemName) {
        String sql = "SELECT * FROM item WHERE item_name = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itemName);

        Item item = new Item();
        while (results.next()) {
            item = mapRowToItem(results);
        }

        return item;
    }
    @Override
    public Item changeQuantity(Item item) {
        String sql = "UPDATE item SET (item_quantity = ?) where (item_id = ?)";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, item.getItemQuantity(), item.getItemId());

        Item updatedQuantity = new Item();
        if (results.next()) {
            updatedQuantity = mapRowToItem(results);
        }
        return updatedQuantity;
    }
    @Override
    public Item modifyItem(Item item) {
        String sql = "UPDATE item ";
        return null;//ItemDTO?
    }

    private Item mapRowToItem(SqlRowSet sqlRowSet) {
        Item item = new Item();
     //   item.setAddedBy(sqlRowSet.getObject());
        item.setCompleted(sqlRowSet.getBoolean("completed"));
        item.setDateAdded(sqlRowSet.getDate("date_added"));
        item.setItemId(sqlRowSet.getInt("item_id"));
        item.setItemListId(sqlRowSet.getInt("list_id"));
        item.setItemName(sqlRowSet.getString("item_name"));
        item.setItemQuantity(sqlRowSet.getInt("item_quantity"));
        item.setLastModified(sqlRowSet.getTimestamp("last_modified"));
       // item.setLastModifiedBy(sqlRowSet.getObject());

        return item;
    }
}
