<template>
  <div>
      <h3 class="is-size-3 has-text-centered has-text-link has-text-weight-bold"> {{ list.listName }} | {{ list.claimed ? `Claimed by: ${list.listOwnerName}` : "This List is Unclaimed" }} </h3>
     

         <div class="has-text-centered">
           <br>
          
         <button class="button is-link is-light is-small is-outlined center" type="button" @click="claimList()"> Claim List</button>
          
         <button class="button is-link is-light is-small is-outlined center" type="button" @click="unclaimList()">Unclaim List</button> 
          

         </div>

         
    

      <div class= "itemsInList"
      v-for="item in items"
      v-bind:key="item.itemId"
      v-bind:item="item"
      > 
      <p>
        Complete?
        <input type="checkbox" v-model="item.completed" v-bind:class="{ completed: item.completed }" @change="completed(item)"/>
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
          completed: false
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
        // itemService.getItem(this.item.itemId).then(response => {
        //     this.item.completed = response.data.completed
        // })
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
    completed(item) {
      itemService.completeStatus(item).then(response => {
         response.data = this.item.completed
        
      })
    }
  }

}

</script>

<style>
#list-detail{
 margin: auto;
 width: 400px; 
 height: 400px;
 background: yellow;
 background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#EBEB00), to(#C5C500));
 background: -moz-linear-gradient(100% 100% 90deg, #C5C500, #EBEB00);
 padding: 20px 20px 20px 20px;
 -webkit-box-shadow: 0px 10px 30px #000;
 -moz-box-shadow: 0px 10px 30px #000
}

</style>