<template>
  <div>
      <div class="create-group">
        <h3 id="tileText" class="has-text">Create a new group and invite your friends!</h3> <br>
        <p id="tileText" class="has-text-black"> Enter a group name below to create a new shopping group:</p><br>

        <form class="group-form has-text-weight-bold">
         <label for="groupName">Group Name: </label>
        <input class="input is-small" type="text" placeholder="Group Name" name="groupName" v-model="shoppingGroup.groupName" maxlength="200" id="groupName">
        <button class="button is-link is-light is-small is-outlined center" type="button" v-on:click="createShoppingGroup()" name="create" id="create">Create Group</button>
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
