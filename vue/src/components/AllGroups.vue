<template>
  <div class="has-text-link has-text-weight-bold">
    <h3 class="has-text-link has-text-weight-bold">
      Pick a group and start making lists!
    </h3>
    <br />
    <table>
      <thead>
        <tr>
          <th>Group Name</th>
          <th>Member Since</th>
          <th>Code</th>
        </tr>
      </thead>
      <tbody>
        <tr
          class="groupList"
          v-for="group in groups"
          v-bind:key="group.groupId"
          v-bind:group="shoppingGroup"
        >
          <td>
            <router-link
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
