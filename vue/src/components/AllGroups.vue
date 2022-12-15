<template>
  <div>
    <h3 id="tileText">
      Pick a group and start making lists!
    </h3>
    <br />
    <table id="tileText" class="table">
        <tr>
          <th>Group Name</th>
          <th>Member Since</th>
          <th>Invitation Code</th>
        </tr>
      <tbody>
        <tr
          class="groupList"
          v-for="group in groups"
          v-bind:key="group.groupId"
          v-bind:group="shoppingGroup"
        >
          <td>
            <router-link id="tileLink"
              v-bind:to="{ name: 'group', params: { groupId: group.groupId } }"
            >
              {{ group.groupName }}
            </router-link>
          </td>
          <td>{{ group.memberSince }}</td>
          <td>{{ group.invitationCode }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>

import groupService from "../services/GroupService.js";

export default {
  data() {
    return {
      groups: [],
      group: {},
    };
  },

  created() {
    groupService.getAllShoppingGroupsByUser().then((response) => {
      this.groups = response.data;
    });
  },
};
</script>

<style>



</style>
