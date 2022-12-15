<template>
  <div>
    <br><br>
      <div class="create-list">
        <p id="tileText">Create a new list and start adding items now! Enter a name for your new list below:</p>
<div>
        <form id="listInput">
         <label for="listName"></label>
         <input class="input is-small" type="text" placeholder="List Name" name="listName" v-model="shoppingList.listName" maxlength="200">
      <br><button class="button is-small is-light" type="button" v-on:click="createShoppingList()" name="create" id="create">Create List</button>
        </form>
</div>
      </div>
  </div>
</template>

<script>
import listService from "../services/ListService";

export default {
  name: "create-list",
 
  data() {
    return {
      shoppingList: {
       listName: "",
       groupId: this.$route.params.groupId
      }
    };
  },
  methods: {
    createShoppingList() {
      listService.createShoppingList(this.shoppingList).then(response => {
        if (response.status === 201){
          window.location.reload();
          //this.$router.push({ name: 'home'});
        }})
        .catch((error) => {
            if (error.response.status === 400) {
          alert("List name is required!");
        }
         
      })

    }
  }
};
</script>
<style>
input{
  width: 30%;
  height: 30px;
  border: 2px solid rgb(74, 8, 230);
}



</style>