<template>
  <div>
    <canvas id="myChart"></canvas>
  </div>
</template>

<script>

import Chart from 'chart.js/auto';

export default {

  name: 'chart',
  computed: {
    bloodSugarHistory() {
     return this.allMealsFromServer.map((meal) => {
       return meal.suggestedDose;
     })
  }},
  props: ['allMealsFromServer'],
  mounted() {
    console.log('Component Mounted')

    const ctx = document.getElementById('myChart');
    const labels = [65, 59, 80, 81, 56, 55, 40];

    const myChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: labels,
      datasets: [{


        label: 'Blood Sugar',
        data: this.bloodSugarHistory,
        fill: false,
        borderColor: 'rgb(255, 0, 0)',
        tension: 0
        },

        {label: 'Insulin',
        data: [65, 59, 80, 43, 56, 55, 40],
        fill: false,
        borderColor: 'rgb(0, 0, 255)',
        tension: 0
        },

         {label: 'Target Blood Sugar Max',
        data: [150, 150,150,150,150,150,150],
        fill: '-1',
        borderColor: '	rgb(50,205,50)',
        backgroundColor: 'rgba(55, 173, 221)',

        tension: 0
        },

         {label: 'Target Blood Sugar Minimum',
        data: [65, 65,65,65,65,65,65],
        fill: false,
        borderColor: 'rgb(50, 205, 50)',
        tension: 0
        }




        ]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        },
      }
    }
  });
  myChart;
  }

}
</script>

<style></style>
