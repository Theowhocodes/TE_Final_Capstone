<template>
<section>
<nav class="navbar" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <a class="navbar-item" href="http://localhost:8082">
      <img src="../../src/assets/facebook_cover_photo_1.png" width="120" height="120">
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

<div id="bannerColumns" class="columns is-vcentered">
  <div class="column is-two-thirds">
    <figure class="image">
    <img id="coverImage" src="../../src/assets/SmallerNoteBook2.jpg">
    </figure>
  </div>
  <div class="column">
    <figure class="image">
    <img src="../../src/assets/facebook_cover_photo_1.png">
    </figure>
  </div>
  </div>
  <div class="columns">
    <div class="column is-full">

<div id ="groupTile" class="tile is-ancestor">
  <div class="tile is-3 is-vertical is-parent">
    <div class="tile is-child box">
      <p class="title">Join a group</p>
      <join-group />
    </div>
    <div class="tile is-child box">
       <p class="title">Weather</p>
      Never be caught off guard, check the forecast before you go out to shop!
      <weather />
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
      <p class="title">Create a group</p>
      <create-group />
    </div>
  </div>
  
</div>
    </div></div>


</section>
</template>

<script>
import AllGroups from '../components/AllGroups.vue';
import CreateGroup from '../components/CreateGroup.vue';
import JoinGroup from '../components/JoinGroup.vue';
import Weather from '@/components/Weather.vue';



export default {
  components: {
    AllGroups,
    CreateGroup,
    JoinGroup,
    Weather
  
    
  },
  name: "home"
};
</script>

<style>

#coverImage {
  margin-top: 15px;
  margin-left: 15px;
  border-radius: 4px;
}

#groupTile{
  margin-left: 5px;
  margin-right: 5px;
}

</style>
