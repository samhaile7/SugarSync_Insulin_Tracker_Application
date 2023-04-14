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
            calculatedDoseFromServer: 0,
           
            
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
        // postMealToServer() {
        //     UserInputService.addMeal(this.mealInput).then((response) => {
        //         if (response.status === 201) {
        //             this.calculatedDoseFromServer = response.data.suggestedDose;
                    
        //             //display suggested dose ad don't actually push to home
        //         }
        //     }).catch((err) => console.log(err));
        // },

        
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
                            this.$store.state.displayNormalMessage= false;
                        }
                         if (mealInput.bloodSugarAtMealtime > response.data.targetRangeMin &&
                        mealInput.bloodSugarAtMealtime < response.data.targetRangeMax) {
                            this.$store.state.displayLowWarningMessage = false;
                            this.$store.state.displayLowAlertMessage = false;
                            this.$store.state.displayHighWarningMessage = false;
                            this.$store.state.displayHighAlertMessage = false;
                            this.$store.state.displayNormalMessage= true;
                        }
                    if (mealInput.bloodSugarAtMealtime <= response.data.criticalLow) {
                            this.$store.state.displayLowAlertMessage = true;
                            this.$store.state.displayLowWarningMessage = false;
                            this.$store.state.displayHighWarningMessage = false;
                            this.$store.state.displayHighAlertMessage = false;
                              this.$store.state.displayNormalMessage= false;
                    }
                    if (mealInput.bloodSugarAtMealtime > response.data.targetRangeMax && 
                        mealInput.bloodSugarAtMealtime < response.data.criticalHigh) {
                            this.$store.state.displayHighWarningMessage = true;
                            this.$store.state.displayLowAlertMessage = false;
                            this.$store.state.displayLowWarningMessage = false;
                            this.$store.state.displayHighAlertMessage = false;
                              this.$store.state.displayNormalMessage= false;
                        }
                    if (mealInput.bloodSugarAtMealtime >= response.data.criticalHigh) {
                            this.$store.state.displayHighAlertMessage = true;
                            this.$store.state.displayLowAlertMessage = false;
                            this.$store.state.displayLowWarningMessage = false;
                            this.$store.state.displayHighWarningMessage = false;
                              this.$store.state.displayNormalMessage= false;
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