import axios from 'axios';

export default {

getAllShoppingGroupsByUser(userId) {
    return axios.get(`/${userId}`, userId)
}


}