<template>
  <header class="header">
  <hgroup>
      <h1>Welcome Back!</h1>
      </hgroup>
    <join-group />
    <br />
    <br />
    <create-group/>
 
      <dt>Your shopping groups</dt>
    <dt> <all-groups/> </dt>

  <!-- <a href="#" class="toggle">Toggle</a> -->
</header>
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
#groupBoard{
  height:100vh ;
  width: 100vmax;
  background-size: 100% ;
  background-repeat: no-repeat;
  background-size:contain ;
  margin: 0;
  padding: 0;
  border: 0;
  position: absolute;
}


</style>
