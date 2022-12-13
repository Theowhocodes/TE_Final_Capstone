<template>
<section id="homescreen" class="is-sticky section">
  <div >
    <weather />
  </div>
    <div class="columns">
      <div class="column is-full">
        <div class="has-mw-md has-mw-xl-widescreen mx-auto py-12 px-8-mobile px-14-tablet has-background-white">
         <br> <h2 class="title is-size-4 has-leading-2 has-text-link has-text-centered">Welcome Back <br> Let's Start Shopping!</h2> <br>
        </div>
        
  <div class="home has-text-centered">
    <div class="column is-full">
        <div class="has-mw-md has-mw-xl-widescreen mx-auto py-12 px-8-mobile px-14-tablet has-background-white">
          <h3 class="title is-size-4 has-leading-3 has-text-link">Join</h3> 
    <join-group />
        </div>
    </div>
    <div class="column is-full">
        <div class="has-mw-md has-mw-xl-widescreen mx-auto py-12 px-8-mobile px-14-tablet has-background-white">
          <h3 class="title is-size-4 has-leading-2 has-text-link">Create</h3> 
          <create-group />
        </div>
    </div>
     <div class="column is-full">
        <div class="has-mw-md has-mw-xl-widescreen mx-auto py-12 px-8-mobile px-14-tablet has-background-white">
          <h2 class="title is-size-4 has-leading-2 has-text-link">Your Groups</h2> 
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
import Weather from '@/components/Weather.vue';



export default {
  components: {
    AllGroups,
    CreateGroup,
    JoinGroup,
    Weather,
  
    
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
.homescreen{
background-color: chartreuse;
}

</style>
