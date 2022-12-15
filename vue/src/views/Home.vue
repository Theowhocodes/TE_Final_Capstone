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
          <a id="tileTitle" class="navbar-item">
            ABOUT
          </a>
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

  <div id="allBoxes" class="columns">
    <div class="column is-half">
      <div class="box">
        <p id="tileTitle" class="title">JOIN A GROUP</p>
        <join-group />
          
      </div>
        
      <div class="box">
        <p id="tileTitle" class="title">CREATE A GROUP</p>
        <create-group />
      </div>
      
  
      </div>
     

      <div class="column">
        <div class="box">
          <p id="tileTitle" class="title">SEE ALL YOUR GROUPS</p>
          <all-groups />
          </div>
      </div>

      </div>
    

   <div id="allBoxes" class="columns">
      <div class="column is-full">  
          <div class="box">
            <p id="tileTitle" class="title">WEATHER</p>
            <p id="tileText">Never be caught off guard, check the forecast before you go out to shop!</p>
           <weather />
          </div>
      </div>
      </div>
    


        
        


      

<!--<div id ="groupTile" class="tile is-ancestor">
  <div class="tile is-3 is-vertical is-parent">
    <div class="tile is-child box">
      <p id="tileTitle" class="title">JOIN A GROUP</p>
      <join-group />
    </div>
    <div class="tile is-child box">
       <p id="tileTitle" class="title">WEATHER</p>
      <p id="tileText">Never be caught off guard, check the forecast before you go out to shop!</p>
      <weather />
    </div>
  </div>
  <div class="tile is-parent">
    <div class="tile is-child box">
      <p id="tileTitle" class="title">SEE ALL YOUR GROUPS</p>
    <all-groups />
    </div>
  </div>
   <div class="tile is-4 is-vertical is-parent">
    <div class="tile is-child box">
      <p id="tileTitle" class="title">CREATE A GROUP</p>
      <create-group />
    </div>
  </div>
  
</div> -->
 

<footer class="footer">
  <div class="content has-text-centered">
    <p id="tileText">
      Tech Elevator Pittsburgh Cohort 13 Final Capstone by Aileen Hall, Jenn Glick, Antonia Butts, Teddy Williams
    </p>
  </div>
</footer>

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
    Weather,
    
  
    
  },
  name: "home"
};
</script>

<style>

#testNav{ 
  background: #53435b;
  
}


#coverImage {
  margin-top: 15px;
  margin-left: 15px;
  border-radius: 4px;
}

#allBoxes{
  margin-left: 5px;
  margin-right: 5px;
}

</style>
