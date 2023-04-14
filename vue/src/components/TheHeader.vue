<template>
  <div>
    <main id="header-grid">
      <!-- image being clicked to route to home does not work now -->
      <img 
        v-on:click="routeToHome"
        id="logo"
        src="https://res.cloudinary.com/dzw4n2mgp/image/upload/v1681440554/capstone_assets/sugarsync_1_j4p8yx.png"
        alt=""
      />
      <router-link id="home-link" v-bind:to="{name: 'home'}"><span>Home</span></router-link>
      &nbsp;&nbsp;
      
      <router-link 
        class="logbuttons"
        id="logout-link"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
      <router-link
      class="logbuttons"
        id="login-link"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token == ''"
        >Login</router-link
      >
    </main>
  </div>
</template>

<script>
export default {
  name: "the-header",
  methods: {
    routeToHome() {
      this.$router.push({name: 'home'})
    }
  }
};
</script>

<style>


#logo {
  grid-area: logo;
  width: 10%;
}

#home-link {
  grid-area: home-link;
  display: flex;
  color: rgb(252,141,62);
  font-weight: bold;
  font-size: 1.5em;
  justify-content: center;
  margin-top: 3%;
}




#edit-profile-link {
  grid-area: edit-profile-link;
  margin-top: 3%;
}
#logout-link {
  grid-area: logout-link;
  color: white;
  font-weight: bold;
  font-size: 1.5em;
  margin-top: 3%;
  text-decoration: none;
}
#login-link {
  grid-area: login-link;
  color: white;
  font-weight: bold;
  font-size: 1.5em;
  margin-top: 3%;
  text-decoration: none;
}



#add-meal-link {
  grid-area: add-meal-link;
}

#header-grid {
   background-color: rgb(52, 61, 182); /* For browsers that do not support gradients */
  background-image: linear-gradient( rgb(138, 175, 255),rgb(157,207,237));
  display: flex;
  /* grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
  grid-template-areas: "logo home-link edit-profile-link add-meal-link login-link"; */
  justify-content: space-around;
  align-content: space-between;

  max-width: 100%;
}
#home-link {
  grid-area: insulinbtn;
  display: inline-block;
  border-radius: 100px;
  background-color: #FD7F00;
  border: none;
  color: white;
  text-align: center;
  font-size: 28px;
  padding: 16px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  text-decoration: none;
  height: 75px;
  margin: auto;
  
}
.logbuttons {
  grid-area: insulinbtn;
  display: inline-block;
  border-radius: 100px;
  background-color: #FD7F00;
  border: none;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  text-decoration: none;
  height: 75px;
  margin: auto;
  color: white;
}
  
</style>