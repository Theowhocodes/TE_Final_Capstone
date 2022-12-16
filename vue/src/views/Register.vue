<template>
<section>

  <nav id="testNav" class="navbar" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <a class="navbar-item" href="http://localhost:8082">
      <img src="../../src/assets/transparent_white.png" style="zoom:2">
    </a>

    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
    </a>
  </div>

  <div id="navbarBasicExample" class="navbar-menu">
    <div class="navbar-start">
      <router-link id="tileTitle" class="navbar-item has-text-white" v-bind:to="{ name: 'home' }">HOME</router-link>
      

       <router-link id="tileTitle" class="navbar-item has-text-white" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">LOGOUT</router-link>
    

      <div class="navbar-item has-dropdown is-hoverable">
        <a id="tileTitle" class="navbar-link has-text-white is-arrowless">
          MORE
        </a>

         <div class="navbar-dropdown">
          <router-link id="tileTitle" class="navbar-item" v-bind:to="{ name: 'about' }">
            ABOUT
          </router-link>
          <router-link id="tileTitle" class="navbar-item" v-bind:to="{ name: 'jobs' }">
            JOBS
          </router-link>
          
        </div>
      </div>
    </div>

  
  </div>
</nav>

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
          <p id="tileTitle" class="title is-3">CREATE NEW ACCOUNT</p>
  
    <form @submit.prevent="register">   
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="control mb-2">
<label  for="username">
   <p id="tileText">Username</p>
   <input
       class="input form-control"
       id="username"
        type="text"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      </label>
      </div>
      <div class="control mb-2">
      <label for="password">
        <p id="tileText"> Password</p>
      <input
      class= "input form-control"
        type="password"
        id="password"
        placeholder="********"
        pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$"
        title="Please follow password rules"
        v-model="user.password"
        required
      /></label>
      </div>
      <div class="control mb-6">
      <label id="tileText" for="confirmPassword">Confirm Password</label> <br>
      <input
      class= "input form-control"
        type="password"
        id="confirmPassword"
        placeholder="********"
        pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$"
        title="Please follow password rules"
        v-model="user.confirmPassword"
        required
      />
      </div>
      <div class="control mb-4">
        <label class="checkbox has-text-grey">
         <p id="tileText">Your password must be at least 8 characters including a lowercase letter, an uppercase letter, a special character and a number.</p>
              </label>
            </div>
      <button class="button is-small is-light" type="submit">
        Create Account
      </button>
      <br>
      <div class="has-text-centered mb-4">
      <router-link id="tileLink" :to="{ name: 'login' }">Have an account?</router-link>
      </div>
      <br>
         </form>
        </div>
      </div>
      </div>
  

      <footer class="footer">
  <div id="tileText" class="content has-text-centered">
    <p>
      Tech Elevator Pittsburgh | Final Capstone by Jenn Glick, Aileen Hall, Antonia Butts, Teddy Williams | December 2022
    </p>
  </div>
</footer>
</section>
</template>


<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;//add more password validations here?
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  }
  };
</script>

<style>
#register{
  display: flex;
  justify-content: center;
  position: absolute;
}

.createAccount{
  display: flex;
  justify-content: center;
  position: absolute;
}
</style>