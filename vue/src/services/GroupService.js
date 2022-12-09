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
<<<<<<< HEAD
=======

}
>>>>>>> 8f884ce7c0a5d954495fecd4dce5d6e54fddba82

}

}
