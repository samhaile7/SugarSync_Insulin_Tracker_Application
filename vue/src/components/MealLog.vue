<template>
  <div class="main-grid">
      <div class="tracker">
      <h1 id="header">Log your meal here:</h1> <br>
    
    <form action="" v-on:submit.prevent="postMealToServer()">
      <label id="numofcarbs" for="">Number of Carbs (grams):</label>&nbsp;&nbsp;
      <input id="numofcarbs-input" required type="text" v-model.number="mealInput.numberOfCarbs" /><br>
        <br>
      <label id="bloodsugar" for="">Blood Sugar at Mealtime (mmol/L):</label>&nbsp;&nbsp;
      <input id="bloodsugar-input" required type="text" v-model.number="mealInput.bloodSugarAtMealtime" /><br>
        <br>
    <div id="button-div">
    <button id="submit-button" type="submit">Submit</button>
    </div>
    </form>
    
    <h3 id="suggested-dose">Suggested dose (Units): <br></h3>
    <h3 id="dose-number" v-if="isNaN(calculatedDoseFromServer)"></h3>
    <h3 id="dose-number" v-else>{{calculatedDoseFromServer.toFixed(2)}}</h3>
    
    <div id="button-div">
    <button id="submit-button" type="">Approve?</button>
    </div>

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
        // postMealToServer() {
        //     UserInputService.addMeal(this.mealInput).then((response) => {
        //         if (response.status === 201) {
        //             this.calculatedDoseFromServer = response.data.suggestedDose;
                    
        //             //display suggested dose ad don't actually push to home
        //         }
        //     }).catch((err) => console.log(err));
        // },


        toggleCalculatedDose() {

        },
        
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

#suggested-dose {
    text-align: center;
    padding-top: 5%;
    
}

#dose-number {
    text-align: center;
    font-size: 5em;
}

#numofcarbs {
    font-size: 1.15em;
}

#numofcarbs-input {
    float: right;
}

#bloodsugar {
    font-size: 1.15em;
}

#bloodsugar-input {
    float: right;
}

#submit-button {
    margin: auto;
    border-radius: 10px;
    background-color: #1874D2;
    color: white;
    font-weight: bold;
}

#button-div {
    text-align: center;
}



</style>