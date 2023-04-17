package com.techelevator.dao;

import com.techelevator.model.LogType;
import com.techelevator.model.Logger;
import com.techelevator.model.Meal;
import com.techelevator.model.UserInput;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

        String sql = "UPDATE logger SET  user_id = ? , log_type_id = ? , date_time_logged = ? " +
                " WHERE log_id = ?;";
        jdbcTemplate.update(sql, updateLog.getUserId(),
                updateLog.getLogTypeId(), updateLog.getDateTimeLogged(), id);

        return true;
    }

    @Override
    public Logger getLogByLogId(int logId) {
        Logger log = null;

        String sql = "SELECT log_id, user_id, log_type_id, date_time_logged " +
                "FROM logger " +
                "WHERE log_id = ? ";


        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, logId);

        if (results.next()) {
            log= mapRowToLog(results);
        }
        return log;

    }

    @Override
    public List<Logger> getAllLogsByUserId(int userId) {
        List<Logger> allLogs = new ArrayList<>();
        String sql = "SELECT log_id, user_id, log_type_id, date_time_logged " +
                "FROM logger " +
                "WHERE user_id = ? ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while (results.next()) {
            Logger log = mapRowToLog(results);
            allLogs.add(log);
        }
        return allLogs;
    }

    @Override
    public int findIdByUsername(String username) {
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
    public void deleteLog(int logId) {
        String sql = "DELETE FROM logger WHERE log_id = ?";

        jdbcTemplate.update(sql, logId);
    }


    private Logger mapRowToLog(SqlRowSet row) {
        Logger log = new Logger();

        log.setLogId(row.getInt("log_id"));
        log.setUserId(row.getInt("user_id"));
        log.setLogTypeId(row.getInt("log_type_id"));
        log.setDateTimeLogged(row.getTimestamp("date_time_logged").toLocalDateTime());

        return log;
    }

}
