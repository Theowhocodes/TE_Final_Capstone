<template>
  <div>
      <div class="join-group">
        <p id="tileText">Join a group and start collaborating on a list!</p> <br>
        <p id="tileText"> If you have received an invitation code to join a group, enter it below:</p><br>

        <form class="group-form">
         <label id="tileTitle" for="invitationCode">INVITATION CODE:</label>
        <input class="input is-small" type="text" placeholder="Enter code here" name="invitationCode" v-model="groupToJoin.invitationCode" maxlength="200" id="joinGroup">
        <button class="button is-link is-light is-small is-outlined center" type="button" v-on:click="joinGroupByInvitationCode()" name="join" id="join">Join Group</button>
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
