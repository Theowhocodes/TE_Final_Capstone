<template>
<section>
  
<div id="bannerColumns" class="columns is-vcentered">
  <div class="column is-two-thirds">
    <figure class="image">
      <img id="coverImage" src="../../src/assets/SmallerNoteBook2.jpg">
      </figure>
  </div>
  <div class="column">
    <figure class="image">
      <img src="../../src/assets/logo_transparent.png">
    </figure>
  </div>
  </div>


    <div class="columns">
      <div class="column is-three-fifths is-offset-one-fifth">
        <div class="box">
          <p id="tileTitle" class="title is-3">INVITE YOUR FRIENDS AND COLLABORATE ON A SHARED SHOPPING LIST FOR ANY OCCASION!</p>

          <p id="tileText">Sign in below or create an account to get started!</p><br>
              <form @submit.prevent="login">
                <div class="alert alert-danger" role="alert" v-if="invalidCredentials">Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <div class="control mb-2">
      <label for="username" id="tileText" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="input form-control"
        placeholder="Enter username"
        v-model="user.username"
        required
        autofocus
      />
      </div>
      <div class="control mb-6">
      <label id="tileText" for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="input form-control"
        placeholder="********"
        v-model="user.password"
        required
      />
      </div>
      <div>
      <button class="button is-fullwidth is-link is-light is-outlined mb-4" type="submit">Sign in</button>
      </div>
      <div class="has-text-centered mb-4">
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
     </div>
     <br>
    </form>
  </div>
    </div>
    </div>
  
      <footer class="footer">
  <div id="tileText" class="content has-text-centered">
    <p>
      Tech Elevator Pittsburgh Cohort 13 Final Capstone by Jenn Glick, Aileen Hall, Antonia Butts, Teddy Williams
    </p>
  </div>
</footer>
</section>
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
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style >
#login{
  display: flex;
  justify-content: center;
}
.signIn{
  display: flex;
  justify-content: center;
}

</style>
