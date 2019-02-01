package frc.team1984.robot.belt

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.Relay
import frc.team1984.lib.Jawasystem
import frc.team1984.robot.RobotMap
import frc.team1984.robot.belt.commands.ManualBeltCmd

object Belt : Jawasystem() {
    private val motor = Relay(RobotMap.BELT_MOTOR) //Spike gang
    private val dio = DigitalInput(2)

    var ballAtTop = {!dio.get()}

    override fun initDefaultCommand() {
        defaultCommand = ManualBeltCmd()
    }

    override fun reset() { stop() }

    fun forward() = motor.set(Relay.Value.kForward)

    fun reverse() = motor.set(Relay.Value.kReverse)

    fun stop() { motor.set(Relay.Value.kOff) }
}