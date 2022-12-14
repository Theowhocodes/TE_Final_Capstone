<template>
  <div>
      <h3 class="has-text-link has-text-weight-bold">Pick a group and start making lists!</h3> <br>
      <div
      v-for="group in groups"
      v-bind:key="group.groupId"
      v-bind:group="shoppingGroup"
      >
<<<<<<< HEAD
  
       Group name: <router-link v-bind:to="{ name: 'group', params: { groupId: group.groupId}  }">
          {{ group.groupName }} </router-link> | Member since: {{group.memberSince}} | Invitation Code: {{group.invitationCode}}
=======
      
      <router-link v-bind:to="{ name: 'group', params: { groupId: group.groupId}  }">
          {{ group.groupName }} </router-link> | Member since: {{group.memberSince}} 
   
>>>>>>> 5e45b06ece06bfeef7750309df1e4e2ddad72eef
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
