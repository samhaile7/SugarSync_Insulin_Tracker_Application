package com.techelevator.dao;

import com.techelevator.model.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class JdbcLoggerDao implements LoggerDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcLoggerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Logger addLog(Logger incomingLog) {
        incomingLog.setDateTimeLogged(LocalDateTime.now());

        String sql = "INSERT INTO logger (user_id, log_type_id, date_time_logged) VALUES (?, ?, ?) " +
                " RETURNING log_id;";
        Integer logId = jdbcTemplate.queryForObject(sql, Integer.class, incomingLog.getUserId(), incomingLog.getLogTypeId(),
                incomingLog.getDateTimeLogged());

        incomingLog.setLogId(logId);

        return incomingLog;
    } //CONTINUE HERE

    @Override
    public boolean updateLog(Logger updateLog, int id) {
        return false;
    }

    @Override
    public Logger getLogByLogId(int logId) {
        return null;
    }

    @Override
    public List<Logger> getAllLogsByUserId(int userId) {
        return null;
    }

    @Override
    public int findIdByUsername(String username) {
        return 0;
    }

}
