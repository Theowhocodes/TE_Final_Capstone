<template>
  <div class="item">
      <div class="tile is-ancestor">
  <div class="tile is-4">
      <delete-item/>
      <div class="tile is-4 is-vertical is-parent">
    <div class="tile is-child box">
      <modify-item/>
    </div>
      </div>
  </div>
      </div>

    
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