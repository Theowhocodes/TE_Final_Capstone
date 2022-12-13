<template>
  <div>
    <div id="create-new-item">
      <h2 class=" has-text-centered has-text-weight-bold is-size-4 has-text-link">Add a New Item to Your List</h2>
    </div>
<div class="has-text-link has-text-centered">
      <form>
        <div class="form-element">
          <label class=" has-text-centered has-text-weight-bold is-size-4 has-text-link" for="itemName">Name: </label>
          <input class=" has-text-centered has-text-weight-bold is-size-4 has-text-link" id="itemName" type="text" v-model="item.itemName" />
        </div>
        <br>
        <div class="form-element">
          <label class=" has-text-centered has-text-weight-bold is-size-4 has-text-link" for="itemQuantity"> Quantity </label> 
          <select id="quantity" v-model.number="item.itemQuantity" required>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="5">6</option>
            <option value="5">7</option>
            <option value="5">8</option>
            <option value="5">9</option>
            <option value="5">10</option>
          </select>
        </div>
        <br>
        <br>
        <button class="button is-link is-light is-small is-outlined center" type="button" v-on:click="createNewItem()" name="createItem" id="createItem">Add to List</button>
      </form>
    </div>
  </div>
</template>

<script>
import itemService from "../services/ItemService.js";
import moment from 'moment';


export default {
  name: "create-item",

  data() {
    return {
     
      item: {
          itemName: "",
          itemQuantity: "",
          listId: Number(this.$route.params.listId),
          addedBy: this.$store.state.user.id,
          dateAdded: moment().format("YYYY-MM-DD")
        },
    };
  },
  methods: {
      createNewItem() {

      itemService.createNewItem(this.item).then(response => {
          if (response.status === 201){
              window.location.reload();
          }
      })
  }
  }
  
};
</script>

<style>
.form-element {
    display: inline-block;
}
#itemName{
  width: 60%;
  height: 35px;
}
</style>
