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
    },

    createShoppingList(shoppingList){
        return axios.post(`/groups/lists/create`, shoppingList)
    }

// getAllItemsInListById(listId) {
//     return axios.get(`/groups/lists/list/${listId}`)
// }

}