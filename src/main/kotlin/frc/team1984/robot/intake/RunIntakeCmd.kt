package frc.team1984.robot.intake

import edu.wpi.first.wpilibj.command.Command

class RunIntakeCmd(val fSpeed: Double, val bSpeed: Double) : Command("RunIntakeCmd") {
    init {
        this.requires(Intake)
        this.isInterruptible = true
    }

    override fun execute() { Intake.run(fSpeed, bSpeed) }

    override fun  isFinished() = Intake.hasBall

    override fun end() { Intake.stop() }
}