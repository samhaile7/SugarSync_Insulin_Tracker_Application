package com.techelevator.dao;

import com.techelevator.model.Logger;
import com.techelevator.model.UserInput;

import java.util.List;

public interface LoggerDao {

     Logger addLog(Logger incomingLog );

    boolean updateLog(Logger updateLog, int id);

    Logger getLogByLogId(int logId);

    List<Logger> getAllLogsByUserId(int userId);

    int findIdByUsername (String username);

    void deleteLog(int mealId);


}
