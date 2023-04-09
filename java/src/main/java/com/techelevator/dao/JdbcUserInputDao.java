package com.techelevator.dao;

import com.techelevator.model.UserInput;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcUserInputDao implements UserInputDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcUserInputDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public UserInput addUserInput(UserInput incomingUserInput) {
        String sql = "INSERT INTO user_input (user_id, weight, base_level, insulin_type_id, insulin_strength) VALUES (?, ?, ?, ?, ?) " +
                " RETURNING input_id;";
        Integer userInputId = jdbcTemplate.queryForObject(sql, Integer.class, incomingUserInput.getUserId(), incomingUserInput.getWeight(),
                incomingUserInput.getBaseLevel(), incomingUserInput.getInsulinTypeId(), incomingUserInput.getInsulinStrength());

        incomingUserInput.setInputId(userInputId);

        return incomingUserInput;
    }

    @Override
    public boolean updateUserInput(UserInput updatedUserInput) {
        return false;
    }

    @Override
    public UserInput getUserInputByUserId(int userId) {
        return null;
    }
}

//(SELECT user_id FROM users WHERE username = ?)