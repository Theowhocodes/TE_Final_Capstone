<template>

<create-list/>
<group-detail/>
<leave-group/>

</template>



<script>
import CreateList from '../components/CreateList.vue';
import GroupDetail from '../components/GroupDetail.vue';
import LeaveGroup from '../components/LeaveGroup.vue';


export default {
  components: {
    GroupDetail,
    LeaveGroup,
    CreateList
    
    
  }
}
</script>

<style>
.tile{
  background-color: transparent;
  
  
}

</style>
