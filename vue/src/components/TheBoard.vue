<template>
  <div >
      <form class="has-text-centered">
          <input class="has-text-centered" type="text" placeholder="Enter Invite Code" /> 
      </form>

      <h1 class="has-text-centered">Your Shopping Groups</h1>
      <div class= " groupList section is-medium"
      v-for="group in groups"
      v-bind:key="group.groupId"
      v-bind:group="shoppingGroup"
      >
      <router-link class="fa fa-group" style="font-size:36px" v-bind:to="{ name: 'Group', params: { id: groupId } }">
          {{ group.groupName }} </router-link>
     
        
      </div>
  </div>
</template>

<script>
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

.musicPlayer{
  display: inline-flex;
  width: 30%;
}



</style>

// v-for="review in filteredReviews"
//       v-bind:key="review.title"
//       v-bind:review="review"