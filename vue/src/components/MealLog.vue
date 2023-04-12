<template>
  <div>
      <h1>Log your meal here:</h1>
    
    <form v-show="$store.state.userInputSuccess != false"  action="" v-on:submit.prevent="postMealToServer()">
      <label for="">Number of Carbs:</label>
      <input required type="text" v-model.number="mealInput.numberOfCarbs" />

      <label for="">Blood Sugar at Mealtime</label>
      <input required type="text" v-model.number="mealInput.bloodSugarAtMealtime" />

    <button type="submit">Submit</button>

    </form>

    
    <div v-show="showCalculatedDose == true">
    {{calculatedDoseFromServer}}
    </div>


    <p v-show="$store.state.userInputSuccess == false">You have not entered your information. Please click here to set your information.</p>

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
            showCalculatedDose: false,
            
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
                    this.showCalculatedDose = true;
                    this.calculatedDoseFromServer = response.data.suggestedDose;
                    
                    //display suggested dose ad don't actually push to home
                }
            }).catch((err) => console.log(err));
        },

    }

}
</script>

<style>

</style>