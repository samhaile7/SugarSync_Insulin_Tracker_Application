<template>
  <div>

    <canvas id = "myChart" width = "400" height = "400"></canvas>
    </div>
</template>

<script>

import Chart from 'chart.js/auto';

export default {

  name: 'HelloWorld', 
  props: {}, 
  mounted() {
    console.log('Component Mounted')

    const ctx = document.getElementById('myChart');

    const myChart = new Chart(ctx, {
    type: 'bar',
    data: {
      labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
      datasets: [{
        label: '# of Votes',
        data: [12, 19, 3, 5, 2, 3],
        borderWidth: 1
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });
  myChart;
  }

}

</script>

<style>

</style>