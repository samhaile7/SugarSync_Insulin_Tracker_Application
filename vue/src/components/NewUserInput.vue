<template>
  <div class="main-grid">
    <div class="input-grid">
    <h1>Welcome!</h1>
    <h3>Please enter your information below:</h3>

    <form action="" v-on:submit.prevent="postToServer()">
      <label for="">Base Insulin Level </label>&nbsp;&nbsp;
      <input type="text" v-model.number="userInput.baseLevel" /><br>

      <label for="">Weight (in lbs)</label>&nbsp;&nbsp;
      <input type="text" v-model.number="userInput.weight" />

      <h4>Please select your insulin information:</h4>
      <div>
    <b-form-select v-model="userInput.insulinTypeId" class="mb-3">
      
      <b-form-select-option value="1" >Novolog: U-100, 100 U/mL</b-form-select-option>
      <b-form-select-option value="2" >Novolog: U-200, 200 U/mL</b-form-select-option>
      <b-form-select-option value="3" >Novolog: U-300, 300 U/mL</b-form-select-option>
      <b-form-select-option value="4" >Novolog: U-400, 400 U/mL</b-form-select-option>
      <b-form-select-option value="5" >Novolog: U-500, 500 U/mL</b-form-select-option>
      
       <div class="mt-2">Selected: <strong>{{ selected }}</strong></div>
    </b-form-select>
    
  </div>

      <button type="submit">Submit</button>
    </form>
    </div>
  </div>
</template>

<script>
import UserInputService from "../services/UserInputService.js";

export default {
  data() {
    return {
      userInput: {
        userId: 0,
        insulinTypeId: 0
      },
      
    };
  },

  methods: {
    postToServer() {
      //const userId = this.$route.params.id;
      UserInputService.addUserInput(this.userInput)
        .then((response) => {
          if (response.status === 201) {
            this.$router.push({ name: "home" });
            this.$store.state.userInputSuccess = true;
          }
        })
        .catch((err) => console.log(err));
    },
  },
};
</script>

<style scoped>




/* .input-grid {
  grid-area: input;
  
  font-family: sans-serif;
  line-height: 2;
  justify-content: center;
}

.main-grid {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: 
  ". . ."
  ". input ."
  ". . ."
  ;
} */




</style>