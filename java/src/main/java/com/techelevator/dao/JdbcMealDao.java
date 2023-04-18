package com.techelevator.dao;

import com.techelevator.logwriter.LogWriter;
import com.techelevator.model.Meal;
import com.techelevator.model.UserInput;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMealDao implements MealDao {

    private LogWriter logWriter;
    private final int ADD_MEAL_LOG_TYPE_ID = 2;
    private UserInputDao userInputDao;


    private JdbcTemplate jdbcTemplate;

    public JdbcMealDao(JdbcTemplate jdbcTemplate, LogWriter logWriter, UserInputDao userInputDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.logWriter = logWriter;
        this.userInputDao = userInputDao;

    }


    @Override
    public Meal addMeal(Meal incomingMeal) {
        incomingMeal.setDateCreated(LocalDate.now());
        String sql = "INSERT INTO meal (user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created) VALUES (?, ?, ?, ?, ?) " +
                "RETURNING meal_id;";
        Integer mealId = jdbcTemplate.queryForObject(sql, Integer.class, incomingMeal.getUserId(), incomingMeal.getNumberOfCarbs(),
                incomingMeal.getBloodSugarAtMealtime(), incomingMeal.getSuggestedDose(), incomingMeal.getDateCreated());

        incomingMeal.setMealId(mealId);
        if (incomingMeal.getMealId() != 0) {
            logWriter.writeLog(ADD_MEAL_LOG_TYPE_ID, incomingMeal.getUserId());
        }
        UserInput latestUserInput = userInputDao.getUserInputByUserId(incomingMeal.getUserId());

        int logTypeBloodSugarAlert = determineLogType(latestUserInput, incomingMeal.getBloodSugarAtMealtime());

        if (logTypeBloodSugarAlert != 0) {
            logWriter.writeLog(logTypeBloodSugarAlert, incomingMeal.getUserId());
        }


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
        String sql = "SELECT meal_id, user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created FROM meal" +
                " WHERE meal_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, mealId);

        if (results.next()) {
            meal = mapRowToMeal(results);
        }
        return meal;
    }

    @Override
    public List<Meal> getAllMealsByUserId(int userId) {
        List<Meal> allMeals = new ArrayList<>();
        String sql = "SELECT meal_id, user_id, number_of_carbs, blood_sugar_at_mealtime, suggested_dose, date_created FROM meal" +
                " WHERE user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while (results.next()) {
            Meal meal = mapRowToMeal(results);
            allMeals.add(meal);
        }
        return allMeals;
    }

    @Override
    public List<Double> getAllInsulinDosageAverages(int userId) {
        // This list contains daily, 3 day, weekly, 2 week , monthly averages in that order
        List<Double> insulinDosageAverages = new ArrayList<>();
        LocalDate todaysDate = LocalDate.now();

        String sql_daily = "SELECT AVG(suggested_dose)  " +
                "FROM meal  " +
                "WHERE user_id = ? AND date_created = ?;";

        Double dailyAverage = jdbcTemplate.queryForObject(sql_daily, Double.class, userId, todaysDate);

        String sql_3dayAverage = "SELECT AVG(suggested_dose)  " +
                "FROM meal  " +
                "WHERE user_id = ? AND date_created > ? - interval '3' day;";

        Double threeDayAverage = jdbcTemplate.queryForObject(sql_3dayAverage, Double.class, userId, todaysDate);

        String sql_7dayAverage = "SELECT AVG(suggested_dose)  " +
                "FROM meal  " +
                "WHERE user_id = ? AND date_created > ? - interval '7' day;";

        Double sevenDayAverage = jdbcTemplate.queryForObject(sql_7dayAverage, Double.class, userId, todaysDate);

        String sql_14dayAverage = "SELECT AVG(suggested_dose)  " +
                "FROM meal  " +
                "WHERE user_id = ? AND date_created > ? - interval '14' day;";

        Double twoWeekAverage = jdbcTemplate.queryForObject(sql_14dayAverage, Double.class, userId, todaysDate);

        String sql_monthlyAverage = "SELECT AVG(suggested_dose)  " +
                "FROM meal  " +
                "WHERE user_id = ? AND date_created > ? - interval '1' month;";

        Double monthlyAverage = jdbcTemplate.queryForObject(sql_monthlyAverage, Double.class, userId, todaysDate);

        insulinDosageAverages.add(dailyAverage);
        insulinDosageAverages.add(threeDayAverage);
        insulinDosageAverages.add(sevenDayAverage);
        insulinDosageAverages.add(twoWeekAverage);
        insulinDosageAverages.add(monthlyAverage);

        return insulinDosageAverages;
    }

    @Override
    public List<Double> geAllBloodSugarAverages(int userId) {
        // This list contains daily, 3 day, weekly, 2 week , monthly averages in that order
        List<Double> bloodSugarAverages = new ArrayList<>();
        LocalDate todaysDate = LocalDate.now();

        String sql_daily = "SELECT AVG(blood_sugar_at_mealtime)  " +
                "FROM meal  " +
                "WHERE user_id = ? AND date_created = ?;";

        Double dailyAverage = jdbcTemplate.queryForObject(sql_daily, Double.class, userId, todaysDate);

        String sql_3dayAverage = "SELECT AVG(blood_sugar_at_mealtime)  " +
                "FROM meal  " +
                "WHERE user_id = ? AND date_created > ? - interval '3' day;";

        Double threeDayAverage = jdbcTemplate.queryForObject(sql_3dayAverage, Double.class, userId, todaysDate);

        String sql_7dayAverage = "SELECT AVG(blood_sugar_at_mealtime)  " +
                "FROM meal  " +
                "WHERE user_id = ? AND date_created > ? - interval '7' day;";

        Double sevenDayAverage = jdbcTemplate.queryForObject(sql_7dayAverage, Double.class, userId, todaysDate);

        String sql_14dayAverage = "SELECT AVG(blood_sugar_at_mealtime)  " +
                "FROM meal  " +
                "WHERE user_id = ? AND date_created > ? - interval '14' day;";

        Double twoWeekAverage = jdbcTemplate.queryForObject(sql_14dayAverage, Double.class, userId, todaysDate);

        String sql_monthlyAverage = "SELECT AVG(blood_sugar_at_mealtime)  " +
                "FROM meal  " +
                "WHERE user_id = ? AND date_created > ? - interval '1' month;";

        Double monthlyAverage = jdbcTemplate.queryForObject(sql_monthlyAverage, Double.class, userId, todaysDate);

        bloodSugarAverages.add(dailyAverage);
        bloodSugarAverages.add(threeDayAverage);
        bloodSugarAverages.add(sevenDayAverage);
        bloodSugarAverages.add(twoWeekAverage);
        bloodSugarAverages.add(monthlyAverage);


        return bloodSugarAverages;
    }


    private Meal mapRowToMeal(SqlRowSet row) {
        Meal newMeal = new Meal();

        newMeal.setMealId(row.getInt("meal_id"));
        newMeal.setUserId(row.getInt("user_id"));
        newMeal.setNumberOfCarbs(row.getInt("number_of_carbs"));
        newMeal.setBloodSugarAtMealtime(row.getInt("blood_sugar_at_mealtime"));
        newMeal.setSuggestedDose(row.getDouble("suggested_dose"));
        newMeal.setDateCreated(row.getDate("date_created").toLocalDate());

        return newMeal;
    }

    private int determineLogType(UserInput userInput, double bloodSugar) {
        int output = 0;
        if (bloodSugar < userInput.getTargetRangeMin() &&
                bloodSugar > userInput.getCriticalLow()) {
            output = 3;

        }
//        if (bloodSugar > userInput.getTargetRangeMin() &&
//                bloodSugar < userInput.getTargetRangeMax()) {
//            //if logging normal
//        }
        if (bloodSugar <= userInput.getCriticalLow()) {
            output = 5;
        }
        if (bloodSugar > userInput.getTargetRangeMax() &&
                bloodSugar < userInput.getCriticalHigh()) {
            output = 4;
        }
        if (bloodSugar >= userInput.getCriticalHigh()) {
            output = 6;
        }
        return output;
    }
}