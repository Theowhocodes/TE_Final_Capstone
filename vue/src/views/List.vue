<template>
<section class="is-relative section">
  <div>
      <list-detail/>
        <br>
        <br>
      <create-item/>
    </div>
     
</section>
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

