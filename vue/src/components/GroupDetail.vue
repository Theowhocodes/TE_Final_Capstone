<template>
  <div>
      <h2> {{group.name}}</h2>
      <h2> Invitation Code: {{group.groupId}}</h2>
    </div>
</template>

<script>
import groupService from '../services/GroupService.js';
export default {
 data() {
    return {
    group: {
        
    }
        //groupId: '',
        //groupName: '',
        //invitationCode: '',
    
    };
  },

    created(){
    const groupId = this.$route.params.groupId; 
    
    groupService.getOneGroupById(groupId).then(response => {
      this.group = response; // overwrite empty group object with response from GET request
    })

  }

}
</script>

<style>

</style>