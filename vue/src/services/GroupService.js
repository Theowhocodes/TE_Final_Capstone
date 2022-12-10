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

//add method to create group, pass in group name 

createShoppingGroup(shoppingGroup) {
    return axios.post(`/groups/create`, shoppingGroup);
}

}
