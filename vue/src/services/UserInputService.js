import axios from "axios";

export default{

addUserInput(userInput) {
    return axios.post('/userinput', userInput)
},

getUserInput(id) {
    return axios.get(`/userinput/${id}`)
},

getUserInputTest() {
    return axios.get(`/userinput`)
},

updateUserInput(userInput) {
    return axios.put('/edit-profile', userInput)
},

addMeal(meal) {
    return axios.post('/meal', meal)
}



}