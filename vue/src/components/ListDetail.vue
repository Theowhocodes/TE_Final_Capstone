<template>
<<<<<<< HEAD
<div>
{{ item.itemName }}
    </div>
</template>

<script>

// import ItemService from '../services/ItemService.js'; 
export default { 
    data() {
        return {
           
        };
    }
}

</script>


=======
  <div>
      <h3> {{ list.listName }} </h3>

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
>>>>>>> 489e82f5c6f05b6feee348b70a9680f5bf99d00b

<style>

</style>