package com.techelevator.model;

import java.time.LocalDate;

public class Meal {

    private int mealId;
    private int userId;
    private int numberOfCarbs;
    private int bloodSugarAtMealtime;
    private double suggestedDose;
    private LocalDate dateCreated;

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNumberOfCarbs() {
        return numberOfCarbs;
    }

    public void setNumberOfCarbs(int numberOfCarbs) {
        this.numberOfCarbs = numberOfCarbs;
    }

    public int getBloodSugarAtMealtime() {
        return bloodSugarAtMealtime;
    }

    public void setBloodSugarAtMealtime(int bloodSugarAtMealtime) {
        this.bloodSugarAtMealtime = bloodSugarAtMealtime;
    }

    public double getSuggestedDose() {
        return suggestedDose;
    }

    public void setSuggestedDose(double suggestedDose) {
        this.suggestedDose = suggestedDose;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
