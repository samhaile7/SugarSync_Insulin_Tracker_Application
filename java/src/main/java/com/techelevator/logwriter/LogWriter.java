package com.techelevator.logwriter;

import com.techelevator.dao.LoggerDao;
import com.techelevator.model.Logger;
import org.springframework.stereotype.Component;

@Component
public class LogWriter {

        private LoggerDao loggerDao;


    public LogWriter(LoggerDao loggerDao) {
        this.loggerDao = loggerDao;
    }


    public void writeLog(int typeOfLog, int userId) {
        Logger log = new Logger();
        log.setLogTypeId(typeOfLog);
        log.setUserId(userId);

        loggerDao.addLog(log);


        }
    }



