<template>
  <div>
    <div class="modify-item">
      <h2>Modify {{ this.originalName }} </h2> 

      <form>
        <div class="modify-element">
          <label for="itemName">Name:</label>
          <input id="itemName" type="text" v-model="item.itemName" />
        </div>
        <div class="modify-element">
          <label for="itemQuantity">Quantity</label>
          <select id="quantity" v-model.number="item.itemQuantity">
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
        <button
          type="button"
          v-on:click="modifyItem()"
          name="modifyItem"
          id="modifyItem"
        >
          Keep Changes
        </button>
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
               
                if (response.status === 200){
                this.$router.go(-1);
            }})
            })
        }, 
        

    },
    created() {
      itemService.getItem(this.$route.params.itemId).then(response => {
        this.originalName = response.data.itemName,
        this.item.listId = response.data.listId,
        this.item.dateAdded = response.data.dateAdded,
        this.item.addedBy = response.data.addedBy
      })
    }
};
</script>

<style>
.form-element {
    display: inline-block;
}
</style>