package frc.team1984.robot.belt.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.belt.Belt
import frc.team1984.robot.belt.Belt.stop
import frc.team1984.robot.intake.Intake

class BeltShootCmd() : Command() {
    init {
        this.requires(Belt)

    }

    override fun execute() = if(Intake.wants == Intake.State.SHOOTHIGH) Belt.forward() else Belt.reverse()
    override fun isFinished() = false
    override fun end() {
        stop()
        Intake.wants = Intake.State.INTAKE
    }
}