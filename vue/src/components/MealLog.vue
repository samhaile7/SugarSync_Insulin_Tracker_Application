<template>
  <div>
      <h1>Log your meal here:</h1>
    
    <form action="" v-on:submit.prevent="postMealToServer()">
      <label for="">Number of Carbs:</label>
      <input type="text" v-model.number="mealInput.numberOfCarbs" />

      <label for="">Blood Sugar at Mealtime</label>
      <input type="text" v-model.number="mealInput.bloodSugarAtMealtime" />

    <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>

import UserInputService from "../services/UserInputService.js";

export default {
    data() {
        return {
            mealInput: {
                 mealId: 0,
                 userId: 0
            }
        }
    },
    methods: {
        postMealToServer() {
            UserInputService.addMeal(this.meal).then((response) => {
                if (response.status === 201) {
                    this.$router.push({name: 'home'});
                    //display suggested dose ad don't actually push to home
                }
            }).catch((err) => console.log(err));
        }
    }

}
</script>

<style>

</style>