



<template>


  <div>
    <div id="chart_div"> </div>
    
    <p> Daily Blood Sugar AVG : {{bloodSugarAvgList[0]}} </p>
       <p> 3 Day : {{bloodSugarAvgList[1]}} </p>
       <p> 7 day  : {{bloodSugarAvgList[2]}} </p>
       <p> 2 week  : {{bloodSugarAvgList[3]}} </p>

       <p> Month : {{bloodSugarAvgList[4]}} </p>

       <p> Daily Dosage AVG : {{insulinDosageAvgList[0]}} </p>
       <p> 3 Day : {{insulinDosageAvgList[1]}} </p>
       <p> 7 day  : {{insulinDosageAvgList[2]}} </p>
       <p> 2 week  : {{insulinDosageAvgList[3]}} </p>

       <p> Month : {{insulinDosageAvgList[4]}} </p>


       <p> Target Minimum Blood Sugar: {{currentTargetMinFromServer}}</p> 
       <p> Target Maximum Blood Sugar: {{currentTargetMaxFromServer}} </p>


  </div>
</template>





<script>



import MealService from "../services/MealService.js";
import UserInputService from "../services/UserInputService.js";


export default {
    data() {
        return {
            bloodSugarAvgList: [],
            insulinDosageAvgList: [],
            allMealsFromServer: [],
            currentTargetMinFromServer: 0,
            currentTargetMaxFromServer: 0


        }
    },

    methods: {
        getInsulinDosageAverages() {
          MealService.getAllInsulinDosageAvg().then((response) => {
            if (response.status === 200) { 

                   this.insulinDosageAvgList = response.data;
            }
          }).catch((err) => console.log(err));
        },

        getBloodSugarAverages() {
          MealService.getAllBloodSugarAvg().then((response) => {
            if (response.status === 200) { 

                   this.bloodSugarAvgList = response.data;
            }
        }).catch((err) => console.log(err));
        }
        ,

        callAllMeals() {
            MealService.getAllMeals().then((response) => {
                 if (response.status === 200) { 

                   this.allMealsFromServer = response.data;
                }
            }).catch((err) => console.log(err));

        },
        getTargetRange() {
            UserInputService.getUserInputTest().then((response) => {
                if (response.status === 200) {
                    this.userInput = response.data;
                    this.currentTargetMinFromServer = response.data.targetRangeMin;
                    this.currentTargetMaxFromServer = response.data.targetRangeMax;
                }
            }).catch((err) => console.log(err));
        },

    
},
    created() {
      this.getInsulinDosageAverages();
      this.getBloodSugarAverages();
      this.callAllMeals();
      this.getTargetRange();
    }

}

</script>

<style>

</style>