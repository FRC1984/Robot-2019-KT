package frc.team1984.robot.catapult

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team1984.robot.RobotMap

object Catapult : Subsystem() {

    private val actuator = DoubleSolenoid(RobotMap.CAT_DOUBLE_A, RobotMap.CAT_DOUBLE_B)
    private val safety = DoubleSolenoid(RobotMap.CAT_HOLDER_DOUBLE_A, RobotMap.CAT_HOLDER_DOUBLE_B)

    init {
        reset()
    }

    fun reset() {
        
    }
}