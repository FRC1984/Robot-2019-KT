package frc.team1984.lib.sensors

import frc.team1984.lib.Jawasystem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CurrentManager(val sourceFun: () -> Double, private val THRESHOLD: Double, private val LENGTH: Long, private val subsystem: Jawasystem) {
    init {
        launch()
    }

    fun launch() {} /* = GlobalScope.launch {
        while(sourceFun() < THRESHOLD) {
            subsystem.brownOut()
            delay(LENGTH)
        }
    }*/
}