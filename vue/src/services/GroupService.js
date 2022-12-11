import axios from 'axios';

export default {

getAllShoppingGroupsByUser(userId) {
    return axios.get(`/groups/users/${userId}`)
    //return axios.get(`/${userId}`, userId)
},

getOneGroupById(groupId){
return axios.get(`/groups/${groupId}`)
},

getAllListsByGroupId(groupId) {
    return axios.get(`/groups/lists/${groupId}`)

},

//create group, pass in group name 

createShoppingGroup(shoppingGroup) {
    return axios.post(`/groups/create`, shoppingGroup);
},

// leave group

<<<<<<< HEAD

}

=======
leaveShoppingGroup(groupId){
    return axios.delete(`/groups/${groupId}/leave`);
},

// join group

joinShoppingGroup(groupId, username){
    return axios.post(`/groups/${groupId}/join` + groupId, username)
  },

}
>>>>>>> 489e82f5c6f05b6feee348b70a9680f5bf99d00b
