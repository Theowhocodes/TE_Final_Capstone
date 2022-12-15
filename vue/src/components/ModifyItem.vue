<template>
  <div>
    <div class="modify-item">
      <p id="tileText">Modify {{ this.originalName }} </p> 

      <form>
        <div class="modify-element">
          <label for="itemName"><p id="tileText">Name:</p></label>
          <input class="input is-small" id="itemName" type="text" placeholder="Edit item name" v-model="item.itemName" />
        </div>
        <div class="modify-element">
          <label for="itemQuantity"> Quantity: </label>
          <select id="quantity" v-model.number="item.itemQuantity">
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
        <button class="button is-small is-light"
          type="button"
          v-on:click="modifyItem()"
          name="modifyItem"
          id="modifyItem"
        >
          Keep Changes
        </button>
        <button class="button is-small is-light" type="button" @click="$router.go(-1)" name="cancelModification" id="cancelModification">Cancel</button>
        
      </form>
    </div>
  </div>
</template>

<script>
import itemService from '../services/ItemService';
import moment from 'moment';

export default {
    name: "modify-item",

    data() {
        return {
            originalName: "",
            item: {
              itemName: "",
              listId: "",
              dateAdded:"",
              addedBy:"",
              itemId: this.$route.params.itemId,
              itemQuantity: "",
              lastModifiedBy: this.$store.state.user.id,
              lastModified: moment().format()
            }
        };
    },
    methods: {
        modifyItem() {
            itemService.getItem(this.$route.params.itemId).then(response => {
            
            itemService.modifyItem(response.data.itemId, this.item).then(response => {
                if (this.item.itemName === "") {
                  this.item.itemName = this.originalName
                }
                if (response.status === 200){
                this.$router.go(-1);
            }})
            })
        }, 
        

    },
    created() {
      itemService.getItem(this.$route.params.itemId).then(response => {
        //this.item.itemName = response.data.itemName,
        this.originalName = response.data.itemName,
        this.item.listId = response.data.listId,
        this.item.dateAdded = response.data.dateAdded,
        this.item.addedBy = response.data.addedBy
        this.item.itemQuantity = response.data.itemQuantity
      })
    }
};
</script>

<style>
.form-element {
    display: inline-block;
}
</style>