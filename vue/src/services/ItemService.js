import axios from 'axios';

export default {

    getItem(itemId) {
        return axios.get(`/items/${itemId}`)
    },
    createNewItem(item) {
        return axios.post(`/items/create`, item)
    },
    deleteItem(itemId) {
        return axios.delete(`/items/${itemId}/delete`)
    },
    modifyItem(itemId, item) {
        return axios.put(`/items/${itemId}/modify`, item)
    }

}