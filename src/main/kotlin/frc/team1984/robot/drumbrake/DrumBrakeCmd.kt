package frc.team1984.robot.drumbrake

import edu.wpi.first.wpilibj.command.Command

class DrumBrakeCmd : Command() {
    init {
        this.requires(DrumBrake)
        this.isInterruptible = true
    }

    override fun execute() {
        DrumBrake.isHold = true
    }
    override fun isFinished() = false
    override fun end() { DrumBrake.isHold = false }
}