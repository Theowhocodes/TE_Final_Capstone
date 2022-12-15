<template>
  <div id="app" >
    <router-view />
  </div>
</template>

<script>


export default {
  components: {  },

}
</script>



<style>

@import url('https://fonts.googleapis.com/css?family=Droid+Serif|Roboto:300');

@import "~bulma/css/bulma.css";



#app{
  
  background-color: #f2f2f3;
  height:100% ;
  width: 100%;
  background-size: 100% ;
  background-repeat: no-repeat;
  background-size: cover ;
  margin: 0;
  padding: 0;
  border: 0;
  /*font-family: Roboto, Geneva, Tahoma, sans-serif;*/
} 
#nav{
  width: 100%;
  position: relative;
  text-align: center;
  top: 0;
  font-family: Roboto, sans-serif;

} 

#tileTitle{
  color: #53435b;
  font-family: Roboto, sans-serif;
}

#tileText{
 Font-Family: 'Droid Serif', serif;
color: #000000;
}

#tileLink{
  color: #a5a63c;
  Font-family: 'Droid Serif', serif;
}


</style>