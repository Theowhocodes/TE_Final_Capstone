<template>
<div id="reg">
<section class="is-relative section has-background-light">
    <div class="columns is-vcentered">
      <div class="column is-6 mb-14 mb-0-tablet">
        <div class="has-mw-md mx-auto">
          <h2 class="title is-size-3 has-leading-3 has-text-link">Invite your friends and collaborate on a shared shopping list for any occasion!</h2>
        </div>
        </div>
      <div class="column is-6">
        <div class="has-mw-md has-mw-xl-widescreen mx-auto py-12 px-8-mobile px-14-tablet has-background-white">
          <span class="is-block has-text-info is-size-4 is-uppercase has-letter-space">start making lists</span><br>
          <h3 class="title is-size-4 has-text-link">Create new account</h3>
  <div id="register">
    <form @submit.prevent="register">   
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="control mb-2">
<label  for="username">
   <p>Username</p>
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
      <label for="password" >Password</label><br>
      <input
      class= "input form-control"
        type="password"
        id="password"
        placeholder="********"
        pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$"
        title="Please follow password rules"
        v-model="user.password"
        required
      />
      </div>
      <div class="control mb-6">
      <label for="confirmPassword">Confirm Password</label> <br>
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
         <span>Your password must be at least 8 characters including a lowercase letter, an uppercase letter, a special character and a number.</span>
              </label>
            </div>
      <button class="button is-fullwidth is-warning" type="submit">
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
    </div>
</section>
</div>
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