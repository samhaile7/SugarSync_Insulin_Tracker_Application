<template>
  <div id="background">
   
      
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

/* #background {
  background-image: url("https://res.cloudinary.com/dzw4n2mgp/image/upload/v1681841908/capstone_assets/devicebg_1_r5uirl.png");
  background-size: cover;
  background-repeat: no-repeat;
} */

.devicescreen {
  grid-area: devicescreen;
  background-color: white;
  border-color: black;
  border-radius: 75px;
  height: 500px;
  margin-bottom: 20px;
}

#insulin-info-link {
  grid-area: insulinbtn;
  display: inline-block;
  border-radius: 100px;
  background-color: #FD6600;
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
  font-family: 'Poppins', sans-serif;
  font-weight:bold;
}

#add-meal-link {
  grid-area: mealbtn;
  display: inline-block;
  border-radius: 100px;
  background-color: #FD6600;
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
  font-family: 'Poppins', sans-serif;
  font-weight:bold;
}



#fakebtn1 {
  display: grid;
  grid-area: fakebtn1;
  border-radius: 200px;
  height: 50px;
  width: 50px;
  justify-content: center;
  align-content: center;
  margin-left: 35%
 
}



.deviceborder {
  background-color: #8aaffe;
    display: grid;
    border-radius: 100px;
    border: 2px solid #FECC98;
    padding-top: 2%;
    padding-bottom: 2%;
    margin-top: 3%;
    margin-bottom: 50px;
    margin-left: auto;
    margin-right: auto;


  grid-template-columns: 1fr 2fr 2fr 2fr 1fr;
  grid-template-areas: 
    ". . . . ."
    ". devicescreen devicescreen devicescreen ."
    ". insulinbtn . mealbtn ."
    ". . fakebtn1 . ."
    
    
  ;
}







</style>


