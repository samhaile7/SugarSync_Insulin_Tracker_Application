<template>
  <div id="foot-grid">
    <p id="copyright">&#169; Copyright 2023 Insulin Tracker </p>
    <p id="warning">SugarSync is a non-HIPAA compliant application and should only be used for demos.</p>


      
  </div>
</template>

<script>
export default {

}
</script>

<style>

#foot-grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: 
  "copyright warning"
  ;
  border-top: #040084 2px solid;

}

#copyright {
  grid-area: copyright;
  font-family: 'Lora', serif;
  font-weight: bold;
  margin-left: 5px;
}

#warning {
  grid-area: warning;
  font-family: 'Lora', serif;
  font-weight: bold;
  text-align: right;
  margin-right: 5px;
}


</style>