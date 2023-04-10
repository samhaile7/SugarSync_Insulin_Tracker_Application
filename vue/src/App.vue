<template>
  <div id="app">
    <the-header />
    
    <router-view />
  </div>
</template>

<script>

import TheHeader from './components/TheHeader.vue'

export default {
  name: 'App',
  components : {
    TheHeader
  }
    
  
}
</script>

