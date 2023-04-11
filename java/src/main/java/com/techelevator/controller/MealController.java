package com.techelevator.controller;

import com.techelevator.dao.JdbcUserInputDao;
import com.techelevator.dao.MealDao;
import com.techelevator.dao.UserInputDao;
import com.techelevator.model.Meal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
public class MealController {

    private MealDao mealDao;
    private UserInputDao userInputDao;

    public MealController(MealDao mealDao, UserInputDao userInputDao) {
        this.mealDao = mealDao;
        this.userInputDao = userInputDao;
    }

    @ResponseStatus (HttpStatus.CREATED)
    @RequestMapping (path = "/meal", method = RequestMethod.POST)
    public Meal addMeal(@RequestBody Meal meal, Principal principal) {
        int id = userInputDao.findIdByUsername(principal.getName());
        meal.setUserId(id);
        return mealDao.addMeal(meal);
    }
}
