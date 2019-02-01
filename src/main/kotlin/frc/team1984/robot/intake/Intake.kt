package frc.team1984.robot.intake

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.Spark
import frc.team1984.lib.Jawasystem
import frc.team1984.lib.oi.XboxMap
import frc.team1984.robot.OI
import frc.team1984.robot.RobotMap

object Intake : Jawasystem() {

    private val actuator = DoubleSolenoid(RobotMap.INTAKE_DOUBLE_A, RobotMap.INTAKE_DOUBLE_B)
    private val frontMotor = Spark(RobotMap.INTAKE_MOTOR)
    private val backMotor = Spark(RobotMap.INTAKE_MOTOR_2)
    private val ballSwitch = DigitalInput(0)
    private val intakeSwitch = DigitalInput(1)

    var wants = State.INTAKE
    var hasBall = false
        get() = !ballSwitch.get()
    var setOut = false
        set(input) {
            field = input

            if(field) {
                actuator.set(DoubleSolenoid.Value.kForward)
            } else {
                actuator.set(DoubleSolenoid.Value.kReverse)
            }
        }
    var isIn = setOut
            get() = !intakeSwitch.get()

    init { reset() }

    override fun initDefaultCommand() {  } //ManualCmd

    override fun reset() { stop() }

    fun run(frontSpeed: Double, backSpeed: Double) {
        frontMotor.set(frontSpeed)
        backMotor.set(backSpeed)
    }

    fun stop() = run(0.0, 0.0)

    fun getIntakeSpeed() = OI.Con1.getAxis(XboxMap.Axis.LT) - OI.Con1.getAxis(XboxMap.Axis.RT)

    enum class State {
        INTAKE,
        SHOOTHIGH,
        SHOOTLOW
    }
}