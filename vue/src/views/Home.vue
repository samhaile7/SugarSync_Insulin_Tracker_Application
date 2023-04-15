<template>
  <div class="home">
    <main id="main-grid">
      <div class="sub-grid">
        <div class="site-description">
          <h1>Manage your insulin. Easy.</h1><br>
          <!--Get ready to say goodbye to the hassle of managing insulin doses with
          SugarSync, the ultimate insulin tracking app. 
          Plus, 
          with personalized dose recommendations and analytics, you can gain 
          valuable insights into your glucose levels and make informed decisions 
          regarding <br>your health.
          With intuitive features
          like blood sugar logging and dose tracking, you can be confident that 
          you're taking the right amount of insulin at the right time.
          -->

          If you are living with diabetes or need to monitor your insulin intake, SugarSync
          makes it easy to stay on top of your health. Sign up for a SugarSync demo today and take control
          of your insulin management!
        </div>
        <!--<div class="buttons" v-if="$store.state.token == ''">
          <button id="login-button" v-on:click="routeToLogin()">Login</button
          ><br />-->
          <button id="register-button" v-on:click="routeToRegister()">
            Try SugarSync
          </button>
        </div> 
      <!-- </div>
      <img
          id="homepage-image"
          src="https://res.cloudinary.com/dzw4n2mgp/image/upload/v1681224356/capstone_assets/pexels-nataliya-vaitkevich-6941878_owqzuc.jpg"
          alt=""
        /> -->
    </main>
        
    
  </div>
</template>

<script>

export default {
  name: "home",
  components: {
  
  },
  methods: {
    routeToLogin() {
      this.$router.push("login");
    },
    routeToRegister() {
      this.$router.push("register");
    },
  },
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
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-weight: bold;
  color:white;
  font-size: 1.25em;
  text-align: center;
  padding-top: 100px;
  padding-left: 25px;
  padding-right: 25px;
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
    "site-description ."
    "site-description ."
    "register-button .";
  background-image: url("https://res.cloudinary.com/dzw4n2mgp/image/upload/v1681593141/capstone_assets/resizehomepage_pdvyoo.png");
  height: 100vh;
  background-size: cover;
  
  background-repeat: no-repeat;
  background-position-x: center;
  background-color: transparent;
}
</style>
