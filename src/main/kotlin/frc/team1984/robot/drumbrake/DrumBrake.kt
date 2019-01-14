package frc.team1984.robot.drumbrake

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team1984.robot.RobotMap

object DrumBrake : Subsystem() {
    private val actuator = DoubleSolenoid(RobotMap.HATCH_DOUBLE_A, RobotMap.HATCH_DOUBLE_B)
    var holding = false
        set(input) {
            if(input) field xor true else field = false
            if (field) {
                actuator.set(DoubleSolenoid.Value.kForward)
            } else {
                actuator.set(DoubleSolenoid.Value.kReverse)
            }
        }
    override fun initDefaultCommand() { }
}