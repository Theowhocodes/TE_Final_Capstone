<template>
  <div
    class="
      has-mw-md has-mw-xl-widescreen
      mx-auto
      py-12
      px-8-mobile px-14-tablet
      has-background-white
    "
  >
    <h3>{{ group.groupName }} | Invitation Code: {{ group.invitationCode }}</h3>

    <h4>Your Lists</h4>
    <br />
    <table>
      <thead>
        <tr>
          <th>List Name</th>
          
          <th>Total Items on List</th>
          
          <th>List Status</th>
          
        </tr>
      </thead>
      <br />

      <tbody>
        <tr
          class="groupList"
          v-for="list in lists"
          v-bind:key="list.groupId"
          v-bind:list="list"
        >
          <td>
            <router-link
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
