<template>
  <div >
      <form>
          <input type="text" /> Enter Invitation Code
      </form>
      <h1>Your Shopping Groups</h1>
      <div class= "groupList"
      v-for="group in groups"
      v-bind:key="group.groupId"
      v-bind:group="shoppingGroup"
      >
      
       Group name: <router-link v-bind:to="{ name: 'list', params: { groupId: group.groupId}  }">
          {{ group.groupName }} </router-link> | Member since: {{group.memberSince}} 
          
     
        
      </div>
  </div>
</template>

<script>

// can maybe use a created property to return membership age another way aside from days? 

import groupService from '../services/GroupService.js';

export default {
  data() {
    return {
    groups: [],
    group: {

    },
    };
  },

  created() {
    groupService.getAllShoppingGroupsByUser().then(response => {
      this.groups = response.data;
      
      
    });
  }

  

}
</script>

<style>

</style>
