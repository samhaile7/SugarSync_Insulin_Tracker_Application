<template>
  <div >
    {{this.targetmin}}
    {{this.targetmax}}
    <canvas id="myChart" class="whole-chart"></canvas>

    <!-- {{bloodSugarHistory}}
    {{insulinHistory}}
    Array to pass is here {{ this.arrayToPass }} -->

    <br />
    <br />
    <!-- {{ this.dateArray }}
    {{ this.targetmin }}
     {{ this.targetmax }} -->

     <!-- {{this.arrayToPass[0]}}
     {{this.arrayToPass[1]}}
     {{this.arrayToPass[2]}} -->
  </div>
</template>

<script>
import Chart from "chart.js/auto";

export default {
  name: "chart",
  computed: {
    targetmin() {
            let outputArray = [];

        for (let i = 0; i < this.bloodSugarHistory.length; i++) {
        outputArray.push(this.arrayToPass[1]);
      }
     
      return outputArray;
    },
    targetmax() {
      let outputArray = [];

      for (let i = 0; i < this.bloodSugarHistory.length; i++) {
        outputArray.push(this.arrayToPass[2]);
      }
      return outputArray;
    },
    bloodSugarHistory() {
      return this.arrayToPass[0].map((meal) => {
        return meal.bloodSugarAtMealtime;
      });
    },
    dateArray() {
      return this.arrayToPass[0].map((meal) => {
        return meal.dateCreated;
      });
    },
    insulinHistory() {
      return this.arrayToPass[0].map((meal) => {
        return meal.suggestedDose;
      });
    },
  },
  // props: ['allMealsFromServer'],
  props: ["arrayToPass"],
  mounted() {
    console.log("Component Mounted");

    const ctx = document.getElementById("myChart");
    const labels = this.dateArray;

    const myChart = new Chart(ctx, {
      type: "line",
      data: {
        labels: labels, 
        datasets: [
          {
            label: "Blood Sugar",
            data: this.bloodSugarHistory,
            fill: false,
            borderColor: "#ff4041",
            backgroundColor: '#ff4041',
            tension: 0.25,
          },

          {
            label: "Insulin",
            data: this.insulinHistory,
            fill: false,
            borderColor: "#faab33",
            backgroundColor: '#faab33',
            tension: 0.25,
          },

           {label: 'Target Blood Sugar Max',
          data: this.targetmax,
          fill: false,
          borderColor: '	#487be3',
          backgroundColor: '#487be3',

          tension: 0.25,
          },

           {label: 'Target Blood Sugar Minimum',
          data: this.targetmin,
          fill: false,
          borderColor: '#0141CF',
          backgroundColor: '#0141cf',
          tension: 0.25,
          }
        ],
      },
      options: {
        scales: {
          y: {
            beginAtZero: true,
            // steps: 50,
            // stepValue: 5,
            max:250,
          },
          // x: {
          // type : 'date'
            
          // },
        },
      },
    });
    myChart;
  },
};
</script>

<style>

/* .whole-chart {
    width: 40%;
    border-style: 10px solid black;
} */

</style>
