<template>
  <div>
    <div id="create-new-item">
      <p id="tileText">Add a new item to your list</p>
    </div>
<div>
      <form>
        <div class="form-element">
          <label id="tileText" for="itemName">Name: </label>
          <input id="itemName" class="input is-small" placeholder="Item name" type="text" v-model="item.itemName" />
        </div>
        <br>
        <div class="form-element">
          <label id="tileText" for="itemQuantity"> Quantity: </label> 
          <select id="quantity" v-model.number="item.itemQuantity" required>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
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
          }})
          .catch((error) => {
            if (error.response.status === 400) {
          alert("Please make sure you have entered an item name and quantity of at least one!");
        }
         
      })

    }
  }
  }
  
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
