<template>
  <div>
    <h1>Hello, !</h1>
    <h3>Update your information below:</h3>

    <form action="" v-on:submit.prevent="updateToServer()">
      <label for="">Base Insulin Level</label>
      <input type="text" v-model.number="userInput.baseLevel" />

      <label for="">Weight (in lbs)</label>
      <input type="text" v-model.number="userInput.weight" />

      <label for="">Insulin Brand</label>
      <input type="select" v-model.number="userInput.insulinTypeId" />

      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>
import UserInputService from "../services/UserInputService.js";

export default {
  data() {
    return {
      userInput: {
        userId: 0,
      },
      updateSuccessMessage: "",
      errorExists: false,
      errorMessage: "",
    };
  },

  methods: {
    updateToServer() {
      UserInputService.updateUserInput(this.userInput)
        .then((response) => {
          if (response.status === 200) {
            this.updateSuccessMessage =
              "Your information was updated successfully.";
          }
        })
        .catch((err) => {
          const response = err.response;
          this.errorExists = true;
          if (response.status === 400) {
            this.errorMessage = "Bad Request. Please try again.";
          }
        });
    },
  },
};
</script>

<style>
</style>