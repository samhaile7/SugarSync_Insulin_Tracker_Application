<template>
  <div>
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


  </div>
</template>

<script>

import MealService from "../services/MealService.js";

export default {
    data() {
        return {
            bloodSugarAvgList: [],
            insulinDosageAvgList: []
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
},
    created() {
      this.getInsulinDosageAverages();
      this.getBloodSugarAverages();
    }

}
</script>

<style>

</style>