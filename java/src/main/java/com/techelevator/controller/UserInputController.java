package com.techelevator.controller;

import com.techelevator.dao.UserInputDao;
import com.techelevator.model.DoseCalculatorService;
import com.techelevator.model.UserInput;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@CrossOrigin
@RestController
public class UserInputController {

    private UserInputDao userInputDao;
    private DoseCalculatorService doseCalculator = new DoseCalculatorService();

    public UserInputController(UserInputDao userInputDao) {
        this.userInputDao = userInputDao;
    }

    @ResponseStatus (HttpStatus.CREATED)
    @RequestMapping(path = "/insulindevice", method = RequestMethod.POST)
    public UserInput addUserInput(@RequestBody UserInput userInput, Principal principal) {
        int id = userInputDao.findIdByUsername(principal.getName());
        userInput.setUserId(id);
       UserInput userInputWithUpdatedCriticalValues =  doseCalculator.setCriticalTresholds(userInput);

        return userInputDao.addUserInput(userInputWithUpdatedCriticalValues);
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

    @RequestMapping(path = "/userinput", method = RequestMethod.GET)
    public UserInput getUserInputByUserIdTEST(Principal principal) {
        int id = userInputDao.findIdByUsername(principal.getName());
        return userInputDao.getUserInputByUserId(id);
    }









}
