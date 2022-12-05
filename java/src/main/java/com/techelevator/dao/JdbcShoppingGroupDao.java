package com.techelevator.dao;

import com.techelevator.model.ShoppingGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

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

    // Get list of all transfers by account ID
    @Override
    public List<ShoppingGroup> getAllShoppingGroups(int userId) {
        List<ShoppingGroup> shoppingGroups = new ArrayList<>();
        String sql = "SELECT group_id, group_name, user_to, amount::decimal, transfer_type, transfer_status " +
                "FROM transfer WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            transfers.add(mapRowToTransfer(results));   //- ? map to Transfer object
        }
        return shoppingGroups;

    }
}
