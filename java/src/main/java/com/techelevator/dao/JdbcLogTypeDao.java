package com.techelevator.dao;

import com.techelevator.model.InsulinType;
import com.techelevator.model.LogType;
import com.techelevator.model.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLogTypeDao implements LogTypeDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcLogTypeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<LogType> getAllLogTypes() {
        List<LogType> allLogTypes = new ArrayList<>();
        String sql = "SELECT log_type_id, activity_type FROM log_type";


        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            allLogTypes.add(mapRowToLogType(results));
        }
        return allLogTypes;
    }


    private LogType mapRowToLogType(SqlRowSet row) {
        LogType logType = new LogType();

        logType.setLogTypeId(row.getInt("log_type_id"));
        logType.setActivityType(row.getString("activity_type"));


        return logType;
    }



}
