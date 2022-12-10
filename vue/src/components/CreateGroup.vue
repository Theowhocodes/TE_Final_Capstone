<template>
  <div>
      <div class="create-group">
        <h3>Create a New Group</h3>
        <p> Enter a group name below to create a new shopping group:</p>

        <form class="group-form">
         <label for="groupName">Group Name:</label>
        <input type="text" placeholder="Group Name" name="groupName" maxlength="180" id="groupName">
        <button type="button" name="create" id="create">Create Group</button>
        </form>
      </div>
  </div>
</template>

<script>
export default {
    name: "create-group"

}
</script>

<style>
.group-form{
    display: inline-block;
}


</style>