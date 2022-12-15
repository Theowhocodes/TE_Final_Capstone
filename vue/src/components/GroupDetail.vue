<template>
  <div
    class="groupDetail">

    <div class="block">    
        <p id="tileText"><strong>{{ group.groupName }} </strong>| <strong>Invitation Code: </strong>{{ group.invitationCode }}</p>
    </div>

    <div class="block">
    <p id="tileText">All the lists belonging to this group are below:</p></div>
    <br />
    <table id="tileText" class="table is-hoverable">
        <tr>
          <th>List Name</th>
          
          <th>Total Items on List</th>
          
          <th>List Status</th>
          
        </tr>

      <tbody>
        <tr
          class="groupList"
          v-for="list in lists"
          v-bind:key="list.groupId"
          v-bind:list="list"
        >
          <td>
            <router-link id="tileLink"
              v-bind:to="{ name: 'list', params: { listId: list.listId } }"
            >
              {{ list.listName }}
            </router-link>
          </td>
          <td>{{ list.count }}</td>
          <td>{{ list.claimed ? "Claimed" : "Unclaimed" }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import groupService from "../services/GroupService.js";

export default {
  name: "group-detail",

  data() {
    return {
      lists: [],
      list: {},

      group: {},
    };
  },

  created() {
    const groupId = this.$route.params.groupId;

    groupService.getAllListsByGroupId(groupId).then((response) => {
      console.log(response);
      this.lists = response.data;
    });

    groupService.getOneGroupById(groupId).then((response) => {
      this.group = response.data;
    });
  },
};
</script>

<style>


</style>
