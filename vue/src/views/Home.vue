<template>
  <div class="home">
    <h1>Insulin Tracker</h1>

    <login-box />
    <the-footer />
  </div>
</template>

<script>
import LoginBox from '../components/LoginBox.vue';
import TheFooter from '../components/TheFooter.vue';

export default {
  name: "home",
  components: {
    LoginBox,
    TheFooter
      
  }
};
</script>

<style scoped>

h1 {
  text-align: center;
}

</style>
