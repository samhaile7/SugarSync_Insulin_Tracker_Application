<template>
  <div>
   
      
    <div class="deviceborder">
        


      <div class="devicescreen">
          <new-user-input></new-user-input>
       </div>

        <button id="insulinbtn">Insulin Info</button>
        <button id="mealbtn">Add Meal</button>
        <button class="fakebtn"></button>
        <button class="fakebtn"></button>
        <button class="fakebtn"></button>

        


        
      



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
  border-radius: 25px;
}

#insulinbtn {
  grid-area: insulinbtn;
}

#mealbtn {
  grid-area: mealbtn;
}

.fakebtn {
  grid-area: fakebtn;
}

.deviceborder {
  background-color: rgb(101, 155, 236);
    display: grid;
    border-radius: 100px;
    border: 2px solid #73AD21;
    margin-left: 25%;
    padding-top: 4%;
    padding-bottom: 4%;
    margin-top: 6%;
    margin-right: 25%;
  /* padding: 20px;
  width: 100vh;
  height: 150px; */

  grid-template-columns: 1fr 2fr 2fr 1fr;
  grid-template-areas: 
    ". .  . ."
    ". devicescreen devicescreen ."
    ". insulinbtn mealbtn ."
    

  
  
  ;
}





</style>


