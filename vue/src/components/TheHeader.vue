<template>
  <div>
      <h1>Logo</h1>
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'edit-profile' }">Edit Profile</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token == ''">Login</router-link>
  </div>
</template>

<script>
export default {
    name: 'the-header',

}
</script>

<style>

</style>