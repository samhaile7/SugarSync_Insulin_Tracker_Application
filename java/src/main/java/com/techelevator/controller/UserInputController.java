package com.techelevator.controller;

import com.techelevator.dao.UserInputDao;
import com.techelevator.model.UserInput;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class UserInputController {

    private UserInputDao userInputDao;

    public UserInputController(UserInputDao userInputDao) {
        this.userInputDao = userInputDao;
    }

    @ResponseStatus (HttpStatus.CREATED)
    @RequestMapping(path = "/userinput", method = RequestMethod.POST)
    public UserInput addUserInput(@RequestBody UserInput userInput) {
        return userInputDao.addUserInput(userInput);
    }


    @RequestMapping(path = "/userinput/{id}", method = RequestMethod.PUT)
    public boolean updateUserInput(@RequestBody UserInput userInput, @PathVariable int id) {

        if (userInputDao.getUserInputByUserId(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Input Not Found");
        }
        return userInputDao.updateUserInput(userInput, id);
    }

    @RequestMapping(path = "/userinput/{userId}", method = RequestMethod.GET)
    public UserInput getUserInputByUserId(@PathVariable int userId) {
        return userInputDao.getUserInputByUserId(userId);
    }









}
