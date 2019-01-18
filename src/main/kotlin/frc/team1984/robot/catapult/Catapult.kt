package frc.team1984.robot.catapult

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.Spark
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team1984.robot.RobotMap

object Catapult : Subsystem() {

    private val actuator = DoubleSolenoid(RobotMap.CAT_DOUBLE_A, RobotMap.CAT_DOUBLE_B)
    private val safety = DoubleSolenoid(RobotMap.CAT_HOLDER_DOUBLE_A, RobotMap.CAT_HOLDER_DOUBLE_B)
    private val motor = Spark(RobotMap.INTAKE_MOTOR)

    var safe = true
        set(input) {
            if(!input) field xor true else field = true
            if(field) {
                safety.set(DoubleSolenoid.Value.kForward)
            } else {
                safety.set(DoubleSolenoid.Value.kReverse)
            }
        }
    var launch = false
        set(input) {
            print("launch mutated")
            if(input) field xor true else field = false
            if (field) {
                actuator.set(DoubleSolenoid.Value.kForward)
            } else {
                actuator.set(DoubleSolenoid.Value.kReverse)
            }
        }
    init {
        reset()
    }

    fun reset() {
        launch = false
        safe = true
    }

    //temporary - for testing
    fun intakeIn(xSpeed: Double) = motor.set(xSpeed)
    fun intakeOut(xSpeed: Double) = motor.set(-xSpeed)

    override fun initDefaultCommand() { }
}