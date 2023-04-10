package com.techelevator.dao;

import com.techelevator.model.UserInput;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcUserInputDao implements UserInputDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcUserInputDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public UserInput addUserInput(UserInput incomingUserInput) {
        String sql = "INSERT INTO user_input (user_id, weight, base_level, insulin_type_id) VALUES (?, ?, ?, ?) " +
                " RETURNING input_id;";
        Integer userInputId = jdbcTemplate.queryForObject(sql, Integer.class, incomingUserInput.getUserId(), incomingUserInput.getWeight(),
                incomingUserInput.getBaseLevel(), incomingUserInput.getInsulinTypeId());

        incomingUserInput.setInputId(userInputId);

        return incomingUserInput;
    }

    @Override
    public boolean updateUserInput(UserInput updatedUserInput) {

            String sql = "UPDATE user_input SET  weight = ? , base_level = ? , insulin_type_id = ?" +
                    " WHERE input_id = ?;";
            jdbcTemplate.update(sql, updatedUserInput.getWeight(),
                    updatedUserInput.getBaseLevel(), updatedUserInput.getInsulinTypeId(), updatedUserInput.getInputId());

            return true;
        }


    @Override
    public UserInput getUserInputByUserId(int userId) {
        UserInput userInput = null;
        String sql = "SELECT input_id, user_id, weight, base_level, insulin_type_id FROM user_input" +
                " WHERE user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        if (results.next()) {
             userInput= mapRowToUserInput(results);
    }
        return userInput;
    }

    private UserInput mapRowToUserInput (SqlRowSet row) {
        UserInput newInputObject = new UserInput();

        newInputObject.setInputId(row.getInt("input_id"));
        newInputObject.setUserId(row.getInt("user_id"));
        newInputObject.setWeight(row.getInt("weight"));
        newInputObject.setBaseLevel(row.getInt("base_level"));
        newInputObject.setInsulinTypeId(row.getInt("insulin_type_id"));

        return newInputObject;
    }
}

