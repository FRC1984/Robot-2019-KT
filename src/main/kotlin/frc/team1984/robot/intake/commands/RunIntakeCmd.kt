package frc.team1984.robot.intake.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.intake.Intake

class RunIntakeCmd(private val fSpeed: Double, private val bSpeed: Double) : Command("RunIntakeCmd") {
    init {
        this.requires(Intake)
        this.isInterruptible = true
    }

    override fun execute() {
        Intake.run(fSpeed, bSpeed)
    }

    override fun  isFinished() = Intake.hasBall

    override fun end() {
        Intake.stop()
    }
}