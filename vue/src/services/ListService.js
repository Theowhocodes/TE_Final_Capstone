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

}