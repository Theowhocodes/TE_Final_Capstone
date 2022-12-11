<template>
  <div >
      <h3>Your Shopping Groups</h3>
      <div class= "groupList"
      v-for="group in groups"
      v-bind:key="group.groupId"
      v-bind:group="shoppingGroup"
      >
      
       Group name: <router-link v-bind:to="{ name: 'group', params: { groupId: group.groupId}  }">
          {{ group.groupName }} </router-link> | Member since: {{group.memberSince}} | Invitation Code: {{group.invitationCode}}
   
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
