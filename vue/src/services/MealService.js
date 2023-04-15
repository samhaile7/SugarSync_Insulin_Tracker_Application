import axios from "axios";

export default{

    getAllMeals() {
        return axios.get(`/meal/allmeals`)
    }








}