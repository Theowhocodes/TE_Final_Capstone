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
      <button class="button is-fullwidth is-link is-light is-outlined" type="submit">
        Create Account
      </button>
      <br>
      <div class="has-text-centered mb-4">
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
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