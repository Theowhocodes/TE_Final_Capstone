<template>
  <div>
      <h3> {{ list.listName }} | {{ list.claimed ? `Claimed by: ${list.listOwnerName}` : "Unclaimed" }} </h3>
     

         <button @click="claimList()"> Claim List</button>

         <button @click="unclaimList()">Unclaim List</button> 

         
    

      <div class= "itemsInList"
      v-for="item in items"
      v-bind:key="item.itemId"
      v-bind:item="item"
      > 
      <p>
        Complete?
        <input type="checkbox" v-model="item.completed" v-bind:class="{ completed: item.completed }" @change="completed()"/>
      </p>
      <router-link v-bind:to="{ name: 'item', params: { itemId: item.itemId } }">
          {{ item.itemName }} </router-link> | Quantity: {{item.itemQuantity}} 
      
      </div>
      <div>
      <button @click="clearAllItemsFromList()">Clear all items from list</button>
        </div>


  </div>
</template>

<script>
import itemService from '../services/ItemService.js';
import listService from '../services/ListService.js'

export default {
    data() {
        return {
        //isCompleted: "",
        list: {

        },
        items: [],
        item: {
          itemId: "",
          completed: ""
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
        itemService.getItem(this.item.itemId).then(response => {
            this.item.completed = response.data.completed
        })
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
    },

    clearAllItemsFromList() {
       if(confirm("Clear list? This action cannot be undone!")){
        const listId = this.$route.params.listId
            listService.clearAllItemsFromList(listId).then(response => {
                if (response.status === 200){
                    listService.unclaimList(listId).then(response =>{
                        if (response.status === 200){
                            window.location.reload();
                        }
                    })
                    
                }
            })
       }
    },
    completed() {
      itemService.completeStatus(this.item).then(response => {
          if (response.status === 200){
          window.location.reload()
        }
      })
    }
  }

}

</script>

<style>

</style>