import axios from 'axios';

export default {

//get list of all groups by userId
getAllShoppingGroupsByUser(userId) {
    return axios.get(`/groups/users/${userId}`)
    //return axios.get(`/${userId}`, userId)
},

//get details for one group by groupId
getOneGroupById(groupId){
return axios.get(`/groups/${groupId}`)
},

//get details for one group by invitationCode
getGroupByInvitationCode(invitationCode){
    return axios.get(`/groups/invitation/${invitationCode}`)
},

//get all lists belonging to one group
getAllListsByGroupId(groupId) {
    return axios.get(`/groups/lists/${groupId}`)

},

//create group, pass in group name & invitation code

createShoppingGroup(shoppingGroup) {
    return axios.post(`/groups/create`, shoppingGroup);
},

// leave group

leaveShoppingGroup(groupId){
    return axios.delete(`/groups/${groupId}/leave`);
},

// join group

joinShoppingGroup(groupId, groupToJoin){
    return axios.post(`/groups/${groupId}/join`, groupToJoin)
  },

// get all users in a group by groupId
getAllUsersByGroupId(groupId){
    return axios.get(`/groups/${groupId}/users`)
}

}
