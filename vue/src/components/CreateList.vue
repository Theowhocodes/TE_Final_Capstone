<template>
  <div>
      <div class="create-list">
        <h4>Create a New List</h4>
        <p> Enter a list name below to create a new shopping list:</p>

        <form class="list-form">
         <label for="listName">List Name:</label>
        <input type="text" placeholder="List Name" name="listName" v-model="shoppingList.listName" maxlength="200" id="listName">
        <button type="button" v-on:click="createShoppingList()" name="create" id="create">Create List</button>
        </form>
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

</style>