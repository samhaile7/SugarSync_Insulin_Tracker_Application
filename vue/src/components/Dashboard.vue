<template>
  <div>
    
    <!-- <h1 id="dash-head">Welcome to your SugarSync dashboard! </h1> -->
    <div id="dash-grid">
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
        <th id="avg-row" class="bloodsugar">Blood Sugar (mmol/L)</th>
        <td id="avg-row">{{ bloodSugarAvgList[0].toFixed(2) }}</td>
        <td id="avg-row">{{ bloodSugarAvgList[1].toFixed(2) }}</td>
        <td id="avg-row">{{ bloodSugarAvgList[2].toFixed(2) }}</td>
        <td id="avg-row">{{ bloodSugarAvgList[3].toFixed(2) }}</td>
        <td id="avg-row">{{ bloodSugarAvgList[4].toFixed(2) }}</td>
      </tr>
      <tr>
        <th id="avg-row" class="dosage">Dosage (units)</th>
        <td id="avg-row">{{ insulinDosageAvgList[0].toFixed(2) }}</td>
        <td id="avg-row">{{ insulinDosageAvgList[1].toFixed(2) }}</td>
        <td id="avg-row">{{ insulinDosageAvgList[2].toFixed(2) }}</td>
        <td id="avg-row">{{ insulinDosageAvgList[3].toFixed(2) }}</td>
        <td id="avg-row">{{ insulinDosageAvgList[4].toFixed(2) }}</td>
      </tr>
    </table>
    <!-- <LineChart v-bind:allMealsFromServer="allMealsFromServer" /> -->

    <!-- <p>Daily Blood Sugar AVG : {{ bloodSugarAvgList[0] }}</p>
    <p>3 Day : {{ bloodSugarAvgList[1] }}</p>
    <p>7 day : {{ bloodSugarAvgList[2] }}</p>
    <p>2 week : {{ bloodSugarAvgList[3] }}</p> -->

    <div class="chart-grid">
      <LineChart
        class="line-chart"
        v-if="isDataLoaded"
        v-bind:arrayToPass="arrayToPass"
      />
      <!-- <LineChart class="line-chart" v-if="isDataLoaded" v-bind:arrayToPass="arrayToPass" v-bind:allMealsFromServer="allMealsFromServer" v-bind:currentTargetMinFromServer = "currentTargetMinFromServer"  /> -->

      <div class="targets"> 
        <h3 id="targets-header">Blood Sugar Targets</h3>
        <p id="min-num">
           {{ currentTargetMinFromServer }}
        </p>
        <p id="units1">(mmol/L)</p>
        <p id="min-text">Minimum:</p>
        
        <p id="max-num">
           {{ currentTargetMaxFromServer }}
        </p>
        <p id="units2">(mmol/L)</p>
        <p id="max-text">Maximum:</p>
      </div>
      <PieChart
        v-if="isUserLogsLoaded"
        v-bind:userLogs="userLogs"
        class="pie-chart"
      />
    </div>

    <table id="log-table">
      <thead>
        <tr>
          <th id="log-header" colspan="2">Activity Log</th>
        </tr>
        <tr>
          <!-- <th id="column-title">Log Id</th> -->
          <th id="column-title">Log Type</th>
          <th id="column-title">Date/Time Logged</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(log, index) in userLogs" v-bind:key="index">
          <!-- <td id="row-data" class="log-id">{{ userLogs[index].logId }}</td> -->
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
import LineChart from "../components/LineChart.vue";
import PieChart from "../components/PieChart.vue";

export default {
  components: { LineChart, PieChart },
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
      LogService.getAllLogsByUserId()
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

<style scoped>

#dash-grid {
  background-color: #487BE3;
  padding-bottom: 3%;
  padding-top: 3%;
}


.targets {
  display: grid;
  grid-area: targets;
  border-style: 1px solid black;
  border-radius: 10px;
  background-color: #FD6600;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr;
  grid-template-areas: 
  "targets-header targets-header targets-header targets-header targets-header targets-header"
  "min-text min-num units1 max-text max-num units2";
  margin: auto;
  width: 95%;
  color: white;
  text-shadow: black 2px 2px 2px;
  box-shadow:black 5px 5px 10px;
  
  margin-left: 5%;
  margin-bottom: 0;
  margin-top: 2%;


  
}
#targets-header {
  grid-area: targets-header;
  font-family: 'Lora', serif;
  font-weight: bold;
  color: white;
  text-align: center;
  text-decoration-line: underline;
  padding-top: 3%;
  margin-bottom: 0;

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
    margin-top:0;
    text-align: right;
    font-size: 1.5em;
    

}

#max-text {
   font-family: 'Poppins', sans-serif;
    font-weight: bold;
    grid-area: max-text;
    text-align: right;
    border-left: 3px solid white;
    font-size: 1.5em;
    padding-left: 5px;
    
}

.line-chart {
  border-style: 1px solid black;
  display: inline-block;
  grid-area: line-chart;
  background: white;
  border-radius: 10px;
  margin-left: 5%;
  box-shadow:black 5px 5px 10px;
}
.pie-chart {
  border-style: 1px solid black;
  display: inline-block;
  grid-area: pie-chart;
  width: 90%;
  margin: auto;
  background: white;
  border-radius: 10px;
  box-shadow:black 5px 5px 10px;
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
  box-shadow:black 5px 5px 10px;
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
  background: #FD7F00;
  color: white;
  text-align: center;
  font-size: 1.5em;
  font-family: "Lora", serif;
  font-weight: bold;
  text-shadow: black 2px 2px 2px;
}
.dosage,
.bloodsugar {
  text-align: center;
  font-size: 1.25em;
  color: #232069;
  
}

.timeranges {
  text-align: center;
  font-size: 1.25em;
}

#avg-row {
  text-align: center;
  font-family: "Poppins", sans-serif;
  font-weight: bold;
  color: #232069;
  background: white;
}

#log-header {
  background: #FD7F00;
  color: white;
  text-align: center;
  font-size: 1.5em;
  font-family: "Lora", serif;
  font-weight: bold;
  text-shadow: black 2px 2px 2px;
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
  
  margin-top: 2%;
  background: white;
  box-shadow:black 5px 5px 10px;
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
  color: #232069;
}
#row-data {
  font-family: "Poppins", sans-serif;
  font-weight: bold;
  color: #232069;
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
