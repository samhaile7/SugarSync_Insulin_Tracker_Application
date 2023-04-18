<template>
  <div>

    <table id="avg-table" class="center">
      <tr>
        <th id="avg-header" colspan="6">Blood Sugar & Dosage Averages</th>
      </tr>
      <tr>
        <th id="avg-row"></th>
        <th id="avg-row" class="timeranges">Daily</th>
        <th id="avg-row" class="timeranges">3-Day</th>
        <th id="avg-row" class="timeranges">7-Day</th>
        <th id="avg-row" class="timeranges">2-Week</th>
        <th id="avg-row" class="timeranges">Monthly</th>
      </tr>
      <tr>
        <th id="avg-row" class="bloodsugar">Blood Sugar</th>
        <td id="avg-row">{{ bloodSugarAvgList[0].toFixed(2) }}</td>
        <td id="avg-row">{{ bloodSugarAvgList[1].toFixed(2) }}</td>
        <td id="avg-row">{{ bloodSugarAvgList[2].toFixed(2) }}</td>
        <td id="avg-row">{{ bloodSugarAvgList[3].toFixed(2) }}</td>
        <td id="avg-row">{{ bloodSugarAvgList[4].toFixed(2) }}</td>
      </tr>
      <tr>
        <th id="avg-row" class="dosage">Dosage</th>
        <td id="avg-row"> {{ insulinDosageAvgList[0].toFixed(2) }}</td>
        <td id="avg-row">{{ insulinDosageAvgList[1].toFixed(2) }}</td>
        <td id="avg-row">{{ insulinDosageAvgList[2].toFixed(2) }}</td>
        <td id="avg-row">{{insulinDosageAvgList[3].toFixed(2) }}</td>
        <td id="avg-row">{{ insulinDosageAvgList[4].toFixed(2) }}</td>
      </tr>
    </table>

    <LineChart v-bind:allMealsFromServer="allMealsFromServer" v-bind:currentTargetMinFromServer = "currentTargetMinFromServer"  />
    <pie-chart />


    <p>Target Minimum Blood Sugar: {{ currentTargetMinFromServer }}</p>
    <p>Target Maximum Blood Sugar: {{ currentTargetMaxFromServer }}</p>

    <table id="log-table">
      <thead>
        <tr><th id="log-header" colspan="3">Activity Log</th></tr>
        <tr>
          <th id="column-title">Log Id</th>
          <th id="column-title">Log Type</th>
          <th id="column-title">Date/Time Logged</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(log, index) in userLogs" v-bind:key="index">
          <td id="row-data" class="log-id">{{ userLogs[index].logId }}</td>
          <td id="row-data">{{ logTypeStrings[userLogs[index].logTypeId - 1] }}</td>
          <td id="row-data">{{ userLogs[index].dateTimeLogged }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import MealService from "../services/MealService.js";
import UserInputService from "../services/UserInputService.js";
import LogService from "../services/LogService.js";
import LineChart from "../components/LineChart.vue";
import PieChart from "../components/PieChart.vue";

export default {
  components: { LineChart, PieChart }, 
  data() {
    return {
      bloodSugarAvgList: [],
      insulinDosageAvgList: [],
      allMealsFromServer: [],
      currentTargetMinFromServer: 0,
      currentTargetMaxFromServer: 0,
      userLogs: [],
      logTypeStrings: [
        "Added/Updated Profile",
        "Added Meal",
        "Blood Sugar Low",
        "Blood Sugar High",
        "Blood Sugar Critically Low",
        "Blood Sugar Critically High",
      ],
    };
  },

  methods: {
    getInsulinDosageAverages() {
      MealService.getAllInsulinDosageAvg()
        .then((response) => {
          if (response.status === 200) {
            this.insulinDosageAvgList = response.data;
          }
        })
        .catch((err) => console.log(err));
    },

    getBloodSugarAverages() {
      MealService.getAllBloodSugarAvg()
        .then((response) => {
          if (response.status === 200) {
            this.bloodSugarAvgList = response.data;
          }
        })
        .catch((err) => console.log(err));
    },
    callAllMeals() {
      MealService.getAllMeals()
        .then((response) => {
          if (response.status === 200) {
            this.allMealsFromServer = response.data;
          }
        })
        .catch((err) => console.log(err));
    },
    getTargetRange() {
      UserInputService.getUserInputTest()
        .then((response) => {
          if (response.status === 200) {
            this.userInput = response.data;
            this.currentTargetMinFromServer = response.data.targetRangeMin;
            this.currentTargetMaxFromServer = response.data.targetRangeMax;
          }
        })
        .catch((err) => console.log(err));
    },
    getAllLogs() {
      LogService.getAllLogsByUserId()
        .then((response) => {
          if (response.status === 200) {
            this.userLogs = response.data;
          }
        })
        .catch((err) => console.log(err));
    },
  },
  created() {
    this.getInsulinDosageAverages();
    this.getBloodSugarAverages();
    this.callAllMeals();
    this.getTargetRange();
    this.getAllLogs();
  },
};
</script>

<style>

#avg-table {
  width: 95%;
  margin-left: auto;
  margin-right: auto;
  border-collapse: separate;
  border-radius: 20px;
  border-spacing: 0;
  
  border: 1px solid black;
  overflow: hidden;
  margin-bottom: 5%;

}

th:not(:last-child), td:not(:last-child) {
  border-right: 1px solid black;
  
}
#avg-table>thead>tr:not(:last-child)>th,
#avg-table>thead>tr:not(:last-child)>td,
#avg-table>tbody>tr:not(:last-child)>th,
#avg-table>tbody>tr:not(:last-child)>td,
#avg-table>tfoot>tr:not(:last-child)>th,
#avg-table>tfoot>tr:not(:last-child)>td,
#avg-table>tr:not(:last-child)>td,
#avg-table>tr:not(:last-child)>th,
#avg-table>thead:not(:last-child),
#avg-table>tbody:not(:last-child),
#avg-table>tfoot:not(:last-child) {
 border-bottom: 1px solid black;
}

 #avg-header {

  background: #1874D2;
  color: white;
  text-align: center;
  font-size: 1.5em;
  font-family: 'Lora', serif;
  font-weight: bold;
  
  
} 
.dosage, .bloodsugar {
  text-align: center;
  font-size: 1.25em;

}

.timeranges {
  text-align: center;
  font-size: 1.25em;
}

#avg-row {
  text-align: center;
  font-family: 'Poppins', sans-serif;
  font-weight: bold;
}

#log-header {
  background: #1874D2;
  color: white;
  text-align: center;
  font-size: 1.5em;
  font-family: 'Lora', serif;
  font-weight: bold;
}

#log-table {
  width: 95%;
  margin-left: auto;
  margin-right: auto;
  border-collapse: separate;
  border-radius: 20px;
  border-spacing: 0;
  
  border: 1px solid black;
  overflow: hidden;
  margin-bottom: 5%;

}
#log-table>thead>tr:not(:last-child)>th,
#log-table>thead>tr:not(:last-child)>td,
#log-table>tbody>tr:not(:last-child)>th,
#log-table>tbody>tr:not(:last-child)>td,
#log-table>tfoot>tr:not(:last-child)>th,
#log-table>tfoot>tr:not(:last-child)>td,
#log-table>tr:not(:last-child)>td,
#log-table>tr:not(:last-child)>th,
#log-table>thead:not(:last-child),
#log-table>tbody:not(:last-child),
#log-table>tfoot:not(:last-child) {
 border-bottom: 1px solid black;
}

#column-title {
  border-bottom: 1px solid black;
  font-family: 'Poppins', sans-serif;
  font-weight: bold;
  font-size: 1.25em;
  text-align: center;
}
#row-data {
  font-family: 'Poppins', sans-serif;
  font-weight: bold;
  padding-left: 10px;
}
.log-id {
  text-align: center;
}



</style>
