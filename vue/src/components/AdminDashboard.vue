<template>
  <div>
    
    <!-- <h1 id="dash-head">Welcome to your SugarSync dashboard! </h1> -->
    <div id="dash-grid">
    <!-- <table id="avg-table" class="center">
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
        <td id="avg-row">{{ insulinDosageAvgList[0].toFixed(2) }}</td>
        <td id="avg-row">{{ insulinDosageAvgList[1].toFixed(2) }}</td>
        <td id="avg-row">{{ insulinDosageAvgList[2].toFixed(2) }}</td>
        <td id="avg-row">{{ insulinDosageAvgList[3].toFixed(2) }}</td>
        <td id="avg-row">{{ insulinDosageAvgList[4].toFixed(2) }}</td>
      </tr>
    </table> -->
    <!-- <LineChart v-bind:allMealsFromServer="allMealsFromServer" /> -->

    <!-- <p>Daily Blood Sugar AVG : {{ bloodSugarAvgList[0] }}</p>
    <p>3 Day : {{ bloodSugarAvgList[1] }}</p>
    <p>7 day : {{ bloodSugarAvgList[2] }}</p>
    <p>2 week : {{ bloodSugarAvgList[3] }}</p> -->

    <div class="chart-grid">
      <!-- <LineChart
        class="line-chart"
        v-if="isDataLoaded"
        v-bind:arrayToPass="arrayToPass"
      /> -->
      <!-- <LineChart class="line-chart" v-if="isDataLoaded" v-bind:arrayToPass="arrayToPass" v-bind:allMealsFromServer="allMealsFromServer" v-bind:currentTargetMinFromServer = "currentTargetMinFromServer"  /> -->

      <!-- <div class="targets"> 
        <h3 id="targets-header">Blood Sugar Targets</h3>
        <p id="min-num">
           {{ currentTargetMinFromServer }}
        </p>
        <p id="units1">(mmol/L)</p>
        <p id="min-text">Minimum</p>
        
        <p id="max-num">
           {{ currentTargetMaxFromServer }}
        </p>
        <p id="units2">(mmol/L)</p>
        <p id="max-text">Maximum</p>
      </div>
      <PieChart
        v-if="isUserLogsLoaded"
        v-bind:userLogs="userLogs"
        class="pie-chart"
      /> -->
    </div>

    <table id="log-table">
      <thead>
        <tr>
          <th id="log-header" colspan="3">Activity Log</th>
        </tr>
        <tr>
          <th id="column-title">User Id</th>
          <th id="column-title">Log Type</th>
          <th id="column-title">Date/Time Logged</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(log, index) in userLogs" v-bind:key="index">
          <td id="row-data" class="log-id">{{ userLogs[index].userId }}</td>
          <td id="row-data">
            {{ logTypeStrings[userLogs[index].logTypeId - 1] }}
          </td>
          <td id="row-data">
            {{ new Date(userLogs[index].dateTimeLogged).toLocaleString() }}
          </td>
        </tr>
      </tbody>
    </table>
    </div>
  </div>
</template>

<script>
import MealService from "../services/MealService.js";
import UserInputService from "../services/UserInputService.js";
import LogService from "../services/LogService.js";
// import LineChart from "../components/LineChart.vue";
// import PieChart from "../components/PieChart.vue";

export default {
  components: { 
    // LineChart, 
    // PieChart 
    },
  computed: {
    arrayToPass() {
      return [
        this.allMealsFromServer,
        this.currentTargetMinFromServer,
        this.currentTargetMaxFromServer,
      ];
    },
    isDataLoaded() {
      if (this.allMealsFromServer.length > 0 && this.currentTargetMinFromServer !== 0 && this.currentTargetMaxFromServer !== 0) {
        return true;
      } else {
        return false;
      }
    },
    isUserLogsLoaded() {
      if (this.userLogs.length > 0) {
        return true;
      } else {
        return false;
      }
    },
  },

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
      LogService.getEveryLog()
        .then((response) => {
          if (response.status === 200) {
            this.userLogs = response.data;
          }
        })
        .catch((err) => console.log(err));
    },
    formatDate() {},
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

#dash-grid {
  background-color: #fecc98;
}


.targets {
  display: grid;
  grid-area: targets;
  border-style: 1px solid black;
  border-radius: 10px;
  background-color: #ff4041;
  grid-template-columns: 2fr 1fr 2fr 1fr;
  grid-template-areas: 
  "targets-header targets-header targets-header targets-header"
  "min-num units1 max-num units2"
  "min-text . max-text . ";
  margin: auto;
  width: 90%;
  color: white;
  text-shadow: #040084 1px 1px;
  box-shadow: #040084 3px 3px;
  
}
#targets-header {
  grid-area: targets-header;
  font-family: 'Lora', serif;
  font-weight: bold;
  color: white;
  text-align: center;
  text-decoration-line: underline;
}

#units1 {
  grid-area: units1;
  text-align: left;
  font-family: 'Poppins', sans-serif;
    font-weight: bold;
    margin-top: 30%;
}

#units2 {
  grid-area: units2;
  font-family: 'Poppins', sans-serif;
    font-weight: bold;
    margin-top: 30%;
}

#min-num {
  
    font-family: 'Poppins', sans-serif;
    font-weight: bold;
    grid-area: min-num;
    font-size: 5em;
    text-align: right;
    margin: 0;
    padding-bottom: 0;
}

#max-num {
   font-family: 'Poppins', sans-serif;
    font-weight: bold;
    grid-area: max-num;
    font-size: 5em;
    text-align: right;
    margin: 0;
}

#min-text {
   font-family: 'Poppins', sans-serif;
    font-weight: bold;
    grid-area: min-text;
    margin-left: 50%;
    margin-top:0;

}

#max-text {
   font-family: 'Poppins', sans-serif;
    font-weight: bold;
    grid-area: max-text;
    text-align: left;
  
}

.line-chart {
  border-style: 1px solid black;
  display: inline-block;
  grid-area: line-chart;
  background: white;
  border-radius: 10px;
  margin-left: 5%;
}
.pie-chart {
  border-style: 1px solid black;
  display: inline-block;
  grid-area: pie-chart;
  width: 90%;
  margin: auto;
  background: white;
  border-radius: 10px;
}

.chart-grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "line-chart pie-chart"
    "targets pie-chart";
}

#avg-table {
  width: 95%;
  margin-left: auto;
  margin-right: auto;
  border-collapse: separate;
  border-radius: 20px;
  border-spacing: 0;

  border: 1px solid #040084;
  overflow: hidden;
  margin-bottom: 2%;
}

th:not(:last-child),
td:not(:last-child) {
  border-right: 1px solid #040084;
}
#avg-table > thead > tr:not(:last-child) > th,
#avg-table > thead > tr:not(:last-child) > td,
#avg-table > tbody > tr:not(:last-child) > th,
#avg-table > tbody > tr:not(:last-child) > td,
#avg-table > tfoot > tr:not(:last-child) > th,
#avg-table > tfoot > tr:not(:last-child) > td,
#avg-table > tr:not(:last-child) > td,
#avg-table > tr:not(:last-child) > th,
#avg-table > thead:not(:last-child),
#avg-table > tbody:not(:last-child),
#avg-table > tfoot:not(:last-child) {
  border-bottom: 1px solid #040084;
}

#avg-header {
  background: #1874d2;
  color: white;
  text-align: center;
  font-size: 1.5em;
  font-family: "Lora", serif;
  font-weight: bold;
}
.dosage,
.bloodsugar {
  text-align: center;
  font-size: 1.25em;
  color: rgb(46, 45, 45);
  
}

.timeranges {
  text-align: center;
  font-size: 1.25em;
}

#avg-row {
  text-align: center;
  font-family: "Poppins", sans-serif;
  font-weight: bold;
  color: rgb(46, 45, 45);
  background: white;
}

#log-header {
  background: #1874d2;
  color: white;
  text-align: center;
  font-size: 1.5em;
  font-family: "Lora", serif;
  font-weight: bold;
}

#log-table {
  width: 95%;
  margin-left: auto;
  margin-right: auto;
  border-collapse: separate;
  border-radius: 20px;
  border-spacing: 0;

  border: 1px solid #040084;
  overflow: hidden;
  margin-bottom: 5%;
  margin-top: 5%;
  background: white;
}
#log-table > thead > tr:not(:last-child) > th,
#log-table > thead > tr:not(:last-child) > td,
#log-table > tbody > tr:not(:last-child) > th,
#log-table > tbody > tr:not(:last-child) > td,
#log-table > tfoot > tr:not(:last-child) > th,
#log-table > tfoot > tr:not(:last-child) > td,
#log-table > tr:not(:last-child) > td,
#log-table > tr:not(:last-child) > th,
#log-table > thead:not(:last-child),
#log-table > tbody:not(:last-child),
#log-table > tfoot:not(:last-child) {
  border-bottom: 1px solid #040084;
}

#column-title {
  border-bottom: 1px solid #040084;
  font-family: "Poppins", sans-serif;
  font-weight: bold;
  font-size: 1.25em;
  text-align: center;
  color: rgb(46, 45, 45);
}
#row-data {
  font-family: "Poppins", sans-serif;
  font-weight: bold;
  color: rgb(46, 45, 45);
  padding-left: 10px;
}
.log-id {
  text-align: center;
}
#dash-head {
  font-family: 'Lora', serif;
  font-weight: bold;
}
</style>
