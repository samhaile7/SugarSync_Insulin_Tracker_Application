package com.techelevator.controller;

import com.techelevator.dao.LoggerDao;
import com.techelevator.dao.UserInputDao;
import com.techelevator.model.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class LoggerController {

    private LoggerDao loggerDao;
    private UserInputDao userInputDao;

    public LoggerController(LoggerDao loggerDao, UserInputDao userInputDao) {
        this.loggerDao = loggerDao;
        this.userInputDao = userInputDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/addlog", method = RequestMethod.POST)
    public Logger addLog(@RequestBody Logger log, Principal principal) {
        int id = userInputDao.findIdByUsername(principal.getName());
        log.setUserId(id);


        return loggerDao.addLog(log);
    }


    @RequestMapping(path = "/log/{id}", method = RequestMethod.PUT)
    public boolean updateLog(@RequestBody Logger log, @PathVariable int id) {

        if (loggerDao.getLogByLogId(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Input Not Found");
        }
        return loggerDao.updateLog(log, id);
    }

    @RequestMapping(path = "/log/{logId}", method = RequestMethod.GET)
    public Logger getLogByLogId(@PathVariable int logId) {
        return loggerDao.getLogByLogId(logId);
    }

    @RequestMapping(path = "/alllogs", method = RequestMethod.GET)
    public List<Logger> getAllLogsByUserId(Principal principal) {
        int id = userInputDao.findIdByUsername(principal.getName());
        return loggerDao.getAllLogsByUserId(id);
    }

    @ResponseStatus (HttpStatus.NO_CONTENT)
    @RequestMapping (path = "/log/{logId}", method = RequestMethod.DELETE)
    public void deleteLog(@PathVariable int logId) {
        loggerDao.deleteLog(logId);
    }
}
