<template>
  <div>
      <div class="join-group">
        <h3>Join a group</h3>
        <p>If you have received an invitation code to join a group, enter it below:</p>

        <form class="group-form">
         <label for="invitationCode">Invitation code:</label>
        <input type="text" placeholder="Enter code here" name="invitationCode" v-model="groupToJoin.invitationCode" maxlength="200" id="joinGroup">
        <button type="button" v-on:click="joinGroupByInvitationCode()" name="join" id="join">Join Group</button>
        </form>
      </div>
  </div>
</template>

<script>
import groupService from "../services/GroupService";

export default {
  name: "join-group",
  data() {
    return {
        
      groupToJoin: {
       invitationCode: ""
      }
    };
  },
 methods: {
    joinShoppingGroup() {
     
      groupService.joinShoppingGroup(this.groupToJoin).then(response => {
        if (response.status === 200){
          window.location.reload();
          //this.$router.push({ name: 'home'});
        }

      })

    },

    joinGroupByInvitationCode() {
        groupService.getGroupByInvitationCode(this.groupToJoin.invitationCode).then(response => {
           // console.log(response);
           // console.log(response.data.groupId)
            groupService.joinShoppingGroup(response.data.groupId)
            window.location.reload();

            // make call to get group id, then make another call to join group 
            
        })
    }
  }
}
</script>

<style>
.group-form{
    display: inline-block;
}

</style>
