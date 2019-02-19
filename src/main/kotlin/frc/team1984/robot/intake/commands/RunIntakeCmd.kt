package frc.team1984.robot.intake.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.intake.Intake

class RunIntakeCmd(private val fSpeed: Double, private val bSpeed: Double, private val b: Boolean = false) : Command("RunIntakeCmd") {
    init {
        this.requires(Intake)
        this.isInterruptible = true
    }

    override fun execute() {
        Intake.run(fSpeed, bSpeed)
    }

    override fun  isFinished() = if(b) Intake.hasBall && Intake.nextAction == Intake.NextAction.INTAKE else Intake.hasBall

    override fun end() {
        Intake.stop()
    }
}