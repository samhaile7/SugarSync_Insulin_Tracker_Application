<template>
  <div>
   
      
    <div class="deviceborder">
        


      <div class="devicescreen">
          <new-user-input></new-user-input>
       </div>

        <router-link id="insulin-info-link" v-bind:to="{name: 'insulindevice'}">Insulin Info</router-link>
        <router-link id="add-meal-link" v-bind:to="{name: 'insulinmealdevice'}" >Add Meal</router-link>
        <button class="fakebtn" id="fakebtn1"></button>
        <!-- <button class="fakebtn" id="fakebtn2"></button> -->
        
    </div>

  </div>
</template>

<script>
import NewUserInput from './NewUserInput.vue'

export default {
  components: {
      NewUserInput,
      
   },

}
    
</script>

<style>

.devicescreen {
  grid-area: devicescreen;
  background-color: white;
  border-color: black;
  border-radius: 75px;
  margin-bottom: 20px;
}

#insulin-info-link {
  grid-area: insulinbtn;
  display: inline-block;
  border-radius: 100px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  text-decoration: none;
}

#add-meal-link {
  grid-area: mealbtn;
  display: inline-block;
  border-radius: 100px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  text-decoration: none;
}



#fakebtn1 {
  display: grid;
  grid-area: fakebtn1;
  border-radius: 200px;
  height: 50px;
  width: 50px;
  justify-content: center;
  align-content: center;
 
}



.deviceborder {
  background-color: rgb(101, 155, 236);
    display: grid;
    border-radius: 100px;
    border: 2px solid #73AD21;
    margin-left: 33%;
    padding-top: 4%;
    padding-bottom: 4%;
    margin-top: 6%;
    margin-right: 33%;
    margin-bottom: 50px;
  /* padding: 20px;
  width: 100vh;
  height: 150px; */

  grid-template-columns: 1fr 2fr 2fr 2fr 1fr;
  grid-template-areas: 
    ". . . . ."
    ". devicescreen devicescreen devicescreen ."
    ". insulinbtn . mealbtn ."
    ". . fakebtn1 . ."
    
  ;
}







</style>


