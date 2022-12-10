<template>
  <div class="item">
      
      <delete-item/>
      <modify-item/>
    
  </div>
</template>

<script>
import DeleteItem from '../components/DeleteItem.vue'
import ModifyItem from '../components/ModifyItem.vue'

export default {
  components: { DeleteItem, ModifyItem },
  
}
</script>

<style>


</style>