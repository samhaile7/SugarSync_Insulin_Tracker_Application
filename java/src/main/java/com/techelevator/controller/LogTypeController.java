package com.techelevator.controller;


import com.techelevator.dao.LogTypeDao;
import com.techelevator.model.LogType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class LogTypeController {

    private LogTypeDao logTypeDao;

    public LogTypeController(LogTypeDao logTypeDao) {
        this.logTypeDao = logTypeDao;
    }

    @RequestMapping(path = "/alllogtypes", method = RequestMethod.GET)
    public List<LogType> getAllLogTypes() {
        return logTypeDao.getAllLogTypes();
    }



}
