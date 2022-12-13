<template>
  <div class="has-text-link has-text-weight-bold" >
      <h3 class="has-text-link has-text-weight-bold">Pick a group and start making lists!</h3> <br>
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
#all-groups{
 margin: auto;
 width: 300px; 
 background: yellow;
 background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#EBEB00), to(#C5C500));
 background: -moz-linear-gradient(100% 100% 90deg, #C5C500, #EBEB00);
 padding: 20px 20px 20px 20px;
 -webkit-box-shadow: 0px 10px 30px #000;
 -moz-box-shadow: 0px 10px 30px #000
}



</style>
