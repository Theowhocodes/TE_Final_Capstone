<template>
  <div >
      <form>
          <input type="text" /> Enter Invitation Code
      </form>
      <h3>Create a list</h3>
      <h3>Your Group Lists</h3>
      <div class= "groupList"
      v-for="list in lists"
      v-bind:key="list.groupId"
      v-bind:list="list"
      >
      <table id="tileText" class="table">
      List name: <router-link v-bind:to="{ name: 'list', params: { id: groupId } }">
          {{list.listName}} </router-link>  | 
     
        
      </div>
  </div>
</template>

<script>

// can maybe use a created property to return membership age another way aside from days? 

import groupService from '../services/GroupService.js';

export default {
  data() {
    return {
    lists: [],
    list: {

    },
    };
  },

  created() {
    const groupId = this.$route.params.groupId; 
    groupService.getAllListsByGroupId(groupId).then(response => {
    this.lists = response.data; 
      
    });
  }

  

}
</script>

<style>

</style>
