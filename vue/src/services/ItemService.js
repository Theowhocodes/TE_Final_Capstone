<<<<<<< HEAD
import axios from "axios";

export default {
    getAllItemsByListId(listId) {
        return axios.get(`/groups/lists/items/${listId}`)
    }
    
    
=======
import axios from 'axios';

export default {

    createNewItem(item) {
        return axios.post('/items/create', item)
    },
    deleteItem(itemId) {
        return axios.delete(`/items/${itemId}/delete`, itemId)
    },
    modifyItem(itemId, item) {
        return axios.put(`/items/${itemId}/modify`, item)
    }

>>>>>>> 489e82f5c6f05b6feee348b70a9680f5bf99d00b
}