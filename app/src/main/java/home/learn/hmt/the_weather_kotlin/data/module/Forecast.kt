package home.learn.hmt.the_weather_kotlin.data.module

/**
 * Created by hcm-102-0006 on 22/06/2018.
 */
class Forecast(
    var dt: Long,
    var dt_txt: String,
    var sys: Sys,
    var main: Main,
    var weather: List<Weather>,
    var wind: Wind
)