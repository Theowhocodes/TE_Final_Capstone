<template>
  <div id="app" >
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>


<style>
#app{
  background-image: url("https://media.wired.com/photos/5c9040ee4950d24718d6da99/16:9/w_2400,h_1350,c_limit/shoppingcart-1066110386.jpg");
  height:100vh ;
  width: 100vmax;
  background-size: 100% ;
  background-repeat: no-repeat;
  background-size: cover ;
  margin: 0;
  padding: 0;
  border: 0;
  overflow: hidden;
}
</style>