<template>
  <div >
    <canvas id="myChart" class="whole-chart"></canvas>

    <!-- {{bloodSugarHistory}}
    {{insulinHistory}}
    Array to pass is here {{ this.arrayToPass }} -->

    <br />
    <br />
    <!-- {{ this.dateArray }}
    {{ this.targetmin }}
     {{ this.targetmax }} -->
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
            tension: 0,
          },

          {
            label: "Insulin",
            data: this.insulinHistory,
            fill: false,
            borderColor: "rgb(0, 0, 255)",
            tension: 0,
          },

           {label: 'Target Blood Sugar Max',
          data: this.targetmax,
          fill: false,
          borderColor: '	#0141CF',
          backgroundColor: 'rgba(55, 173, 221)',

          tension: 0
          },

           {label: 'Target Blood Sugar Minimum',
          data: this.targetmin,
          fill: false,
          borderColor: '#0141CF',
          tension: 0
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
