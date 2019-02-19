package frc.team1984.robot.drumbrake

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.Solenoid
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team1984.lib.Jawasystem
import frc.team1984.robot.RobotMap

object DrumBrake : Jawasystem() {
    val solenoid = Solenoid(RobotMap.HATCH_SOLENOID) // True = Cylinder Out

    override fun reset() { solenoid.set(true) }
    override fun initDefaultCommand() { }
}