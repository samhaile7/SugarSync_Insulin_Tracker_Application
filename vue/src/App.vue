<template>
  <div id="app">
    <the-header />
    
    <router-view />
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

