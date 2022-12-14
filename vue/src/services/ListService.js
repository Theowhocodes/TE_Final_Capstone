import axios from 'axios';

export default {

    getListByListId(listId) {
        return axios.get(`/groups/lists/list/${listId}`)
    },

    claimList(listId) {
        return axios.put(`/groups/lists/${listId}/claim`)
    },

    unclaimList(listId){
        return axios.put(`/groups/lists/${listId}/unclaim`)
    },

    getAllItemsInList(listId) {
        return axios.get(`/items/list/${listId}`)
    },

    createShoppingList(shoppingList){
        return axios.post(`/groups/lists/create`, shoppingList)
    },

    clearAllItemsFromList(listId){
        return axios.delete(`/groups/lists/list/${listId}/clear`)
    },

    deleteList(listId){
        return axios.delete(`/groups/lists/list/${listId}/delete`)
    }

}