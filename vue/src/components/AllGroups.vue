<template>
  <div>
    <p id="tileText">
      Pick a group and start making lists!
    </p>
    <br />
    <table id="tileText" class="table is-hoverable">
      <tbody>
        <div
          class="groupList post-it"
          v-for="group in groups"
          v-bind:key="group.groupId"
          v-bind:group="shoppingGroup"
        >
          <td>
            <router-link id="tileLink"
              v-bind:to="{ name: 'group', params: { groupId: group.groupId } }"
            >
            <td class="marker">Group Name: {{ group.groupName }} </td>
            </router-link>
          </td>
          <td>Join Date: {{ group.memberSince }}</td>
          <td>Invite Code: {{ group.invitationCode }}</td>
        </div>
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

@import url(https://fonts.googleapis.com/css?family=Permanent+Marker);
.marker{
  font-family: 'Permanent Marker', cursive;
  line-height:1.7em;
  font-size:15px;
  color:#130d6b;


}

.post-it {
  width:50%;
  height:60%;
  position:relative;
  background:rgb(255, 255, 170);
  overflow:hidden;
  margin:30px auto;
  padding:20px;
  border-radius:0 0 0 30px/45px;
  box-shadow:
    inset 0 -40px 40px rgba(0,0,0,0.2),
    inset 0 25px 10px rgba(0,0,0,0.2),
    0 5px 6px 5px rgba(0,0,0,0.2);
  font-family: 'Permanent Marker', cursive;
  text-align:left;
  line-height:1.7em;
  font-size:15px;
  -webkit-mask-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAA5JREFUeNpiYGBgAAgwAAAEAAGbA+oJAAAAAElFTkSuQmCC);

  color:#130d6b;
}

.post-it li {
  cursor:pointer; 
}


</style>
