<template>
  <div class="main-grid">
       <h1> Alerts here </h1>
       <p>Target Min: {{currentTargetMinFromServer}}</p>
       <p>Target Max: {{currentTargetMaxFromServer}}</p>

       <div>
       <p v-if="this.$store.state.displayLowWarningMessage">Blood Sugar is Lower than Range</p>
       <p v-if="this.$store.state.displayLowAlertMessage">Blood Sugar is Critcially Low</p>
       <p v-if="this.$store.state.displayHighWarningMessage">Blood Sugar is Higher than Range</p>
       <p v-if="this.$store.state.displayHighAlertMessage">Blood Sugar is Critically High</p>
       <p>Test sentence here. </p>
       </div>
       
      <div class="tracker" style="overflow-y:scroll;">
 
      <h1>Log your meal here:</h1>
    
    <form action="" v-on:submit.prevent="postMealToServer()">
      <label for="">Number of Carbs (grams):</label>
      <input required type="text" v-model.number="mealInput.numberOfCarbs" /><br>

      <label for="">Blood Sugar at Mealtime (mmol/L):</label>
      <input required type="text" v-model.number="mealInput.bloodSugarAtMealtime" /><br>

      <button type="submit">Submit</button>

    </form>

    <p>Suggested dose (mL): {{calculatedDoseFromServer}}</p>
    
    </div>

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

    methods: {
        postMealToServer() {
            UserInputService.addMeal(this.mealInput).then((response) => {
                if (response.status === 201) {
                    this.calculatedDoseFromServer = response.data.suggestedDose;
                    this.getTargetRange(response.data);    
                }
            }).catch((err) => console.log(err));
        },

        getTargetRange(mealInput) {
            UserInputService.getUserInputTest().then((response) => {
                if (response.status === 200) {
                    this.userInput = response.data;
                    this.currentTargetMinFromServer = response.data.targetRangeMin;
                    this.currentTargetMaxFromServer = response.data.targetRangeMax;
                    
                    if (mealInput.bloodSugarAtMealtime < response.data.targetRangeMin &&
                        mealInput.bloodSugarAtMealtime > response.data.criticalLow) {
                            this.$store.state.displayLowWarningMessage = true;
                            this.$store.state.displayLowAlertMessage = false;
                            this.$store.state.displayHighWarningMessage = false;
                            this.$store.state.displayHighAlertMessage = false;
                        }
                    if (mealInput.bloodSugarAtMealtime <= response.data.criticalLow) {
                            this.$store.state.displayLowAlertMessage = true;
                            this.$store.state.displayLowWarningMessage = false;
                            this.$store.state.displayHighWarningMessage = false;
                            this.$store.state.displayHighAlertMessage = false;
                    }
                    if (mealInput.bloodSugarAtMealtime > response.data.targetRangeMax && 
                        mealInput.bloodSugarAtMealtime < response.data.criticalHigh) {
                            this.$store.state.displayHighWarningMessage = true;
                            this.$store.state.displayLowAlertMessage = false;
                            this.$store.state.displayLowWarningMessage = false;
                            this.$store.state.displayHighAlertMessage = false;
                        }
                    if (mealInput.bloodSugarAtMealtime >= response.data.criticalHigh) {
                            this.$store.state.displayHighAlertMessage = true;
                            this.$store.state.displayLowAlertMessage = false;
                            this.$store.state.displayLowWarningMessage = false;
                            this.$store.state.displayHighWarningMessage = false;
                    }
                
                   else  {this.$store.state.displayLowAlertMessage == false && this.$store.state.displayLowWarningMessage == false
                            && this.$store.state.displayHighWarningMessage == false && this.$store.state.displayHighAlertMessage == false;}
                }
            }).catch((err) => console.log(err));
        },
    }

}
</script>

<style scoped>

#itrack {
    grid-area: itrack;

}

.tracker {
    font-family: sans-serif;
    color: rgb(56, 56, 56);
    line-height: 2;
    grid-area: tracker;
    padding: 50px;
    background-color: rgb(177, 252, 252);
    border-style: outset;
    justify-content: center;
}
.main-grid {

    display: grid;
    height: 100vh;
  
    grid-template-columns: 1fr 2fr 1fr;
    grid-template-areas: 
    ". . ."
    ". tracker ."
    ". . ."
    ". . ."
    ;
    
    
}



</style>