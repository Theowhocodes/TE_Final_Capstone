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

<div class="tile is-ancestor">
  <div class="tile is-3 is-vertical is-parent">
    <div class="tile is-child box">
      <p class="title">Join a group</p>
      <join-group />
    </div>
    <div class="tile is-child box">
      <p class="title">Create a group</p>
      <create-group />
    </div>
  </div>
  <div class="tile is-parent">
    <div class="tile is-child box">
      <p class="title">See all your groups</p>
    <all-groups />
    </div>
  </div>
   <div class="tile is-4 is-vertical is-parent">
    <div class="tile is-child box">
     <img src="../../src/assets/logo.png">
    </div>
    <div class="tile is-child box">
      <p class="title">Weather</p>
      Never be caught off guard, check the forecast before you go out to shop!
    </div>
  </div>
  
</div>



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
/*#all-groups{
 margin: auto;
 width: 300px; 
 background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#EBEB00), to(#C5C500));
 background: -moz-linear-gradient(100% 100% 90deg, #C5C500, #EBEB00);
 padding: 20px 20px 20px 20px;
 -webkit-box-shadow: 0px 10px 30px #000;
 -moz-box-shadow: 0px 10px 30px #000  
} */

</style>
