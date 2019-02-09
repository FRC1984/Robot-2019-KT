package frc.team1984.lib.sensors

import edu.wpi.first.wpilibj.Relay
import edu.wpi.first.wpilibj.Compressor
import frc.team1984.lib.Jawasystem
import frc.team1984.robot.consts.Consts
import kotlinx.coroutines.*


class PressureSwitch(port: Int) : Jawasystem() {
    private val switch = Relay(port)
    private val comp = Compressor(0)
    var isEnabled = false
        set(input) {
            field = input
            if(!input) switch.set(Relay.Value.kOff)
        }

    init {
        comp.start()
    }

/*    fun run() {

            if(!comp.pressureSwitchValue) switch.set(Relay.Value.kForward) else switch.set(Relay.Value.kOff)

    }*/
    fun launch() = GlobalScope.launch {
        while(isEnabled) {
            if(!comp.pressureSwitchValue) switch.set(Relay.Value.kForward) else switch.set(Relay.Value.kOff)
            delay((Consts.K_DT * 1000).toLong())
        }
    }

    override fun reset() { isEnabled = false }
    override fun brownOut() = reset()

}