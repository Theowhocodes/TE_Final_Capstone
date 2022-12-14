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

@import url('https://fonts.googleapis.com/css?family=Droid+Serif|Roboto:300');

@import "~bulma/css/bulma.css";



#app{
  
  background-color: #7aa5d2;

  height:100% ;
  width: 100%;
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