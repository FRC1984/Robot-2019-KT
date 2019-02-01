package frc.team1984.lib.sensors

import edu.wpi.first.wpilibj.Relay
import edu.wpi.first.wpilibj.Compressor
import kotlinx.coroutines.*


class PressureSwitch(port: Int) {
    private val switch = Relay(port)
    private val comp = Compressor()
    var isEnabled = false
        set(input) {
            field = input
            if(!input) switch.set(Relay.Value.kOff)
        }

    init {
        comp.start()
    }

    fun run() {

            if(comp.pressureSwitchValue) switch.set(Relay.Value.kForward) else switch.set(Relay.Value.kOff)

    }
/*    fun launch() = GlobalScope.launch {
        while(isEnabled) {
            if(comp.pressureSwitchValue) switch.set(Relay.Value.kForward) else switch.set(Relay.Value.kOff)
        }
    }*/

}