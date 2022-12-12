<template>
  <div>
      <h3> {{ list.listName }} | {{ list.claimed ? `Claimed by: ${list.listOwnerName}` : "Unclaimed" }} </h3>
      <button @click="claimList()">
         {{ list.claimed ? "Unclaim" : "Claim" }}
         </button>
         
    

      <div class= "itemsInList"
      v-for="item in items"
      v-bind:key="item.listId"
      v-bind:item="item"
      > 
      <router-link v-bind:to="{ name: 'item', params: { itemId: item.itemId } }">
          {{ item.itemName }} </router-link>
      </div>

      



  </div>
</template>

<script>
import listService from '../services/ListService.js'

export default {
    data() {
        return {
        list: {

        },
        items: [],
        item: {

        }
        }
    },
    
    created() {
        const listId = this.$route.params.listId;

        listService.getListByListId(listId).then(response => {
            this.list = response.data;
        });
        listService.getAllItemsInList(listId).then(response => {
            this.items = response.data;
        });

        // listService.claimList(listId).then(response => {

        // })


    }

}
</script>

<style>

</style>