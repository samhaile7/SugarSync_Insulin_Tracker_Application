import axios from "axios";

export default{

    getLogByLogId(logId) {
        return axios.get(`/log/${logId}`)
    },

    getAllLogsByUserId() {
        return axios.get(`/alllogs`)
    },

}
