<template>
<section>
<nav class="navbar" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <a class="navbar-item" href="http://localhost:8082">
<<<<<<< HEAD
      <img src="../../src/assets/twitter_header_photo_1.png" width="112" height="28">
=======
      <img src="../../src/assets/facebook_cover_photo_1.png" width="120" height="120">
>>>>>>> 5e45b06ece06bfeef7750309df1e4e2ddad72eef
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

<<<<<<< HEAD
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
=======
>>>>>>> 5e45b06ece06bfeef7750309df1e4e2ddad72eef
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
<<<<<<< HEAD
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
=======

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
>>>>>>> 5e45b06ece06bfeef7750309df1e4e2ddad72eef
  </div>
  <div class="tile is-parent">
    <div class="tile is-child box">
      <p class="title">See all your groups</p>
    <all-groups />
    </div>
  </div>
<<<<<<< HEAD
</section>
=======
   <div class="tile is-4 is-vertical is-parent">
    <div class="tile is-child box">
      <p class="title">Create a group</p>
      <create-group />
    </div>
  </div>
  
</div>
    </div></div>


>>>>>>> 5e45b06ece06bfeef7750309df1e4e2ddad72eef
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
