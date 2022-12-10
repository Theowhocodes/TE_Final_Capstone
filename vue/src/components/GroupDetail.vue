<template>
  <div >
     
      <h3> {{group.groupName}} | Invitation Code: {{group.groupId}}</h3>

     
      <h4>Create a list</h4>
      <h4>Your Group Lists</h4>
      <div class= "groupList"
      v-for="list in lists"
      v-bind:key="list.groupId"
      v-bind:list="list"
      >
      
      List name: <router-link v-bind:to="{ name: 'list', params: { id: groupId } }">
          {{list.listName}} </router-link>  
     
        
      </div>
  </div>
</template>

<script> 

import groupService from '../services/GroupService.js';

export default {
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
