<template>
  <div>
      <div class="leave-group">
        
        <button type="button" v-on:click="leaveShoppingGroup()" name="leave" id="leave">Leave this Group</button>
        <br>
      </div>
  </div>
</template>

<script>
import groupService from "../services/GroupService";

export default {
name: "leave-group",

created() {
    
},
  methods: {
    leaveShoppingGroup() {
    const groupId = this.$route.params.groupId; 
      groupService.leaveShoppingGroup(groupId).then(response => {
        if (response.status === 200){
            this.$router.push({ name: 'home'});
        }

      })

    }
  }
  }
</script>

<style>

</style>
