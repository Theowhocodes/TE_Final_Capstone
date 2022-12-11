<<<<<<< HEAD
import axios from "axios";

export default {

    getAllListsByGroupId(groupId) {
        return axios.get(`/groups/lists/${groupId}`)
              
      }
    
=======
import axios from 'axios';

export default {

    getListByListId(listId) {
        return axios.get(`/groups/lists/list/${listId}`)
    },

    claimList(listId) {
        return axios.put(`/groups/lists/${listId}/claim`)
    },
    getAllItemsInList(listId) {
        return axios.get(`items/list/${listId}`)
    }

// getAllItemsInListById(listId) {
//     return axios.get(`/groups/lists/list/${listId}`)
// }

>>>>>>> 489e82f5c6f05b6feee348b70a9680f5bf99d00b
}