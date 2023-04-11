<template>
  <div>
    <h1>Welcome!</h1>
    <h3>Please enter your information below:</h3>

    <form action="" v-on:submit.prevent="postToServer()">
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
        }
    }
  },

  methods: {
    postToServer() {
      //const userId = this.$route.params.id;
      UserInputService.addUserInput(this.userInput)
        .then((response) => {
          if (response.status === 201) {
            this.$router.push("home");
          }
        })
        .catch((err) => console.error(err));
    },
  },
};
</script>

<style>
</style>