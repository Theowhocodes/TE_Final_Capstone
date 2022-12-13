<template>
  <div>
      <div class="leave-group has-text-centered">
        
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
