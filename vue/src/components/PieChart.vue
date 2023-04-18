<template>
  <div class="whole-chart">
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
            label: "My First Dataset",
            data: [this.numberOfLogTypeThree, this.numberOfLogTypeFour, this.numberOfLogTypeFive, this.numberOfLogTypeSix],
            backgroundColor: [
              "rgb(0, 0, 255)",
              "rgb(54, 162, 235)",
              "rgb(255, 205, 86)",
              "rgb(255,69,1)"
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

<style>
/* .whole-chart {
    width: 40%;
} */
</style>
