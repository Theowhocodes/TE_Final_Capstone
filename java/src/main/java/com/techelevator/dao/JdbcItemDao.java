package com.techelevator.dao;

import com.techelevator.model.Item;
import com.techelevator.model.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcItemDao implements ItemDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    private UserDao userDao;


    public JdbcItemDao(JdbcTemplate jdbcTemplate, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
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
    }//worked in postman

    @Override
    public Item getItemById(int itemId) {
        String sql = "SELECT * FROM item where item_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itemId);

        Item item = new Item();
        while (results.next()) {
           item = mapRowToItem(results);
        }
        return item;
    }//worked in postman

    @Override
    public Item getItemByItemName(String itemName) {
        String sql = "SELECT * FROM item WHERE item_name = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itemName);

        Item item = new Item();
        while (results.next()) {
            item = mapRowToItem(results);
        }

        return item;
    }//works in postman

    @Override
    public void changeQuantity(ItemDto itemDto) {
        String sql = "UPDATE item SET item_quantity = ? where item_id = ?";

        int updatedQuantity = jdbcTemplate.update(sql, itemDto.getItemQuantity(), itemDto.getItemId());
    }

    @Override
    public Item modifyItem(ItemDto itemDto) {
        String sql = "UPDATE item SET list_id = ?, added_by = ?, item_name = ?, item_quantity = ?, category = ?" +
                "date_added = ?, completed = ? where item_id = ?"; // last_modified = ?, last_modified_by = ?";

        jdbcTemplate.update(sql, itemDto.getItemId(), itemDto.getItemListId(), itemDto.getAddedBy(), itemDto.getItemName(),
                            itemDto.getItemQuantity(), itemDto.getCategory(), itemDto.getDateAdded(), itemDto.isCompleted());
                            //itemDto.getLastModified(), itemDto.getLastModifiedBy());
        return null;
    }

    @Override
    public void deleteItem(ItemDto itemDto) {
        String sql = "DELETE from item where item_id = ?";

        jdbcTemplate.update(sql, itemDto.getItemId());
    }

    @Override
    public Item createItem(ItemDto itemDto) {
        String sql = "INSERT into item (list_id, added_by, item_name, item_quantity, category, date_added, completed)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING item_id";

        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, itemDto.getItemListId(), itemDto.getAddedBy(), itemDto.getItemName(),
                itemDto.getItemQuantity(), itemDto.getCategory(), itemDto.getDateAdded(), itemDto.isCompleted());
        return null;
    }

    private Item mapRowToItem(SqlRowSet sqlRowSet) {
        Item item = new Item();

        item.setAddedBy(userDao.getUserById(sqlRowSet.getInt("added_by")));
        item.setCompleted(sqlRowSet.getBoolean("completed"));
        item.setDateAdded(sqlRowSet.getDate("date_added"));
        item.setItemId(sqlRowSet.getInt("item_id"));
        item.setItemListId(sqlRowSet.getInt("list_id"));
        item.setItemName(sqlRowSet.getString("item_name"));
        item.setItemQuantity(sqlRowSet.getInt("item_quantity"));
        item.setLastModified(sqlRowSet.getTimestamp("last_modified"));
        item.setLastModifiedBy(userDao.findByUsername(sqlRowSet.getString("last_modified_by")));

        return item;
    }
}

