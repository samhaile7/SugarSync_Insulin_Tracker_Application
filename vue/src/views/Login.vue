<template>
  <div id="login">
    <!-- <form @submit.prevent="login">
      <h1>Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input
          type="text"
          id="username"
          v-model="user.username"
          required
          autofocus
        />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit">Sign in</button>
      <p>
        <router-link :to="{ name: 'register' }"
          >Need an account? Sign up.</router-link
        >
      </p>
    </form> -->

    <section class="vh-100">
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-6 text-black">
            <div class="px-5 ms-xl-4">
              <i
                class="fas fa-crow fa-2x me-3 pt-5 mt-xl-4"
                style="color: #709085"
              ></i>
              
            </div>

            <div
              class="
                d-flex
                align-items-center
                h-custom-2
                px-5
                ms-xl-4
                mt-5
                pt-5 pt-xl-0
                mt-xl-n5
              "
            >
              <!--FORM STARTS HERE-->
              <form style="width: 23rem" @submit.prevent="login">
                <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px">
                  Log in
                </h3>
                <div role="alert" v-if="invalidCredentials">
                  Invalid username and password!
                </div>
                <div role="alert" v-if="this.$route.query.registration">
                  Thank you for registering, please sign in.
                </div>

                <div class="form-outline mb-4">
                  <input
                    type="text"
                    
                    id="form2Example18" class="form-control form-control-lg"
                    v-model="user.username"
                    required
                    autofocus
                  />
                  <label class="form-label" for="form2Example18"
                    >Username</label
                  >
                </div>

                <div class="form-outline mb-4">
                  <input
                    type="password"
                    id="password"
                    class="form-control form-control-lg"
                    v-model="user.password"
                    required
                  />
                  <label class="form-label" for="form2Example28"
                    >Password</label
                  >
                </div>

                <div class="pt-1 mb-4">
                  <button class="btn btn-info btn-lg btn-block" type="submit">
                    Login
                  </button>
                </div>

                <p>
                  Don't have an account?
                  <router-link :to="{ name: 'register' }"
                    >Register here.</router-link
                  >
                </p>
              </form>
            </div>
          </div>
          <div class="col-sm-6 px-0 d-none d-sm-block">
            <img
              src="../assets/verticaldiabietesphoto.png"
              alt="Login image"
              class="w-100 vh-100"
              style="object-fit: cover; object-position: left"
            />
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push({ name: "insulindevice" });
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}


.bg-image-vertical {
position: relative;
overflow: hidden;
background-repeat: no-repeat;
background-position: right center;
background-size: auto 100%;
}

@media (min-width: 1025px) {
.h-custom-2 {
height: 100%;
}
}

.btn-lg:hover {
  background-color: #0141CF;
  border-color: #0141CF;

}

.btn-lg {
  background-color: #1874D2;
  border-color: #1874D2;
  
}

.fw-normal {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  
}

.form-label {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  
}

#login {
 

}




</style>