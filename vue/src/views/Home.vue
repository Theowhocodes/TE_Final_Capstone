<template>
<section>
<nav class="navbar" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <a class="navbar-item" href="http://localhost:8082">
      <img src="../../src/assets/twitter_header_photo_1.png" width="112" height="28">
    </a>

    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
    </a>
  </div>

  <div id="navbarBasicExample" class="navbar-menu">
    <div class="navbar-start">
      <router-link class="navbar-item" v-bind:to="{ name: 'home' }">Home</router-link>
      

       <router-link class="navbar-item" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    

      <div class="navbar-item has-dropdown is-hoverable">
        <a class="navbar-link">
          More
        </a>

        <div class="navbar-dropdown">
          <a class="navbar-item">
            About
          </a>
          <a class="navbar-item">
            Jobs
          </a>
          <a class="navbar-item">
            Contact
          </a>

        </div>
      </div>
    </div>

  
  </div>
</nav>
<section class="is-relative section">
    <div class="columns">
      <div class="column is-full">
        <div class="has-mw-md has-mw-xl-widescreen mx-auto py-12 px-8-mobile px-14-tablet has-background-light">
         <br> <h2 class="title is-size-3 has-leading-3 has-text-link has-text-centered has-text-weight-bold">Welcome Back <br> Let's Start Shopping!</h2> <br>
        </div>
  <div class="home has-text-centered">
    <div class="column is-full">
        <div class="has-mw-md has-mw-xl-widescreen mx-auto py-12 px-8-mobile px-14-tablet has-background-light">
          <h3 class="title is-size-3 has-leading-3 has-text-link has-text-bold">Join</h3> 
    <join-group />
        </div>
    </div>
    <div class="column is-full">
        <div class="has-mw-md has-mw-xl-widescreen mx-auto py-12 px-8-mobile px-14-tablet has-background-light">
          <h3 class="title is-size-3 has-leading-2 has-text-link has-text-bold">Create</h3> 
          <create-group />
        </div>
    </div>
     <div class="column is-full">
       <div class="has-mw-md has-mw-xl-widescreen mx-auto py-12 px-8-mobile px-14-tablet has-background-light">
          <h2 class="title is-size-3 has-leading-2 has-text-link">Your Groups</h2> 
    <all-groups/>
        </div>
     </div>
     </div>
    <br />
    <br />
  </div>
  </div>
</section>
</section>
</template>

<script>
import AllGroups from '../components/AllGroups.vue';
import CreateGroup from '../components/CreateGroup.vue';
import JoinGroup from '../components/JoinGroup.vue';


export default {
  components: {
    AllGroups,
    CreateGroup,
    JoinGroup,
    
  },
  name: "home"
};
</script>

<style>
#groupBoard{
  height:100vh ;
  width: 100vmax;
  background-size: 100% ;
  background-repeat: no-repeat;
  background-size:contain ;
  margin: 0;
  padding: 0;
  border: 0;
}

</style>
