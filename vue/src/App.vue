<template>
  <div id="app" >
    <router-view />
  </div>
</template>


<style>

@import "~bulma/css/bulma.css";

#app{

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