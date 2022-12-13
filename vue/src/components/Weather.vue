<template>
  <div>

      <label for="Temp"> Current Temp:
    <weather-service v-text="kelvToFar()" />
      </label>

      <weather-service v-text="displayWeather()" />

  </div>
</template>

<script>
import WeatherService from "@/services/WeatherService.js";

export default {
  name: "getWeather",

  methods : {
      kelvToFar() {
         let fahrenheit = 1.8*(this.current.temp -273) + 32
         return Math.round(fahrenheit);
      },
      displayWeather(){
          return this.current.weather.description;
      }
  },
  data() {
    return {
      current: {
        temp: "",

        weather: 
            {
                main: '',
                description: '',
                icon: ''
            }
      },
    };
  },

  created() {
    WeatherService.getWeather().then((response) => {
      this.current.temp = response.data.current.temp;
    });

    WeatherService.displayWeather().then((response) => {
        this.current.weather.description = response.data.current.weather.description;
    })
  },
};
</script>

<style>

</style>