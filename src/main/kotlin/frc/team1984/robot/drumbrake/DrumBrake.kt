package frc.team1984.robot.drumbrake

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.Solenoid
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team1984.lib.Jawasystem
import frc.team1984.robot.RobotMap

object DrumBrake : Jawasystem() {
    private val actuator = Solenoid(RobotMap.HATCH_SOLENOID)

    var isHold = true
        set(input) {
            field = input

            actuator.set(isHold)
        }

    override fun reset() { isHold = true }
    override fun initDefaultCommand() { }
}