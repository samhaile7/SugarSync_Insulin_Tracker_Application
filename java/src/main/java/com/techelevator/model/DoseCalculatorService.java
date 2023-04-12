package com.techelevator.model;

import com.techelevator.dao.InsulinTypeDao;
import com.techelevator.dao.JdbcInsulinTypeDao;

import java.util.List;

public class DoseCalculatorService {

    private InsulinTypeDao insulinTypeDao;
    private final int GRAMS_OF_CARBS_DISPOSED_BY_1_UNIT_INSULIN = 10;
    private final int BLOOD_SUGAR_DROPPED_PER_UNIT_OF_INSULIN = 50;




// This method calculates suggested dose from stats within incoming meal object
     /* CHO insulin dose =
    Total grams of CHO in the meal (60 g) / ÷ grams of CHO disposed by 1 unit of insulin (10) = 6 units
        */

    public Meal calculateDose( Meal incomingMeal, double userInsulinStrength, UserInput userInput) {

        //Gets # of carbs from meal object, divides it by grams disposed by 1 unit
        int doseInUnits = incomingMeal.getNumberOfCarbs() / GRAMS_OF_CARBS_DISPOSED_BY_1_UNIT_INSULIN;
        double targetBloodSugar = ( userInput.getTargetRangeMin() + userInput.getTargetRangeMax() ) / 2;
        double differenceBetweenActualAndTargetBloodSugar = incomingMeal.getBloodSugarAtMealtime() - targetBloodSugar;

        double additionalCorrectionDose = differenceBetweenActualAndTargetBloodSugar / BLOOD_SUGAR_DROPPED_PER_UNIT_OF_INSULIN;

        double outputDoseInUnits = doseInUnits + additionalCorrectionDose;

        if (outputDoseInUnits < 0) {
            outputDoseInUnits = 0;
        }

        double doseInMl = outputDoseInUnits / userInsulinStrength;

        //sets suggest dose to incoming meal object
        incomingMeal.setSuggestedDose(doseInMl);

        return incomingMeal;








    }

}
