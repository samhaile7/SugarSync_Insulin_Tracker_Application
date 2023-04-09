package com.techelevator.controller;

import com.techelevator.dao.UserInputDao;
import com.techelevator.model.UserInput;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserInputController {

    private UserInputDao userInputDao;

    public UserInputController(UserInputDao userInputDao) {
        this.userInputDao = userInputDao;
    }

    @RequestMapping(path = "/test", method = RequestMethod.POST)
    public UserInput addUserInput(@RequestBody UserInput userInput) {
        return userInputDao.addUserInput(userInput);
    }








}
