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