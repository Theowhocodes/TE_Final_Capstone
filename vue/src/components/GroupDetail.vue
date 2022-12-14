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
/*
#groupDetails{
 margin: auto;
 overflow: auto;
 width: 300px; 
 height: 300px;
 background: yellow;
 background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#EBEB00), to(#C5C500));
 background: -moz-linear-gradient(100% 100% 90deg, #C5C500, #EBEB00);
 padding: 20px 20px 20px 20px;
 -webkit-box-shadow: 0px 10px 30px #000;
 -moz-box-shadow: 0px 10px 30px #000
} */
</style>
