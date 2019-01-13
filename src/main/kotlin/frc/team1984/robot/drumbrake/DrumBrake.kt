package frc.team1984.robot.drumbrake

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team1984.robot.RobotMap

object DrumBrake : Subsystem() {
    private val actuator = DoubleSolenoid(RobotMap.HATCH_DOUBLE_A, RobotMap.HATCH_DOUBLE_B)
    var holding = false

    override fun initDefaultCommand() {
        //defaultCommand =
    }

    fun toggleHold() {
        holding xor true
        if (holding) actuator.set(DoubleSolenoid.Value.kForward) else actuator.set(DoubleSolenoid.Value.kReverse)
    }


}