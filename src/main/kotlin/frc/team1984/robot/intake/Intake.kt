package frc.team1984.robot.intake

import edu.wpi.first.wpilibj.*
import frc.team1984.lib.Jawasystem
import frc.team1984.lib.oi.XboxMap
import frc.team1984.robot.OI
import frc.team1984.robot.RobotMap

object Intake : Jawasystem() {
    private val frontMotor = Spark(RobotMap.INTAKE_MOTOR)
    private val backMotor = Spark(RobotMap.INTAKE_MOTOR_2)
    private val ballSwitch = DigitalInput(RobotMap.BALL_SWITCH)
    private val intakeSwitch = DigitalInput(RobotMap.INTAKE_SWITCH)
//    private val intakeCurrentMgr = CurrentManager({ RobotController.getBatteryVoltage()}, 7.5, 100, this)

    val solenoid = Solenoid(RobotMap.INTAKE_SOLENOID)

    var nextAction: Intake.NextAction = NextAction.INTAKE
    var hasBall = false
        get() {
            field = !ballSwitch.get()
            return field
        }

    var isIn = true
        get() {
            field = !intakeSwitch.get()
            return field
        }

    init { reset() }

    override fun initDefaultCommand() {  } //ManualCmd

    override fun reset() { stop() }

    fun run(frontSpeed: Double, backSpeed: Double) {
        frontMotor.set(frontSpeed)
        backMotor.set(backSpeed)
    }

    fun stop() = run(0.0, 0.0)

    fun getIntakeSpeed() = OI.Con1.getAxis(XboxMap.Axis.LT) - OI.Con1.getAxis(XboxMap.Axis.RT)

    override fun brownOut() = stop()

    enum class NextAction {
        INTAKE,
        SHOOTHIGH,
        SHOOTLOW
    }
}