<template>


  <div class = "parent-container">
   
       <div id= "alert">
        <p class = " speech-yellow-bubble speech-yellow-bubble:after" v-if="this.$store.state.displayLowWarningMessage">Blood Sugar is<br>Lower than Range   </p>
       <p class = "speech-red-bubble speech-red-bubble:after" v-if="this.$store.state.displayLowAlertMessage"          >Blood Sugar <br>is Critically Low &nbsp;&nbsp;&nbsp;&nbsp; </p>
       <p class ="speech-yellow-bubble speech-yellow-bubble:after" v-if="this.$store.state.displayHighWarningMessage"  >Blood Sugar is<br>Higher than Range  </p>
       <p class = " speech-red-bubble speech-red-bubble:after" v-if="this.$store.state.displayHighAlertMessage"        >Blood Sugar <br>is Critically High &nbsp;&nbsp;&nbsp;&nbsp;   </p>
        <p class = "  speech-green-bubble speech-green-bubble:after" v-if="this.$store.state.displayNormalMessage"     >Blood Sugar is<br>Within Normal Range</p>
       <img id="happy-cube" src="https://res.cloudinary.com/dzw4n2mgp/image/upload/v1681671882/capstone_assets/meditatingcube_mkklnw.png" alt=""
       v-if="this.$store.state.displayNormalMessage">
       <img id="question-cube" src="https://res.cloudinary.com/dzw4n2mgp/image/upload/v1681671882/capstone_assets/questioncube_k69nia.png" alt=""
       v-if="this.$store.state.displayHighWarningMessage">
      <img id="mad-cube" src="https://res.cloudinary.com/dzw4n2mgp/image/upload/v1681671882/capstone_assets/madcube_ocflbf.png" alt=""
      v-if="this.$store.state.displayHighAlertMessage">
      <img id="question-cube" src="https://res.cloudinary.com/dzw4n2mgp/image/upload/v1681671882/capstone_assets/questioncube_k69nia.png" alt=""
       v-if="this.$store.state.displayLowWarningMessage">
      <img id="mad-cube" src="https://res.cloudinary.com/dzw4n2mgp/image/upload/v1681671882/capstone_assets/madcube_ocflbf.png" alt=""
      v-if="this.$store.state.displayLowAlertMessage">

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
  font-family: 'Poppins', sans-serif;
  font-weight:bold;
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
  box-shadow: black 5px 5px;

 
}



.deviceborder {
  background-color: rgb(101, 155, 236);
    display: grid;
    border-radius: 100px;
    border: 2px solid #73AD21;
    margin-left: auto;
    margin-right: auto;
    padding-top: 2%;
    padding-bottom: 2%;
    margin-top: 3%;
    box-shadow: black 10px 10px;
    margin-bottom: 50px;
    width: 40%;

  grid-template-columns: 1fr 2fr 2fr 2fr 1fr;
  grid-template-areas: 
    ". . . . ."
    ". devicescreen devicescreen devicescreen ."
    ". insulinbtn . mealbtn ."
    ". . fakebtn1 . ."
    
  ;
  
}


.speech-red-bubble {
	position: absolute;
	background: #f20202;
	border-radius: .4em;
       padding: 5vh;
        text-align: left;
  color: white;
  font-weight: bold;
  font-size: 1.5em;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
   margin-left: 5%;
   margin-top: 5%;
   box-shadow: 10px 10px 5px gray;
   z-index: -1;
}

.speech-red-bubble:after {
content: '';
	position: absolute;
	right: 0;
	top: 50%;
	width: 0;
	height: 0;
	border: 47px solid transparent;
	border-left-color: #f20202;
	border-right: 0;
	border-bottom: 0;
	margin-top: -23.5px;
	margin-right: -47px;
  z-index: -1;
}

.speech-yellow-bubble {
	position: absolute;
	background: #ff9500;
	border-radius: .4em;
       padding: 5vh;
        text-align: left;
  color: white;
  font-weight: bold;
  font-size: 1.5em;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
   margin-left: 5%;
   margin-top: 5%;
   box-shadow: 10px 10px 5px gray;
   z-index: -1;
  
}

.speech-yellow-bubble:after {
content: '';
	position: absolute;
	right: 0;
	top: 50%;
	width: 0;
	height: 0;
	border: 47px solid transparent;
	border-left-color: #ff9500;
	border-right: 0;
	border-bottom: 0;
	margin-top: -23.5px;
	margin-right: -47px;
  z-index: -1;

}


.speech-green-bubble {
	position: absolute;
	background: #086e0d;
	border-radius: .4em;
  padding: 5vh;
  text-align: left;
  color: black;
  font-weight: bold;
  font-size: 1.5em;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  margin-left: 5%;
  margin-top: 5%;
  box-shadow: 10px 10px 5px gray;
  color: white;
  z-index: -1;
}

.speech-green-bubble:after {
content: '';
	position: absolute;
	right: 0;
	top: 50%;
	width: 0;
	height: 0;
	border: 47px solid transparent;
	border-left-color: #086e0d;
	border-right: 0;
	border-bottom: 0;
	margin-top: -23.5px;
	margin-right: -47px;
  z-index: -1;
}

#alert {
  display: flex;
  justify-content: flex-start;
  
}

#happy-cube {
  position: absolute;
  width: 90px;
  
  margin-left: 280px;
  margin-top: 75px
}

#question-cube {
  position: absolute;
  width: 75px;
  
  margin-left: 268px;
  margin-top: 77px
}

#mad-cube {
  position: absolute;
  width: 90px;
  
  margin-left: 255px;
  margin-top: 75px
}




</style>


