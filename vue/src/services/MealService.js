import axios from "axios";

export default{

    getAllMeals() {
        return axios.get(`/meal/allmeals`)
    },

    getAllBloodSugarAvg() {
        return axios.get(`/bloodsugarhistory`)
    },

    getAllInsulinDosageAvg() {
        return axios.get(`/insulindosagehistory`)
    }










}