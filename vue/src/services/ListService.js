import axios from 'axios';

export default {

    getListByListId(listId) {
        return axios.get(`/groups/lists/list/${listId}`)
    },

    claimList(listId) {
        return axios.put(`/groups/lists/${listId}/claim`)
    },
    getAllItemsInList() {

    }

// getAllItemsInListById(listId) {
//     return axios.get(`/groups/lists/list/${listId}`)
// }

}