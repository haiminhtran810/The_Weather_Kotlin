package home.learn.hmt.the_weather_kotlin.data.module

/**
 * Created by hcm-102-0006 on 22/06/2018.
 */
data class Forecast(
    val dt: Long,
    val dt_txt: String,
    val sys: Sys,
    val main: Main,
    val weather: List<Weather>,
    val wind: Wind
)