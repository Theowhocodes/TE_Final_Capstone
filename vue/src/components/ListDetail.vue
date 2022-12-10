<template>
  <div>
      <h3> {{ list.listName }} </h3>

      <div class= "itemsInList"
      v-for="item in list"
      v-bind:key="item.listId"
      v-bind:item="item"
      >
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
        }
    },
    
    created() {
        const listId = this.$route.params.listId;

        listService.getListByListId(listId).then(response => {
            this.list = response.data;
        });
        
        // listService.claimList(listId).then(response => {

        // })


    }

}
</script>

<style>

</style>