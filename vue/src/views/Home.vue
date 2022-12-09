<template>
  <div  >

    <!-- <h1 class="has-text-centered">Home</h1> -->
    <div class="columns">
    <the-board class="column is-8 offset-2 is-centered "/>
    <music-player id="musicPlayer" class="column is-1 "/>
    </div>
  </div>
</template>

<script>
import TheBoard from '../components/TheBoard.vue';
import MusicPlayer from '../components/MusicPlayer.vue';


export default {
  components: {
    TheBoard, MusicPlayer  
  },
  name: "home"
};
</script>

<style scoped>

#musicPlayer{
  display: flex;
  width: 30%;
  height: max-content;
}


</style>
