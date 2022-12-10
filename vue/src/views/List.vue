<template>
  <div>
      <list-detail/>
      
      <create-item/>
    </div>
</template>

<script>
import CreateItem from '../components/CreateItem.vue'
import ListDetail from '../components/ListDetail.vue'

export default {
  components: {
    ListDetail,
    CreateItem, 
  }
}
</script>
    

<style>

</style>