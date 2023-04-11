package com.techelevator.dao;

import com.techelevator.model.Meal;
import com.techelevator.model.UserInput;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMealDao implements MealDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcMealDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Meal addMeal(Meal incomingMeal) {
        String sql = "INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose) VALUES (?, ?, ?, ?) " +
                " RETURNING meal_id;";
        Integer mealId = jdbcTemplate.queryForObject(sql, Integer.class, incomingMeal.getUserId(), incomingMeal.getNumberOfCarbs(),
                incomingMeal.getBloodSugarAtMealtime(), incomingMeal.getSuggestedDose());

        incomingMeal.setMealId(mealId);

        return incomingMeal;
    }



    @Override
    public void deleteMeal(int mealId) {
        String sql = "DELETE FROM meal WHERE meal_id = ?";

        jdbcTemplate.update(sql, mealId);

    }

    @Override
    public Meal getMealById(int mealId) {
        Meal meal = null;
        String sql = "SELECT meal_id, user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose FROM meal" +
                " WHERE meal_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, mealId);

        if (results.next()) {
            meal= mapRowToMeal(results);
        }
        return meal;
    }

    @Override
    public List<Meal> getAllMealsByUserId(int userId) {
        List<Meal> allMeals = new ArrayList<>();
        String sql = "SELECT meal_id, user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose FROM meal" +
                " WHERE user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while (results.next()) {
            Meal meal = mapRowToMeal(results);
            allMeals.add(meal);
        }
        return allMeals;
    }



    private Meal mapRowToMeal (SqlRowSet row) {
        Meal newMeal = new Meal();

        newMeal.setMealId(row.getInt("meal_id"));
        newMeal.setUserId(row.getInt("user_id"));
        newMeal.setNumberOfCarbs(row.getInt("number_of_carbs"));
        newMeal.setBloodSugarAtMealtime(row.getInt("blood_sugar_at_mealtime"));
        newMeal.setSuggestedDose(row.getInt("suggested_dose"));

        return newMeal;
    }


}
