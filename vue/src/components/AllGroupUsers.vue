<template>
  <section>

      <div id="tileText" class="block"> All users belonging to this group:</div>
      
      <div class= "userList"
      v-for="user in users"
      v-bind:key="user.groupId"
      v-bind:user="user"
      >
      <content id="tileText">
        <ul>
            <li>{{user.username}}</li>
        </ul>
        </content>
     
        
      </div>
      </section>
</template>

<script>

import groupService from "../services/GroupService.js";

export default {
  data() {
    return {
      users: [],
      user: {},
    };
  },

  created() {
      const groupId = this.$route.params.groupId; 
    groupService.getAllUsersByGroupId(groupId).then((response) => {
      this.users = response.data;
    });
  },
};
</script>

<style>

</style>