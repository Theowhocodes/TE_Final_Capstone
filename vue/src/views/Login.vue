<template>
<section class="is-relative section has-background-light">
  <div class="container">
    <div class="columns is-vcentered">
      <div class="column is-6 mb-14 mb-0-tablet">
        <div class="has-mw-md mx-auto">
          <h2 class="title is-size-3 has-leading-3 has-text-primary">Invite your friends and collaborate on a shared shopping list for any occasion!</h2>
        </div>
      </div>
      <div class="column is-6">
        <div class="has-mw-md has-mw-xl-widescreen mx-auto py-12 px-8-mobile px-14-tablet has-background-white">
          <span class="is-block has-text-info has-text-weight-semibold is-uppercase has-letter-space">Start Making Lists</span><br>
          <h3 class="title is-size-4 has-text-primary">Sign in to your account</h3>
    <form @submit.prevent="login">
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <div class="control mb-2">
      <label for="username" class="sr-only">Username</label>
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
      <label for="password" class="sr-only">Password</label>
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
      <button class="button is-fullwidth is-warning mb-4" type="submit">Sign in</button>
      </div>
      <div class="has-text-centered mb-4">
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
     </div>
     <br>
    </form>
  </div>
    </div>
    </div>
      </div>
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
