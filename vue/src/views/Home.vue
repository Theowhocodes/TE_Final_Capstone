<template>
  <div  >

    <!-- <h1 class="has-text-centered">Home</h1> -->
    <div class="columns">
    <the-board class="column is-8 offset-2 is-centered "/>
    <music-player id="musicPlayer" class="column is-1 "/>
    </div>
  <div class="home" >
    <h3>Welcome back!</h3>
    <join-group />
    <all-groups/>
    <br />
    <br />
    <create-group />
  </div>
</template>

<script>
import AllGroups from '../components/AllGroups.vue';
import CreateGroup from '../components/CreateGroup.vue';
import JoinGroup from '../components/JoinGroup.vue';


export default {
  components: {
    AllGroups,
    CreateGroup,
    JoinGroup
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
