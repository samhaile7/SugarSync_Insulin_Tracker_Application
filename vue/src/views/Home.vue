<template>
  <div class="home">
    <main id="main-grid">
      <div class="sub-grid">
        <div class="site-description">
          <h1>Manage your insulin. Easy.</h1><br>

          If you are living with diabetes or need to monitor <br>your insulin intake, SugarSync
          makes it easy to <br>stay on top of your health. Try SugarSync today and <br>take control
          of your insulin management!
          
          <div class="button-class" id="button-div">
          <button id="register-button" v-on:click="routeToRegister()">
            <span>Try SugarSync</span>
            
          </button>
          </div>
        </div>
        </div> 
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
  font-family: 'Lora', serif;
  font-weight: bold;
  font-size: 2.5em;
  text-shadow: 3px 3px #040084;
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
  font-family: 'Poppins', sans-serif;
  font-weight: bold;
  color:white;
  font-size: 1.5em;
  text-align: center;
  padding-top: 100px;
  padding-left: 25px;
  padding-right: 25px;
  text-shadow: 1px 1px #040084;
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
  background-color: #1874D2;
  color: white;
  border-radius: 50px;
  grid-area: register-button;
  padding: 10px 24px;
  width: 35%;
  height: 50%;
  cursor: pointer;
  font-family: 'Poppins', sans-serif;
}

#button-div {
  text-align: center;
  padding-top: 10%;
}

.button-class span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button-class span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button-class:hover span {
  padding-right: 25px;
}

.button-class:hover span:after {
  opacity: 1;
  right: 0;
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
    "button-div .";
  background-image: url("https://res.cloudinary.com/dzw4n2mgp/image/upload/v1681593141/capstone_assets/resizehomepage_pdvyoo.png");
  height: 100vh;
  background-size: cover;
  
  background-repeat: no-repeat;
  background-position-x: center;
  background-color: transparent;
}


</style>
