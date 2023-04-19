<template >
  <div class="main-grid">
    <div class="input-grid">
      <h1>Welcome {{this.$store.state.user.username}}!</h1>
      <h4>Please enter your information below:</h4>

      <form action="" v-on:submit.prevent="postToServer()">
        <label for="">Base Insulin Level (U/mL): </label>&nbsp;&nbsp;
        <input
          required
          type="text"
          id="text1"
          v-model.number="userInput.baseLevel"
        /><br />

        <label for="">Weight (lbs):</label>&nbsp;&nbsp;
        <input
          required
          type="text"
          id="text2"
          v-model.number="userInput.weight"
        
        /><br />
        <!-- <div>
          <label for="range-1">Minimum Blood Sugar Range (mmol/L):</label>
          <b-form-input
            id="range-1"
            v-model.number="userInput.targetRangeMin"
            type="range"
            min="1"
            max="150"
          ></b-form-input>
          <div class="mt-2">Value: {{ targetRangeMin }}</div>
        </div> -->

        <label for="">Minimum Blood Sugar Range (mmol/L):</label>&nbsp;&nbsp;
        <input required type="text" v-model.number="userInput.targetRangeMin" />
        <label for="">Maximum Blood Sugar Range (mmol/L):</label>&nbsp;&nbsp;
        <input required type="text" v-model.number="userInput.targetRangeMax" /> 

        <br><br><p id="med-info">Please select your insulin medication information:</p>
        <div>
          <b-form-select
            required
            v-model="userInput.insulinTypeId"
            class="dropdown"
          >
            <b-form-select-option value="1"
              >Novolog: U-100, 100 U/mL</b-form-select-option
            >
            <b-form-select-option value="2"
              >Novolog: U-200, 200 U/mL</b-form-select-option
            >
            <b-form-select-option value="3"
              >Novolog: U-300, 300 U/mL</b-form-select-option
            >
            <b-form-select-option value="4"
              >Novolog: U-400, 400 U/mL</b-form-select-option
            >
            <b-form-select-option value="5"
              >Novolog: U-500, 500 U/mL</b-form-select-option
            >

            <div class="mt-2">
              Selected: <strong>{{ selected }}</strong>
            </div>
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
        insulinTypeId: 0,
        targetRangeMin: 0,
        targetRangeMax: 0,
        criticalLow: 0,
        criticalHigh: 0,

      },
      successmsg: "",
      value: '75',
    };
  },

  methods: {
    postToServer() {
      UserInputService.addUserInput(this.userInput)
        .then((response) => {
          if (response.status === 201) {
            this.clearForm();
            this.$store.state.userInputSuccess = true;
            this.$router.push({name: 'insulinmealdevice'})
          }
        })
        .catch((err) => console.log(err));
    },
    clearForm() {
      this.userInput = {};
    },
  },
};
</script>

<style scoped>

h4 {
  font-family: 'Poppins', sans-serif;
  font-weight:bold;
  margin-bottom: 15px;
}

h1 {
  text-align: center;
    font-family: 'Lora', serif;
  font-weight: bold;
}
#med-info {
  font-size: 1.1em
}
.dropdown {
  max-width: 65%;
}
.input-grid {
  margin: 5%;
}
#submit {
  margin-top: 10px;
      border-radius: 10px;
    background-color: #1874D2;
    color: white;
    font-weight: bold;
}

input {
  float: right;
  width: 120px;
}

.scrollable {
  overflow-y: scroll;
}
form {
  font-family: 'Poppins', sans-serif;
  font-weight:bold;
}
</style>