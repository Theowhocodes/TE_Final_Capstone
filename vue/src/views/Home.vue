<template>
  <div class="home" >
    <h1>Home</h1>
    <the-board/>
  </div>
</template>

<script>
import TheBoard from '../components/TheBoard.vue';



export default {
  components: {TheBoard  },
  name: "home"
};
</script>

<style scoped>
#groupBoard{
  height:100vh ;
  width: 100vmax;
  background-size: 100% ;
  background-repeat: no-repeat;
  background-size:contain ;
  margin: 0;
  padding: 0;
  border: 0;
}


</style>
