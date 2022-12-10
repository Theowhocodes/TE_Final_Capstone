<template>
  <div>
      <div class="join-group">
        <h3>Join a group</h3>
        <p>If you have received an invitation code to join a group, enter it below:</p>

        <form class="group-form">
         <label for="invitationCode">Invitation code:</label>
        <input type="text" placeholder="Enter code here" name="invitationCode" maxlength="200" id="joinGroup">
        <button type="button" v-on:click="joinShoppingGroup()" name="join" id="join">Join Group</button>
        </form>
      </div>
  </div>
</template>

<script>
//import groupService from "../services/GroupService";

export default {
  name: "join-group"
 
}
</script>

<style>
.group-form{
    display: inline-block;
}

</style>
