<template>
  <div>
    <label for="baselevel">Base Level</label>
    <input type="text"
    v-model="userInput.inputId"
     />

    <button v-on:click.prevent="getFromServer()">
      {{userInput}}
    </button>

    <!--  <div>
    <b-form-input v-model="text" placeholder="Base Level"></b-form-input>
    <div class="mt-2">Value: {{ text }}</div> 
  </div> -->
  </div>
</template>

<script>
import UserInputService from "../services/UserInputService.js";

export default {
  data() {
    return {
      userInput: {
        
      },
    };
  },
  methods: {
    getFromServer() {
        const userId = this.$route.params.id;
      UserInputService.getUserInput(userId)
        .then((response) => {
          this.userInput = response.data;
        })
        .catch((err) => console.error(err));
    },
  },
};
</script>

<style>
</style>