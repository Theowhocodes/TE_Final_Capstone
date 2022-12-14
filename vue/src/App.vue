<template>
  <div id="app" >
    <!--<div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home </router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">| Logout</router-link>
    </div> -->
    <router-view />
  </div>
</template>


<style>

@import "~bulma/css/bulma.css";

#app{
  /*background-image: url("https://images.pexels.com/photos/733852/pexels-photo-733852.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"); */
  height:100vh ;
  width: 100vmax;
  background-size: 100% ;
  background-repeat: no-repeat;
  background-size: cover ;
  margin: 0;
  padding: 0;
  border: 0;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
} 
#nav{
  width: 100%;
  position: relative;
  text-align: center;
  top: 0;

} 

</style>