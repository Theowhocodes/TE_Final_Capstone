<template>
  <div id="groupDetails" >
    
      <h3> {{group.groupName}} | Invitation Code: {{group.invitationCode}}</h3>
      <h4>Your Group Lists</h4>
      <div class= "groupList"
      v-for="list in lists"
      v-bind:key="list.groupId"
      v-bind:list="list"
      >
      
      List name: <router-link v-bind:to="{ name: 'list', params: { listId: list.listId } }">
          {{list.listName}} </router-link> | Total items on list: {{list.count}} | List status: {{ list.claimed ? "Claimed" : "Unclaimed" }}
    
    
      </div>
  </div>
</template>

<script> 

import groupService from '../services/GroupService.js';

export default {
  name: "group-detail",

  data() {
    return {
    lists: [],
    list: {

    },

    group: {

    }
    };
  },

  created() {
    const groupId = this.$route.params.groupId; 

    groupService.getAllListsByGroupId(groupId).then(response => {
      console.log(response)
    this.lists = response.data; 
      
    });

    groupService.getOneGroupById(groupId).then(response => {
      this.group = response.data;
    }
    )
  }

  

}
</script>

<style>

</style>
