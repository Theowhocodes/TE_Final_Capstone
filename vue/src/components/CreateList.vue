<template>
  <div>
    <br><br>
      <div class="create-list has-text-centered">
        <h4 class="is-size-3 has-text-link has-text-weight-bold">Create a New List</h4>
        <p class="is-size-5 has-text-weight-semibold has-text-link"> Let's Give Your List a Name:</p>
<div>
        <form id="listInput" class="list-form has-text-link">
         <label for="listName"></label><br>
        <input class="has-text-centered is-link" type="text" placeholder="Your New Listname" name="listName" v-model="shoppingList.listName" maxlength="200" id="listName">
        <br> <br><button  class="button is-link is-light is-medium is-outlined center" type="button" v-on:click="createShoppingList()" name="create" id="create">Create List</button>
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