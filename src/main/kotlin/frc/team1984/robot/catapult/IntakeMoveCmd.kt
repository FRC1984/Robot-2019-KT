package frc.team1984.robot.catapult

import edu.wpi.first.wpilibj.command.Command

class IntakeMoveCmd : Command() {
    init {
        this.requires(Intake)
        this.isInterruptible = true
    }

    override fun execute() { Intake.isOut = true }

    override fun isFinished() = false
    override fun end() { Intake.isOut = false }
}