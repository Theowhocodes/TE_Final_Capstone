<template>
  <div class="has-mw-md has-mw-xl-widescreen mx-auto py-12 px-8-mobile px-14-tablet has-background-white">
    
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

<<<<<<< HEAD
<style>

=======
<style> /*
#groupDetails{
 margin: auto;
 overflow: auto;
 width: 300px; 
 height: 300px;
 background: yellow;
 background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#EBEB00), to(#C5C500));
 background: -moz-linear-gradient(100% 100% 90deg, #C5C500, #EBEB00);
 padding: 20px 20px 20px 20px;
 -webkit-box-shadow: 0px 10px 30px #000;
 -moz-box-shadow: 0px 10px 30px #000
} */
>>>>>>> b492c12f3cac025d9f951ef659a4151036356618
</style>
