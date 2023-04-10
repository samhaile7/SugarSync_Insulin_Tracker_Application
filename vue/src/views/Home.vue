<template>
  <div class="home">
    <user-input />
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>

import UserInput from '../components/UserInput.vue'


export default {
  name: "home",
  components: {
      UserInput
  }
};
</script>
