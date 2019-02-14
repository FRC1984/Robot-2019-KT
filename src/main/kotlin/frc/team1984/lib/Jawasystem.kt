package frc.team1984.lib

import edu.wpi.first.wpilibj.command.Subsystem

abstract class Jawasystem : Subsystem() {
    abstract fun reset()
    fun brownOut() {}
    override fun initDefaultCommand() { }
}