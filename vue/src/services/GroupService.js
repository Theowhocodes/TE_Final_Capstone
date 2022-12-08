import axios from 'axios';


export default {

getAllShoppingGroupsByUser(userId) {
    return axios.get(`/groups/users/${userId}`)
    //return axios.get(`/${userId}`, userId)
},

getOneGroupById(groupId){
return axios.get(`/groups/${groupId}`)
}




}