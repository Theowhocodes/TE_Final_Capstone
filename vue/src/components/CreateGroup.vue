<template>
  <div>
      <div class="create-group">
        <h3 id="tileText" >Create a new group and invite your friends!</h3> <br>
        <p id="tileText" > Enter a group name below to create a new shopping group:</p><br>

        <form id="tileText" class="group-form">
         <label id="tileTitle" for="groupName">GROUP NAME: </label>
        <input class="input is-small" type="text" placeholder="Group Name" name="groupName" v-model="shoppingGroup.groupName" maxlength="200" id="groupName">
        <button class="button is-small is-light" type="button" v-on:click="createShoppingGroup()" name="create" id="create">Create Group</button>
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
            if (error.response.status === 400) {
          alert("Group Name is Required!");
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
.button{
  margin: 4px;
}

</style>
