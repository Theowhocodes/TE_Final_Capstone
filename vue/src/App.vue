<template>
  <div id="app" >
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home </router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">| Logout</router-link>
    </div>
    <router-view />
  </div>
</template>


<style>

@import "~bulma/css/bulma.css";


#app{
 /* background-image: url("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/yellow-notebook-paper-background-design-template-d7dfa26f8c8c759652e2521f0ecd24eb_screen.jpg?ts=1636990781");*/ 
  height:100vh ;
  width: 100vmax;
  background-size: 100% ;
  background-repeat: no-repeat;
  background-size: cover ;
  margin: 0;
  padding: 0;
  border: 0;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  overflow: auto;
} 
#nav{
  width: 100%;
  position: relative;
  text-align: center;
  top: 0;
  overflow: auto;
} 

</style>