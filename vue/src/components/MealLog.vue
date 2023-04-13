<template>
  <div class="main-grid">
      <div class="tracker">
      <h1 id="header">Log your meal here:</h1>
    
    <form action="" v-on:submit.prevent="postMealToServer()">
      <label id="numofcarbs" for="">Number of Carbs (grams):</label>&nbsp;&nbsp;
      <input required type="text" v-model.number="mealInput.numberOfCarbs" /><br>

      <label id="bloodsugar" for="">Blood Sugar at Mealtime (mmol/L):</label>&nbsp;&nbsp;
      <input required type="text" v-model.number="mealInput.bloodSugarAtMealtime" /><br>

    <button type="submit">Submit</button>

    </form>

    
    
    
    <p>Suggested dose (mL): {{calculatedDoseFromServer}}</p>
    
    

    </div>
    <!-- <p v-show="$store.state.userInputSuccess == false">You have not entered your information. Please click here to set your information.</p> -->

  </div>
</template>

<script>

import UserInputService from "../services/UserInputService.js";


export default {
    data() {
        return {
            mealInput: {
                 mealId: 0,
                 userId: 0,
                 suggestedDose: 0
            },
            userInput: {},

            calculatedDoseFromServer: NaN,
            currentTargetMinFromServer: NaN,
            currentTargetMaxFromServer: NaN,
            displayHighAlertMessage: false, 
            displayHighWarningMessage: false,
            displayLowAlertMessage: false, 
            displayLowWarningMessage: false,
        }
    },

    // computed: {
    //     calculatedDoseFromServer: 0,
    //     calculateDose() {
    //         const mealInput = this.mealInput.suggestedDose;

    //         return mealInput
    //     },
    // },
    methods: {
        postMealToServer() {
            UserInputService.addMeal(this.mealInput).then((response) => {
                if (response.status === 201) {
                    this.calculatedDoseFromServer = response.data.suggestedDose;
                    
                    //display suggested dose ad don't actually push to home
                }
            }).catch((err) => console.log(err));
        },

    }

}
</script>

<style scoped>

#header {
    text-align: center;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.main-grid { 
  margin: 5%;
}

input {
    width: 30%;
}




</style>