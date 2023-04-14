<template>
  <div id="register" class="text-center">

    <section
      class="vh-100 bg-image"
      style="
        background-image: url('https://images.pexels.com/photos/6941882/pexels-photo-6941882.jpeg');
      "
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
                    Create an account
                  </h2>

                  <form @submit.prevent="register">
                    <div role="alert" v-if="registrationErrors">
                      {{ registrationErrorMsg }}
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
                        >Create a Username</label
                      >
                    </div>

                    <!-- <div class="form-outline mb-4">
                  <input type="email" id="form3Example3cg" class="form-control form-control-lg" />
                  <label class="form-label" for="form3Example3cg">Your Email</label>
                </div> -->

                    <div class="form-outline mb-4">
                      <input
                        type="password"
                        id="form3Example4cg"
                        class="form-control form-control-lg"
                        v-model="user.password"
                        required
                      />
                      <label class="form-label" for="form3Example4cg"
                        >Password</label
                      >
                    </div>

                    <div class="form-outline mb-4">
                      <input
                        type="password"
                        id="form3Example4cdg"
                        class="form-control form-control-lg"
                        v-model="user.confirmPassword"
                        required
                      />
                      <label class="form-label" for="form3Example4cdg"
                        >Confirm your password</label
                      >
                    </div>

                    <div class="d-flex justify-content-center">
                      <button
                        type="submit"
                        class="
                          btn btn-success btn-block btn-lg
                          gradient-custom-4
                          text-body
                        " 
                      >
                        Register
                      </button>
                    </div>
                    <p>
                      Already have an account?
                      <router-link :to="{ name: 'login' }">Log in.</router-link>
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
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
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

.bg-image {
  background-image: url('https://images.pexels.com/photos/6941882/pexels-photo-6941882.jpeg');
  background-size: 1150px;
  zoom: 100%; 
  
}
.btn-success{
  background-color: #FD7F00;
  border-color: #FD7F00;

}
.btn-success:hover {
  background-color: #FD6600;
  border-color: #FD6600;
  
}
.btn-success:active {
  background-color: #FD6600;
  border-color: #FD6600;
  
}

/* [v-cloak] {
  display: none;

} */
.text-center {
 font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;

}

</style>
