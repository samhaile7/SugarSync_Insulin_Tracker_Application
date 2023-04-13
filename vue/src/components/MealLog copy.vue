<template>
  <div class="main-grid">
      <div class="tracker" style="overflow-y:scroll;">

          <h1> ALerts here </h1>
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