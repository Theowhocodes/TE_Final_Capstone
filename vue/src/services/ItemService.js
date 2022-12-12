import axios from 'axios';

export default {

    createNewItem(item) {
        return axios.post(`/items/create`, item)
    },
    deleteItem(itemId) {
        return axios.delete(`/items/${itemId}/delete`)
    },
    modifyItem(itemId) {
        return axios.put(`/items/${itemId}/modify`)
    }

}