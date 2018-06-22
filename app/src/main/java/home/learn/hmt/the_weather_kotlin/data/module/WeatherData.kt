package home.learn.hmt.the_weather_kotlin.data.module

/**
 * Created by hcm-102-0006 on 22/06/2018.
 */
class WeatherData(
    var id: Long,
    var name: String,
    var cod: Int,
    var base: String,
    var visibility: Int,
    var coord: Coord,
    var main: Main
)