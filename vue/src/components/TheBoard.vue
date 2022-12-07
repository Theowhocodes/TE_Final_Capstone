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
      <router-link v-bind:to="{ name: 'Group', params: { id: groupId } }">
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

</style>

// v-for="review in filteredReviews"
//       v-bind:key="review.title"
//       v-bind:review="review"