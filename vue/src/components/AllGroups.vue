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
#all-groups {
  margin: auto;
  width: 300px;
  background: yellow;
  background: -webkit-gradient(
    linear,
    0% 0%,
    0% 100%,
    from(#ebeb00),
    to(#c5c500)
  );
  background: -moz-linear-gradient(100% 100% 90deg, #c5c500, #ebeb00);
  padding: 20px 20px 20px 20px;
  -webkit-box-shadow: 0px 10px 30px #000;
  -moz-box-shadow: 0px 10px 30px #000;
}
</style>
