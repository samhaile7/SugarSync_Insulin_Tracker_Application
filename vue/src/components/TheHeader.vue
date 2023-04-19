<template>
  <div>
    <main id="header-grid">
      <!-- image being clicked to route to home does not work now -->
      <img 
        v-on:click="routeToHome"
        id="logo"
        src="https://res.cloudinary.com/dzw4n2mgp/image/upload/v1681751904/capstone_assets/sugarsync_long_1_xey8ej.png"
        alt=""
      />
      <router-link class ="router" id="home-link" v-bind:to="{name: 'home'}"><span>Home</span></router-link>

      <!-- <router-link class ="router" id="dashboard-link" v-bind:to="{name: 'dashboard'}" v-if="$store.state.token != ''"><span>Dashboard</span></router-link> -->
      <router-link class ="router" id="dashboard-link" v-bind:to="{name: 'admindashboard'}" v-if="isAdmin"><span>AdminDashboard</span></router-link>
      <router-link class ="router" id="dashboard-link" v-bind:to="{name: 'dashboard'}" v-else ><span>Dashboard</span></router-link>

      <router-link class ="router" id="profile-link" v-bind:to="{name: 'insulindevice'}" v-if="$store.state.token != ''"><span>Profile</span></router-link>
      
      <router-link class ="router" id="meal-link" v-bind:to="{name: 'insulinmealdevice'}" v-if="$store.state.token != ''"><span>Add Meal</span></router-link>

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
    },
    forceRerender() {
      this.$router.push({name: 'insulinmealdevice'})
    }
  },
  computed: {
    isAdmin() {
      if (this.$store.state.token != '' && this.$store.state.user.authorities[0].name === "ROLE_ADMIN") {
        return true;
      } else {
        return false;
      }
    },
    
  },
};
</script>

<style>


#logo {
  grid-area: logo;
  width: 200px;
  
  display: inline-block;
  
}

#home-link {
  grid-area: home;
  display: inline-block;
}

#profile-link {
  grid-area: profile-link;
  display: inline-block;
}

#dashboard-link {
  grid-area: dashboard;
  display: inline-block;
}

#meal-link {
  grid-area: meal-link;
  display: inline-block;
}

.buttons {
  grid-area: logbutton;
}

#header-grid {
  display: grid;
  grid-template-columns: 4fr 1fr 1fr 1fr 1fr 1fr;
  grid-template-areas: 
  "logo dashboard profile-link meal-link home logbutton";
  margin-bottom: 0;
}

.router {
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
  font-family: 'Poppins', sans-serif;
  font-weight: bold;
  
}
.logbuttons {
  grid-area: logbutton;
  display: inline-block;
  border-radius: 100px;
  background-color: #FF6A4C;
  border: none;
  text-align: center;
  font-size: 20px;
  width: 150px;
  transition: all 0.5s;
  cursor: pointer;
  text-decoration: none;
  height: 50px;
  color: white;
  position: relative;
  margin-top: 20px;
  margin-bottom: 0px;
  font-family: 'Poppins', sans-serif;
  font-weight:bold;
  
}


</style>