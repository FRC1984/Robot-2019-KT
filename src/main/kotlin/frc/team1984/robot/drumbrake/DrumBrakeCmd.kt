package frc.team1984.robot.drumbrake

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.catapult.Intake

class DrumBrakeCmd : Command() {
    init {
        this.requires(DrumBrake)
        this.isInterruptible = true
    }

    override fun execute() {
        DrumBrake.isHold = true
    }
    override fun isFinished() = !Intake.isOut
    override fun end() { DrumBrake.isHold xor false }
}