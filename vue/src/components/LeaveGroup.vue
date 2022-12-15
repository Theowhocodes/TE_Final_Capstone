<template>
  <div>
      <div class="leave-group">
        <p id="tileText">Click the button below to leave this group. You will need to use your invitation code again if you want to re-join in the future.</p>
        
        <button class="button is-link is-light is-medium is-outlined center" type="button" v-on:click="leaveShoppingGroup()" name="leave" id="leave">Leave This Group?</button>
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
    if(confirm("Are you sure you want to leave this group?"));
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
#leave{
margin: auto;
}

</style>
