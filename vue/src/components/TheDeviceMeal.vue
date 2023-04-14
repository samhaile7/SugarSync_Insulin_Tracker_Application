<template>


  <div>
   
       <div id= "alert">
        <p class = "speech-yellow-bubble speech-yellow-bubble:after" v-if="this.$store.state.displayLowWarningMessage">Blood Sugar is Lower than Range</p>
       <p class = "speech-red-bubble speech-red-bubble:after" v-if="this.$store.state.displayLowAlertMessage">Blood Sugar is Critcially Low</p>
       <p class = "speech-yellow-bubble speech-yellow-bubble:after" v-if="this.$store.state.displayHighWarningMessage">Blood Sugar is Higher than Range</p>
       <p class = " speech-red-bubble speech-red-bubble:after" v-if="this.$store.state.displayHighAlertMessage">Blood Sugar is Critically High</p>
        <p class = " speech-green-bubble speech-green-bubble:after" v-if="this.$store.state.displayNormalMessage">Blood Sugar is Within Normal Range</p>
       
       </div>

    
    <div class="deviceborder">

      <div class="devicescreen">
          <meal-log/>
       </div>

        <router-link id="insulin-info-link" v-bind:to="{name: 'insulindevice'}">Insulin Info</router-link>
        <router-link id="add-meal-link" v-bind:to="{name: 'insulinmealdevice'}">Add Meal</router-link>
        <button class="fakebtn" id="fakebtn1"></button>
        <!-- <button class="fakebtn" id="fakebtn2"></button> -->
        
    </div>

  </div>
</template>

<script>
import MealLog from './MealLog.vue'


export default {
  components: {
      
      
  
    MealLog },

}
    
</script>

<style>

.devicescreen {
  grid-area: devicescreen;
  background-color: white;
  border-color: black;
  border-radius: 75px;
  height: 50vh;
  margin-bottom: 20px;
  box-shadow: black 10px 10px;
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
  margin-top: 25px;
  box-shadow: black 5px 5px;
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
  margin-top: 25px;
  box-shadow: black 5px 5px;
}


#fakebtn1 {
  display: grid;
  grid-area: fakebtn1;
  border-radius: 200px;
  height: 50px;
  width: 50px;
  justify-content: center;
  align-content: center;
  box-shadow: black 5px 5px;

 
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
    box-shadow: black 10px 10px;
    margin-bottom: 50px;
    width: 40%;
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

.speech-red-bubble {
	position: relative;
	background: #f20202;
	border-radius: .4em;
  display: inline;
}

.speech-red-bubble:after {
  margin-top: 50%;
  display: inline;
	content: '';
	position: absolute;
	right: 0;
	top: 50%;
	width: 0;
	height: 0;
	border: 71px solid transparent;
	border-left-color: #f20202;
	border-right: 0;
	border-bottom: 0;
	margin-top: -35.5px;
	margin-right: -71px;
}

.speech-yellow-bubble {
	position: relative;
	background: #ff9500;
	border-radius: .4em;
}

.speech-yellow-bubble:after {
	content: '';
	position: absolute;
	right: 0;
	top: 50%;
	width: 0;
	height: 0;
	border: 71px solid transparent;
	border-left-color: #ff9500;
	border-right: 0;
	border-bottom: 0;
	margin-top: -35.5px;
	margin-right: -71px;
}


.speech-green-bubble {
	position: relative;
	background: #086e0d;
	border-radius: .4em;
}

.speech-green-bubble:after {
	content: '';
	position: absolute;
	right: 0;
	top: 50%;
	width: 0;
	height: 0;
	border: 71px solid transparent;
	border-left-color: #086e0d;
	border-right: 0;
	border-bottom: 0;
	margin-top: -35.5px;
	margin-right: -71px;
}

#alert {
  display: flex;
  
}





</style>


