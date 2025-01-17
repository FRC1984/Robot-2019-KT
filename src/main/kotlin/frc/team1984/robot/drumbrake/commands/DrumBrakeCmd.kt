package frc.team1984.robot.drumbrake.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.drumbrake.DrumBrake

class DrumBrakeCmd : Command() {
    init {
        this.requires(DrumBrake)
        this.isInterruptible = true
    }

    override fun execute() {
        DrumBrake.solenoid.set(true)

    }
    override fun isFinished() = false
    override fun end() { DrumBrake.solenoid.set(false) }
}