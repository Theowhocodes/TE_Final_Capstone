import axios from "axios";

export default {

    getAllListsByGroupId(groupId) {
        return axios.get(`/groups/lists/${groupId}`)
              
      }
    
}