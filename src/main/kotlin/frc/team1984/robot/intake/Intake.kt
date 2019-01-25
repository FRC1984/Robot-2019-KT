package frc.team1984.robot.intake

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.Spark
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team1984.lib.oi.XboxMap
import frc.team1984.robot.OI
import frc.team1984.robot.RobotMap

object Intake : Subsystem() {

    private val actuator = DoubleSolenoid(RobotMap.INTAKE_DOUBLE_A, RobotMap.INTAKE_DOUBLE_B)
    private val motor = Spark(RobotMap.INTAKE_MOTOR)

    var isOut = true
        set(input) {
            field = input

            if(!field) {
                actuator.set(DoubleSolenoid.Value.kForward)
            } else {
                actuator.set(DoubleSolenoid.Value.kReverse)
            }
        }

    init { reset() }

    override fun initDefaultCommand() { defaultCommand = IntakeWheelCmd{ getIntakeSpeed() } }

    fun reset() { }

    fun intake(xSpeed: Double) {
        motor.set(xSpeed)
    }

    private fun getIntakeSpeed() = OI.Con1.getAxis(XboxMap.Axis.LT) - OI.Con1.getAxis(XboxMap.Axis.RT)
}