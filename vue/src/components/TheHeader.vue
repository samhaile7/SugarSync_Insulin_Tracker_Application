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
      <router-link class ="router" id="home-link" v-bind:to="{name: 'home'}"><span>Home</span></router-link>&nbsp;&nbsp;

      <router-link class ="router" id="dashboard-link" v-bind:to="{name: 'dashboard'}"><span>Dashboard</span></router-link> &nbsp;&nbsp;
      
      <router-link class ="router" id="profile-link" v-bind:to="{name: 'insulindevice'}"><span>Profile</span></router-link> &nbsp;&nbsp;
      
      <router-link class ="router" id="meal-link" v-bind:to="{name: 'insulinmealdevice'}"><span>Add Meal</span></router-link> &nbsp;&nbsp;

      <div class = "buttons">
      <button class="logbuttons"
        id="logout-link"
        v-on:click="routeToLogout()"
        v-if="$store.state.token != ''">
        Logout
      </button >
        
      <button class="logbuttons"
        id="login-link"
        v-on:click="routeToLogin()"
        v-if="$store.state.token == ''">
        Login
      </button>
      </div>


      <!--<router-link 
        class="logbuttons"
        id="logout-link"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link>
      <router-link
      class="logbuttons"
        id="login-link"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token == ''"
        >Login</router-link
      > -->
    </main>
  </div>
</template>

<script>
export default {
  name: "the-header",
  methods: {
    routeToHome() {
      this.$router.push({name: 'home'})
    },
    routeToLogout() {
      this.$router.push({name: 'logout'})
    },
    routeToLogin() {
      this.$router.push({name: 'login'})
    }
  }
};
</script>

<style>


#logo {
  grid-area: logo;
  width: 6%;
  height: 4%;
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
  /*background-color: rgb(52, 61, 182); /* For browsers that do not support gradients */
  /* background-image: linear-gradient( rgb(138, 175, 255),rgb(157,207,237));*/
  display: flex;
  /* grid-template-columns: 1fr 1fr;
  grid-template-areas: "logo insulinbtn"; */
  justify-content: right;
  align-content: space-between;
  max-width: 100%;
}

.router {
  grid-area: insulinbtn;
  display: inline-block;
  border-radius: 100px;
  color: #0141CF;
  border: none;
  text-align: center;
  font-size: 20px;
  padding: 16px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  text-decoration: none;
  height: 60px;
  margin: auto;
  
}
.logbuttons {
  grid-area: insulinbtn;
  display: inline-block;
  border-radius: 100px;
  background-color: #FF6A4C;
  border: none;
  text-align: center;
  font-size: 20px;
  width: 150px;
  transition: all 0.5s;
  cursor: pointer;
  margin-top: 50px;
  text-decoration: none;
  height: 50px;
  color: white;
  position: relative;
  
}
  
</style>