<template>
  <div>
    <div class="modify-item">
      <h2>Modify {{item.itemName}} </h2>

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
import ItemService from '../services/ItemService';

export default {
    name: "modify-item",

    data() {
        return {
            item: {
              itemName: "",
              itemId: this.$route.params.itemId,
              itemQuantity: "",
              modifiedBy: this.$store.state.user.id
            }
        };
    },
    methods: {
        modifyItem() {
         
            ItemService.modifyItem(this.item.itemId).then(response => {
                if (response.status === 201){
              this.$router.push({ name: 'list'});
            }});
        }
    }
};
</script>

<style>
.form-element {
    display: inline-block;
}
</style>