<template>
  <div>
    <main id="header-grid">
      <img id="logo"
        src="https://res.cloudinary.com/dzw4n2mgp/image/upload/v1681228697/capstone_assets/alogo-1_eh6fli.webp"
        alt=""
      />
      <router-link id="home-link" v-bind:to="{ name: 'home' }">Home</router-link
      >&nbsp;&nbsp;
      <router-link id="edit-profile-link" v-bind:to="{ name: 'edit-profile' }"
        >Edit Profile</router-link
      >&nbsp;&nbsp;
      <router-link
        id="logout-link"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
      <router-link
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
};
</script>

<style>

#logo {
  grid-area: logo;
  width: 25%
}

#home-link {
  grid-area: home-link;
}
#edit-profile-link {
  grid-area: edit-profile-link;
}
#logout-link {
  grid-area: logout-link;
}
#login-link {
  grid-area: login-link;
}



#header-grid {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas: 
  "logo home-link edit-profile-link logout-link"
  ;
  
  max-width: 100%;

}
</style>