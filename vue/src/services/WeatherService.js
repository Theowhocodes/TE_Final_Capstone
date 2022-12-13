import axios from "axios";
const appId = "eb5352ab71bda50f48eedfa3f70eb707";

export default {

    getWeather(){
        return axios.get(`https://cors-anywhere.herokuapp.com/https://api.openweathermap.org/data/3.0/onecall?lat=40.4406&lon=-79.9959&appid=` + appId)
    }

}