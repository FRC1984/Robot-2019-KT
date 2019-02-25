package frc.team1984.robot.belt.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.belt.Belt
import frc.team1984.robot.belt.Belt.forward
import frc.team1984.robot.belt.Belt.reverse
import frc.team1984.robot.belt.Belt.stop
import frc.team1984.robot.intake.Intake

class BeltCmd : Command() {
    init {
        this.requires(Belt)
        this.isInterruptible = true
    }
    override fun execute() {
        if(Intake.nextAction == Intake.NextAction.SHOOTHIGH) forward() else reverse()
    }

    override fun isFinished(): Boolean {
        return Belt.stopBall
    }

    override fun end() = stop()
}