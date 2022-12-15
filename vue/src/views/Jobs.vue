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

    <div id="jobColumns" class="columns">
        <div class="column is-full">
            <div class="box"> 
                <p id="tileTitle" class="title is-3">WE'RE HIRING!</p>
                    <p id="tileText">Do you think you have what it takes to be part of the Listmate team? If so, we'd love to hear from you!
                    We are currently seeking a front end developer with a passion for graphic design. 20+ years experience and a PhD in either computer science or design are required. Experience in MS Paint a plus! </p>
                    </div>
        </div>
    </div>

    <footer class="footer">
  <div class="content has-text-centered">
    <p id="tileText">
     Tech Elevator Pittsburgh | Final Capstone by Jenn Glick, Aileen Hall, Antonia Butts, Teddy Williams | December 2022
    </p>
  </div>
</footer>

  </section>


</template>

<script>
export default {

}
</script>

<style>

#jobColumns{
    margin: 5px;
}
</style>