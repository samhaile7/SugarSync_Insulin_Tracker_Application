<template>
  <div id="app">
    <the-header />
    
    <router-view class="page-view" />
    <the-footer/>
  </div>
</template>

<script>
import TheFooter from './components/TheFooter.vue'
import TheHeader from './components/TheHeader.vue'

export default {
  name: 'App',
  components : {
    TheHeader,
    TheFooter
  }
    
  
}
</script>

<style scoped>
/* 
.page-view {
  margin: auto

} */
@import url('https://fonts.googleapis.com/css2?family=Quicksand:wght@400;700&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lora:wght@500&family=Quicksand:wght@400;700&family=Source+Sans+Pro:wght@300&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lora:wght@500&family=Quicksand:wght@400;700&family=Source+Sans+Pro:wght@300&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lora:wght@500&family=Poppins:wght@200&family=Quicksand:wght@400;700&family=Source+Sans+Pro:wght@300&display=swap');
</style>



