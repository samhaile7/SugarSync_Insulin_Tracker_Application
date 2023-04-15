package com.techelevator.controller;

import com.techelevator.dao.JdbcInsulinTypeDao;
import com.techelevator.dao.JdbcUserInputDao;
import com.techelevator.dao.MealDao;
import com.techelevator.dao.UserInputDao;
import com.techelevator.model.DoseCalculatorService;
import com.techelevator.model.Meal;
import com.techelevator.model.UserInput;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class MealController {

    private MealDao mealDao;
    private UserInputDao userInputDao;
    private DoseCalculatorService doseCalculator = new DoseCalculatorService();
    private JdbcInsulinTypeDao insulinTypeDao;

    public MealController(MealDao mealDao, UserInputDao userInputDao, JdbcInsulinTypeDao insulinTypeDao) {
        this.mealDao = mealDao;
        this.userInputDao = userInputDao;
        this.insulinTypeDao = insulinTypeDao;
    }

    @ResponseStatus (HttpStatus.CREATED)
    @RequestMapping (path = "/insulinmealdevice", method = RequestMethod.POST)
    public Meal addMeal(@RequestBody Meal meal, Principal principal) {
        //add error catching for null pointer exception in case user is not logged in and principal is null
        int id = userInputDao.findIdByUsername(principal.getName());

        meal.setUserId(id);

        int userInsulinStrength = insulinTypeDao.getInsulinStrengthOfCurrentUser(id);
        UserInput userInput = userInputDao.getUserInputByUserId(id);

        // Calculations here dosecalculator.calculateDose (incoming) = meal
       Meal mealWithDose = doseCalculator.calculateDose(meal, userInsulinStrength, userInput);

        return mealDao.addMeal(mealWithDose);
    }

    @ResponseStatus (HttpStatus.NO_CONTENT)
    @RequestMapping (path = "/meal/{mealId}", method = RequestMethod.DELETE)
    public void deleteMeal(@PathVariable int mealId) {
         mealDao.deleteMeal(mealId);
    }

    @RequestMapping(path = "/meal/{mealId}", method = RequestMethod.GET)
    public Meal getMealByMealId(@PathVariable int mealId) {
        return mealDao.getMealById(mealId);
    }




    @RequestMapping(path = "/meal/allmeals", method = RequestMethod.GET)
    public List<Meal> getAllMealsByUserID(Principal principal) {
        int id = userInputDao.findIdByUsername(principal.getName());
        return mealDao.getAllMealsByUserId(id);
    }

    @RequestMapping(path = "/bloodsugarhistory", method = RequestMethod.GET)
    public List<Double> getAveragesForLoggedInUser(Principal principal) {
        int id = userInputDao.findIdByUsername(principal.getName());
        return mealDao.geAllBloodSugarAverages(id);
    }

    @RequestMapping(path = "/insulindosagehistory", method = RequestMethod.GET)
    public List<Double> getAveragesInsulinDosageForLoggedInUser(Principal principal) {
        int id = userInputDao.findIdByUsername(principal.getName());
        return mealDao.getAllInsulinDosageAverages(id);
    }



}
