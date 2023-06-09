package com.techelevator.dao;

import com.techelevator.logwriter.LogWriter;
import com.techelevator.model.UserInput;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcUserInputDao implements UserInputDao{

    private LogWriter logWriter;
    private final int ADD_UPDATE_USERINPUT_ID = 1;


    private JdbcTemplate jdbcTemplate;

    public JdbcUserInputDao(JdbcTemplate jdbcTemplate, LogWriter logWriter) {
        this.jdbcTemplate = jdbcTemplate;
        this.logWriter= logWriter;
    }

    public int findIdByUsername (String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        int userId;
        try{
            userId = jdbcTemplate.queryForObject("SELECT user_id FROM users WHERE username = ?", int.class, username);
        } catch (NullPointerException e) {
            throw new NullPointerException("User" + username + " was not found");
        }
        return userId;
    }

    @Override
    public UserInput addUserInput(UserInput incomingUserInput) {
        String sql = "INSERT INTO user_input (user_id, weight, base_level, target_range_min, target_range_max, critical_low, critical_high, insulin_type_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?) " +
                " RETURNING input_id;";
        Integer userInputId = jdbcTemplate.queryForObject(sql, Integer.class, incomingUserInput.getUserId(), incomingUserInput.getWeight(),
                incomingUserInput.getBaseLevel(), incomingUserInput.getTargetRangeMin(), incomingUserInput.getTargetRangeMax(), incomingUserInput.getCriticalLow(),
                incomingUserInput.getCriticalHigh(), incomingUserInput.getInsulinTypeId());

        incomingUserInput.setInputId(userInputId);
        if (incomingUserInput.getInputId() != 0) {
            logWriter.writeLog(ADD_UPDATE_USERINPUT_ID, incomingUserInput.getUserId());
        }
        return incomingUserInput;
    }

    @Override
    public boolean updateUserInput(UserInput updatedUserInput, int id) {

            String sql = "UPDATE user_input SET  weight = ? , base_level = ? , target_range_min = ?, target_range_max = ?, critical_low = ?, critical_high = ?, insulin_type_id = ? " +
                    " WHERE user_id = ?;";
            jdbcTemplate.update(sql, updatedUserInput.getWeight(),
                    updatedUserInput.getBaseLevel(), updatedUserInput.getTargetRangeMin(), updatedUserInput.getTargetRangeMax(),
                    updatedUserInput.getCriticalLow(), updatedUserInput.getCriticalHigh(), updatedUserInput.getInsulinTypeId(), id);
        if (updatedUserInput.getInputId() != 0) {
            logWriter.writeLog(ADD_UPDATE_USERINPUT_ID, updatedUserInput.getUserId());
        }
            return true;
        }


    @Override
    public UserInput getUserInputByUserId(int userId) {
        UserInput userInput = null;
        String sql = "SELECT input_id, user_id, weight, base_level, target_range_min, target_range_max, critical_low, critical_high, insulin_type_id FROM user_input " +
                " WHERE user_id = ? " +
                " ORDER BY input_id DESC " +
                " LIMIT 1;";

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
        newInputObject.setTargetRangeMin(row.getDouble("target_range_min"));
        newInputObject.setTargetRangeMax(row.getDouble("target_range_max"));
        newInputObject.setCriticalLow(row.getDouble("critical_low"));
        newInputObject.setCriticalHigh(row.getDouble("critical_high"));
        newInputObject.setInsulinTypeId(row.getInt("insulin_type_id"));

        return newInputObject;
    }
}

