<template>
  <div>
    <main id="header-grid">
      <img
        id="logo"
        src="https://res.cloudinary.com/dzw4n2mgp/image/upload/v1681440554/capstone_assets/sugarsync_1_j4p8yx.png"
        alt=""
      />
      <router-link id="home-link" v-bind:to="{ name: 'home' }">Home</router-link
      >&nbsp;&nbsp;
      <router-link id="edit-profile-link" v-bind:to="{ name: 'new-user' }"
        >Edit Profile</router-link
      >&nbsp;&nbsp;
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
};
</script>

<style>
.logbuttons {

}

#logo {
  grid-area: logo;
  width: 25%;
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
#add-meal-link {
  grid-area: add-meal-link;
}

#header-grid {
  background-color: rgb(254, 204, 152);
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
  grid-template-areas: "logo home-link edit-profile-link add-meal-link login-link";

  max-width: 100%;
}
</style>