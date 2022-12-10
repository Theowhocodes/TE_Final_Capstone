<template>
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
