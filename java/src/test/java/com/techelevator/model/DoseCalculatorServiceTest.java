package com.techelevator.model;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoseCalculatorServiceTest {

    DoseCalculatorService doseCalculator;
    Meal testMeal;
    int insulinStrength;

@Before
    public void createCalculator() {
    this.doseCalculator = new DoseCalculatorService();
    this.testMeal = new Meal();
    this.insulinStrength = 100;
    testMeal.setNumberOfCarbs(60);

}
@Test

public void should_calculate_suggested_dose_in_ml() {
    Meal outputMeal = doseCalculator.calculateDose(testMeal, insulinStrength);
    Assert.assertEquals(0.06, outputMeal.getSuggestedDose(), 0.05);
}
@Test
    public void suggested_dose_in_ml_should_be_zero_if_carbs_zero() {
    testMeal.setNumberOfCarbs(0);
        Meal outputMeal = doseCalculator.calculateDose(testMeal, insulinStrength);
        Assert.assertEquals(0,outputMeal.getSuggestedDose(), 0.00);
    }




}
