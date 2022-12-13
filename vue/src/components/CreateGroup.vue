<template>
  <div>
      <div class="create-group">
        <h3>Create a New Group</h3> <br>
        <p> Enter a group name below to create a new shopping group:</p>

        <form class="group-form">
         <label for="groupName">Group Name:</label>
        <input type="text" placeholder="Group Name" name="groupName" v-model="shoppingGroup.groupName" maxlength="200" id="groupName">
        <button type="button" v-on:click="createShoppingGroup()" name="create" id="create">Create Group</button>
        </form>
      </div>
  </div>
</template>

<script>
import groupService from "../services/GroupService";

export default {
  name: "create-group",
 
  data() {
    return {
      shoppingGroup: {
       groupName: "",
       invitationCode: Math.floor(Math.random() * (100000))
      }
    };
  },
  methods: {
    createShoppingGroup() {
      groupService.createShoppingGroup(this.shoppingGroup).then(response => {
        if (response.status === 201){
          window.location.reload(); 
          }})
         .catch((error) => {
            if (error.response.status === 404) {
          this.$alert("Group Name is Required");
        }
         
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
