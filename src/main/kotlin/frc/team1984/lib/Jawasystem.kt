package frc.team1984.lib

import edu.wpi.first.wpilibj.command.Subsystem

abstract class Jawasystem : Subsystem() {
    abstract fun reset()
    abstract fun brownOut()
    override fun initDefaultCommand() { }
}