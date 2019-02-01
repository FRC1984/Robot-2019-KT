package frc.team1984.robot.intake.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.intake.Intake

class ManualIntakeCmd(var fSpeed: () -> Double, var bSpeed: () -> Double) : Command() {
    init {
        this.requires(Intake)
        this.isInterruptible = true
    }

    override fun execute() = Intake.run(fSpeed(), bSpeed())

    override fun isFinished() = false
    override fun end() = Intake.stop()
}