<template>
  <div>
      <h3> {{ list.listName }} | {{ list.claimed ? `Claimed by: ${list.listOwnerName}` : "Unclaimed" }} </h3>
    <!--<button @click="claimList()">
         {{ list.claimed ? "Unclaim" : "Claim" }}
         </button> --> 

         <button @click="claimList()"> Claim List</button>

         <button @click="unclaimList()">Unclaim List</button> 

         
    

      <div class= "itemsInList"
      v-for="item in items"
      v-bind:key="item.itemId"
      v-bind:item="item"
      > 
      <router-link v-bind:to="{ name: 'item', params: { itemId: item.itemId } }">
          {{ item.itemName }} </router-link> | Quantity: {{item.itemQuantity}} 
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

    }, 

    methods: {
    claimList() {
       const listId = this.$route.params.listId
         listService.claimList(listId).then(response => {
            if (response.status === 200){
          window.location.reload();
          }

            
        })
    }, 

    unclaimList() {
       const listId = this.$route.params.listId
         listService.unclaimList(listId).then(response => {
            if (response.status === 200){
          window.location.reload();
          }

            
        })
    }
  }

}

</script>

<style>

</style>