import axios from "axios";

export default {
    getAllItemsByListId(listId) {
        return axios.get(`/groups/lists/items/${listId}`)
    }
    
    
}