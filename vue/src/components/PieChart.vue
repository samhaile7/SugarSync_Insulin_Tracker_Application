<template>
  <div class="whole-chart">
    <h1>Blood Sugar Alerts</h1>
    <br>
    <canvas id="pieChart"></canvas>
  </div>
</template>

<script>
import Chart from "chart.js/auto";
export default {
  name: "piechart",
  computed: {
    numberOfLogTypeThree() {
return this.userLogs.filter((log) => {
  return log.logTypeId === 3;
}).length
      },
      numberOfLogTypeFour() {
return this.userLogs.filter((log) => {
  return log.logTypeId === 4;
}).length
      },
      numberOfLogTypeFive() {
return this.userLogs.filter((log) => {
  return log.logTypeId === 5;
}).length
      },
       numberOfLogTypeSix() {
return this.userLogs.filter((log) => {
  return log.logTypeId === 6;
}).length
      },
    },
  
  props: ["userLogs"],
  mounted() {
    console.log("Component Mounted");

    const ctx = document.getElementById("pieChart");
    const labels = [
      "Low",
      "High",
      "Critically Low",
      "Critically High",
      
    ];

    const pieChart = new Chart(ctx, {
      type: "doughnut",
      data: {
        labels: labels,
        datasets: [
          {
            label: "Alerts",
            data: [this.numberOfLogTypeThree, this.numberOfLogTypeFour, this.numberOfLogTypeFive, this.numberOfLogTypeSix],
            backgroundColor: [
              "#F99244",
              "#487be3",
              "#0141CF",
              "#FF6A4C"
            ],
            hoverOffset: 4,
          }
        ],
      },
      });
      pieChart;
  },
};
     
</script>

<style scoped>

h1 {
    font-family: 'Lora', serif;
  font-weight: bold;
  margin-left: 1%;
  margin-right: 1%;
  border-bottom: #232069 solid ;
  color: #232069;
  
  
}

</style>
