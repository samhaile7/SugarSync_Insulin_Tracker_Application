package com.techelevator.dao;


import com.techelevator.model.Meal;


import java.util.List;

public interface MealDao {

    Meal addMeal(Meal incomingMeal);

    void deleteMeal(int mealId);

    Meal getMealById(int mealId);

    List<Meal> getAllMealsByUserId(int userId);
    List<Double> getAllAverages(int userId);






}
