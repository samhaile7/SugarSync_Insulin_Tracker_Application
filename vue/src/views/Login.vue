<template>
<div id="login" class="text-center">

    <section
      class="vh-100 bg-image"
      
    >
      <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
          <div
            class="row d-flex justify-content-center align-items-center h-100"
          >
            <div class="col-12 col-md-9 col-lg-7 col-xl-6">
              <div class="card" style="border-radius: 15px">
                <div class="card-body p-5">
                  <h2 class="text-uppercase text-center mb-5">
                    Login
                  </h2>

                  <form @submit.prevent="login">
                    <div role="alert" v-if="invalidCredentials">
                      Invalid username and password!
                    </div>
                    <div role="alert" v-if="this.$route.query.registration">
                      Thank you for registering, please sign in.
                    </div>


                   
                    <div class="form-outline mb-4">
                      <input
                        type="text"
                        id="form3Example1cg"
                        class="form-control form-control-lg"
                        v-model="user.username"
                        required
                        autofocus
                      />
                      <label class="form-label" for="form3Example1cg"
                        >Enter Username</label
                      >
                    </div>

                    <div class="form-outline mb-4">
                      <input
                        type="password"
                        id="form3Example4cg"
                        class="form-control form-control-lg"
                        v-model="user.password"
                        required
                      />
                      <label class="form-label" for="form3Example4cg"
                        >Enter Password</label
                      >
                    </div>

                    <div class="d-flex justify-content-center" id="submit-button">
                      <button
                      
                        type="submit"
                        class="
                          btn btn-success btn-block btn-lg
                          gradient-custom-4
                          text-body
                        " 
                      >
                        Login
                      </button>
                    </div>
                    <p class="form-label">
                      Don't have an account?
                      <router-link :to="{ name: 'register' }">Register Here.</router-link>
                    </p>
                  </form>
                </div>
              </div>
            </div>
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

.mb-5, .form-label {
  color: #232069
}



.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

.vh-100 {
  background-image: url("https://res.cloudinary.com/dzw4n2mgp/image/upload/v1681593141/capstone_assets/resizehomepage_pdvyoo.png");
  background-color: transparent;
  justify-content: space-evenly;
  background-size: cover;
  height: 100vh;
}

h2 {
  font-family: 'Lora', serif;
  font-weight: bold;
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

.btn-success{
  background-color: #80AAFF;
  border-color: #80AAFF;

}
.btn-success:hover {
  background-color: #5990ff;
  border-color: #5990ff;
  
}
.btn-success:active {
  background-color: #5990ff;
  border-color: #5990ff;
  
}

.fw-normal {
  font-family: 'Poppins', sans-serif;
  font-weight: bold;
  
}

.form-label {
  font-family: 'Poppins', sans-serif;
  font-weight: bold;
  
}

.d-flex {
  font-family: 'Poppins', sans-serif;
  font-weight: bold;
}

.btn {
  color: white;
}


</style>