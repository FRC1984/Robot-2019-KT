package frc.team1984.robot.drumbrake

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team1984.lib.Jawasystem
import frc.team1984.robot.RobotMap

object DrumBrake : Jawasystem() {
    private val actuator = DoubleSolenoid(RobotMap.HATCH_DOUBLE_A, RobotMap.HATCH_DOUBLE_B)

    var isHold = true
        set(input) {
            field = input

            if(field) {
                actuator.set(DoubleSolenoid.Value.kForward)
            } else {
                actuator.set(DoubleSolenoid.Value.kReverse)
            }
        }

    override fun reset() { isHold = true }
    override fun initDefaultCommand() { }
}