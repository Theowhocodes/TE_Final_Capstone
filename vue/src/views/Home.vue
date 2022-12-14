<template>
<section id="homescreen" class="is-relative section">
    <div class="columns">
      <div class="column is-full">
        <div class="has-mw-md has-mw-xl-widescreen mx-auto py-12 px-8-mobile px-14-tablet has-background-white">
         <br> <h2 class="title is-size-2 has-leading-2 has-text-link has-text-centered has-text-weight-bold">Welcome Back to Listmate<br> Let's Start Shopping!</h2> <br>
        </div>
  <div class="home has-text-centered">
    <div class="column is-full">
        <div class="has-mw-md has-mw-xl-widescreen mx-auto py-12 px-8-mobile px-14-tablet has-background-white">
          <h3 class="title is-size-3 has-leading-3 has-text-link has-text-bold">Join</h3> 
    <join-group />
        </div>
    </div>
    <div class="column is-full">
        <div class="has-mw-md has-mw-xl-widescreen mx-auto py-12 px-8-mobile px-14-tablet has-background-white">
          <h3 class="title is-size-3 has-leading-2 has-text-link has-text-bold">Create</h3> 
          <create-group />
        </div>
    </div>
     <div class="column is-full">
        <div class="has-mw-md has-mw-xl-widescreen mx-auto py-12 px-8-mobile px-14-tablet has-background-white">
          <h2 class="title is-size-3 has-leading-2 has-text-link">Your Groups</h2> 
    <all-groups/>
        </div>
     </div>
    <br />
    <br />
  </div>
  </div>
  </div>
</section>
</template>

<script>
import AllGroups from '../components/AllGroups.vue';
import CreateGroup from '../components/CreateGroup.vue';
import JoinGroup from '../components/JoinGroup.vue';


export default {
  components: {
    AllGroups,
    CreateGroup,
    JoinGroup,
    
  },
  name: "home"
};
</script>

<style>
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
