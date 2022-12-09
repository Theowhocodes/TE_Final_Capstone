<template>
  <div>
      <h2> {{list.listName}}</h2>
      
    </div>
</template>

<script>
import groupService from '../services/GroupService.js';
export default {
 data() {
    return {
    name: "group-detail",
    list: ''
        
    };
  },

    created(){
    const groupId = this.$route.params.groupId; 
    
    groupService.getAllListsByGroupId(groupId).then(response => {
      this.list = response; // overwrite empty group object with response from GET request
        
    })

  }

}
</script>

<style>

</style>