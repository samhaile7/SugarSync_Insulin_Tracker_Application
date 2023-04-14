package com.techelevator.dao;

import com.techelevator.model.InsulinType;
import com.techelevator.model.Meal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInsulinTypeDao implements InsulinTypeDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcInsulinTypeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<InsulinType> getAllInsulinTypes() {
        List<InsulinType> allInsulinTypes = new ArrayList<>();
        String sql = "SELECT insulin_type_id, insulin_type_name, insulin_brand_name, insulin_strength FROM insulin_type";


        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            allInsulinTypes.add(mapRowToInsulinType(results));
        }
        return allInsulinTypes;
    }



    @Override
    public int getInsulinStrengthOfCurrentUser(int userId) {
        String sql = "SELECT insulin_strength   " +
                "FROM insulin_type  " +
                "JOIN user_input  " +
                "ON user_input.insulin_type_id = insulin_type.insulin_type_id " +
                "WHERE user_id = ? " +
                "ORDER BY input_id DESC " +
                "LIMIT 1; ";
        Integer strength = jdbcTemplate.queryForObject(sql, Integer.class, userId);

        return strength;
    }


    private InsulinType mapRowToInsulinType (SqlRowSet row) {
        InsulinType insulinType = new InsulinType();

        insulinType.setInsulinTypeId(row.getInt("insulin_type_id"));
        insulinType.setInsulinTypeName(row.getString("insulin_type_name"));
        insulinType.setBrandName(row.getString("insulin_brand_name"));
        insulinType.setInsulinStrength(row.getInt("insulin_strength"));

        return insulinType;
    }

}
