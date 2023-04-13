<template>
  <div class="main-grid">
    <div class="input-grid">
    <h1>Welcome!</h1>
    <h4>Please enter your information below:</h4>

    <form action="" v-on:submit.prevent="postToServer()">
      <label for="">Base Insulin Level (U/mL)</label>&nbsp;&nbsp;
      <input type="text" v-model.number="userInput.baseLevel" /><br>

      <label for="">Weight (lbs)</label>&nbsp;&nbsp;
      <input type="text" v-model.number="userInput.weight" />

      <h5>Please select your insulin medication information:</h5>
      <div>
    <b-form-select v-model="userInput.insulinTypeId" class="dropdown">
      
      <b-form-select-option value="1" >Novolog: U-100, 100 U/mL</b-form-select-option>
      <b-form-select-option value="2" >Novolog: U-200, 200 U/mL</b-form-select-option>
      <b-form-select-option value="3" >Novolog: U-300, 300 U/mL</b-form-select-option>
      <b-form-select-option value="4" >Novolog: U-400, 400 U/mL</b-form-select-option>
      <b-form-select-option value="5" >Novolog: U-500, 500 U/mL</b-form-select-option>
      
       <div class="mt-2">Selected: <strong>{{ selected }}</strong></div>
    </b-form-select>
    
  </div>

      <button id="submit" type="submit">Submit</button>
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

h1 {
  text-align: center;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.dropdown {
  max-width: 65%;
}
.input-grid {
  margin: 5%;
}
#submit {
  
}




</style>