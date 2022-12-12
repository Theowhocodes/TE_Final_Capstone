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
  /* background-image: url("https://media.wired.com/photos/5c9040ee4950d24718d6da99/16:9/w_2400,h_1350,c_limit/shoppingcart-1066110386.jpg"); */
  height:100vh ;
  width: 100vmax;
  background-size: 100% ;
  background-repeat: no-repeat;
  background-size: cover ;
  margin: 0;
  padding: 0;
  border: 0;
  overflow: hidden;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
}
#nav{
  width: 100%;
  position: relative;
  text-align: center;
  top: 0;

}
</style>