<template>
<section>
<nav id="testNav" class="navbar" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <a class="navbar-item" href="http://localhost:8082">
      <img src="../../src/assets/transparent_white.png" width="120" height="120">
    </a>

    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
    </a>
  </div>

  <div id="navbarBasicExample" class="navbar-menu">
    <div class="navbar-start">
      <router-link class="navbar-item has-text-white" v-bind:to="{ name: 'home' }">Home</router-link>
      

       <router-link class="navbar-item has-text-white" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    

      <div class="navbar-item has-dropdown is-hoverable">
        <a class="navbar-link has-text-white is-arrowless">
          More
        </a>

        <div class="navbar-dropdown">
          <a class="navbar-item">
            About
          </a>
          <a class="navbar-item">
            Jobs
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
    <img src="../../src/assets/logo_transparent.png">
    </figure>
  </div>
  </div>
  <div class="columns">
    <div class="column is-full">

<div id="groupTile" class="tile is-ancestor">
  <div class="tile is-3 is-vertical is-parent">
    <div class="tile is-child box">
      <p id="tileTitle" class="title">Get started on a list</p>
      <create-list/>
    </div>
    <div class="tile is-child box">
      <p id="tileTitle" class="title">Weather</p>
      Never be caught off guard, check the forecast before you go out to shop
      <weather />
    </div>
  </div>
  <div class="tile is-parent">
    <div class="tile is-child box">
      
      <p id="tileTitle" class="title">All of your group's lists</p>
      <group-detail/>
    </div>
    </div>
    <div class="tile is-4 is-vertical is-parent">
    <div class="tile is-child box">
      <p class="title">Leave this group</p>
     <leave-group/>
    </div>
  </div>
  </div>
  </div>
</div>

<footer class="footer">
  <div class="content has-text-centered">
    <p>
      Tech Elevator Pittsburgh Cohort 13 Final Capstone by Aileen Hall, Antonia Butts, Jenn Glick, Teddy Williams
    </p>
  </div>
</footer>
</section>
</template>



<script>
import CreateList from '../components/CreateList.vue';
import GroupDetail from '../components/GroupDetail.vue';
import LeaveGroup from '../components/LeaveGroup.vue';
import Weather from '../components/Weather.vue';


export default {
  components: {
    GroupDetail,
    LeaveGroup,
    CreateList,
    Weather
    
    
  }
}
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
