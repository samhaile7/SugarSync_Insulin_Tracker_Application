package com.techelevator.model;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoseCalculatorServiceTest {

    DoseCalculatorService doseCalculator;
    Meal testMeal;
    int insulinStrength;
    UserInput testUserInput;

@Before
    public void createCalculator() {
    this.doseCalculator = new DoseCalculatorService();
    this.testMeal = new Meal();
    this.insulinStrength = 100;
    testMeal.setNumberOfCarbs(60);
    testMeal.setBloodSugarAtMealtime(100);
    this.testUserInput = new UserInput();
    testUserInput.setTargetRangeMin(50);
    testUserInput.setTargetRangeMax(150);
}

@Test

public void should_calculate_suggested_dose_in_ml() {
    Meal outputMeal = doseCalculator.calculateDose(testMeal, insulinStrength, testUserInput);
    Assert.assertEquals(0.06, outputMeal.getSuggestedDose(), 0.05);
}
@Test
    public void suggested_dose_in_ml_should_be_zero_if_carbs_zero() {
    testMeal.setNumberOfCarbs(0);
        Meal outputMeal = doseCalculator.calculateDose(testMeal, insulinStrength, testUserInput);
        Assert.assertEquals(0,outputMeal.getSuggestedDose(), 0.00);
    }

    @Test
    public void should_not_administer_insulin_if_blood_sugar_too_low() {
        testMeal.setBloodSugarAtMealtime(25);
        Meal outputMeal = doseCalculator.calculateDose(testMeal, insulinStrength, testUserInput);
        Assert.assertEquals(0,outputMeal.getSuggestedDose(), 0.05);
    }

    @Test
    public void should_correct_high_blood_sugar_to_target() {
        testMeal.setBloodSugarAtMealtime(200);
        Meal outputMeal = doseCalculator.calculateDose(testMeal, insulinStrength, testUserInput);
        Assert.assertEquals(0.08,outputMeal.getSuggestedDose(), 0.00);
    }



}
