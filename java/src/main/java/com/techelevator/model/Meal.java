package com.techelevator.model;

public class Meal {

    private int mealId;
    private int userId;
    private int numberOfCarbs;
    private int bloodSugarAtMealtime;
    private int suggestedDose;

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

    public int getSuggestedDose() {
        return suggestedDose;
    }

    public void setSuggestedDose(int suggestedDose) {
        this.suggestedDose = suggestedDose;
    }
}
