package com.techelevator.model;

import java.time.LocalDateTime;

public class Logger {


    private int logId;
    private int userId;
    private int logTypeId;
    private LocalDateTime dateTimeLogged;


    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLogTypeId() {
        return logTypeId;
    }

    public void setLogTypeId(int logTypeId) {
        this.logTypeId = logTypeId;
    }

    public LocalDateTime getDateTimeLogged() {
        return dateTimeLogged;
    }

    public void setDateTimeLogged(LocalDateTime dateTimeLogged) {
        this.dateTimeLogged = dateTimeLogged;
    }
}
