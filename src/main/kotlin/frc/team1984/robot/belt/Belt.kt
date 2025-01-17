package frc.team1984.robot.belt

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.Relay
import edu.wpi.first.wpilibj.Spark
import frc.team1984.lib.Jawasystem
import frc.team1984.robot.RobotMap
import frc.team1984.robot.belt.commands.ManualBeltCmd

object Belt : Jawasystem() {
    private val motor = Spark(RobotMap.BELT_MOTOR) //Spike gang
    val ballAtBottom = DigitalInput(RobotMap.BOTTOM_ULTRASONIC) // False when ball there
    val ballAtTop = DigitalInput(RobotMap.TOP_ULTRASONIC) // True when ball there
    var stopBall = false
        get() {
            field = ballAtTop.get() || !ballAtBottom.get()
            return field
        }

    override fun initDefaultCommand() {
        defaultCommand = ManualBeltCmd()
    }

    override fun reset() { stop() }

    fun run(speed: Double) = motor.set(speed)

    fun forward() = motor.set(-1.0)

    fun reverse() = motor.set(1.0)

    fun stop() { motor.set(0.0) }
}