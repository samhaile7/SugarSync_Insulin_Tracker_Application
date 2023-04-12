<template>
  <div class="home">
    <main id="main-grid">
      <div class="sub-grid">
        <div class="site-description">
          Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
          eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
          minim veniam, quis nostrud exercitation ullamco laboris nisi ut
          aliquip ex ea commodo consequat. Duis aute irure dolor in
          reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
          pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
          culpa qui officia deserunt mollit anim id est laborum.
        </div>
        <div class="buttons">
          <button id="login-button" v-on:click="routeToLogin()" >Login</button><br>
          <button id="register-button" v-on:click="routeToRegister()" >Register</button>
        </div>
      </div>
      <!-- <img
          id="homepage-image"
          src="https://res.cloudinary.com/dzw4n2mgp/image/upload/v1681224356/capstone_assets/pexels-nataliya-vaitkevich-6941878_owqzuc.jpg"
          alt=""
        /> -->
    </main>

    <the-footer />
  </div>
</template>

<script>
import TheFooter from "../components/TheFooter.vue";

export default {
  name: "home",
  components: {
    TheFooter,
  },
  methods: {
    routeToLogin() {
      this.$router.push('login')
    },
    routeToRegister() {
      this.$router.push('register')
    }
  }
};
</script>

<style scoped>
h1 {
  text-align: center;
}

#homepage-image {
  grid-area: homepage-image;
  max-width: 100%;
  opacity: 50%;

  z-index: -1;
}

.site-description {
  grid-area: site-description;
  z-index: 1;
  text-align: center;
  padding-top: 160px;
}

.buttons {
  display: flex;
  flex-flow: column;
  justify-content: center;
  align-items: center;
  

}

#login-button {
  border-radius: 12px;
  grid-area: login-button;
  padding: 10px 24px;
  width: 50%;
  justify-content: center;
}

#register-button {
  border-radius: 12px;
  grid-area: register-button;
  padding: 10px 24px;
  width: 50%;
}

#main-grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: "container container";
}

.sub-grid {
  display: grid;
  grid-area: container;
  text-align: center;
  color: black;
  justify-content: space-evenly;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "site-description login-button"
    "site-description register-button";
  background-image: url("https://res.cloudinary.com/dzw4n2mgp/image/upload/v1681224356/capstone_assets/pexels-nataliya-vaitkevich-6941878_owqzuc.jpg");
  height: 100vh;
  background-size: contain;
  background-color: transparent;
}
</style>
