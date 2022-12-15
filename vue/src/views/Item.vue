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
 
      <div class="tile is-ancestor">
  <div class="tile is-4">
      <delete-item/>
      <div class="tile is-4 is-vertical is-parent">
    <div class="tile is-child box">
      <modify-item/>
    </div>
      </div>
  </div>
      </div>

    <footer class="footer">
  <div class="content has-text-centered">
    <p id="tileText">
      Tech Elevator Pittsburgh Cohort 13 Final Capstone by Aileen Hall, Antonia Butts, Jenn Glick, Teddy Williams
    </p>
  </div>
</footer>
  

  </section>
</template>

<script>
import DeleteItem from '../components/DeleteItem.vue'
import ModifyItem from '../components/ModifyItem.vue'

export default {
  components: { DeleteItem, ModifyItem },
  
}
</script>

<style>


</style>