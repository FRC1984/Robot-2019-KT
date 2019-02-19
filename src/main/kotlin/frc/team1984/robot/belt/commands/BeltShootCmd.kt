package frc.team1984.robot.belt.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.belt.Belt
import frc.team1984.robot.belt.Belt.ballAtBottom
import frc.team1984.robot.belt.Belt.ballAtTop
import frc.team1984.robot.belt.Belt.stop
import frc.team1984.robot.intake.Intake

class BeltShootCmd : Command() {
    init {
        this.requires(Belt)
        this.isInterruptible = true
    }

    override fun execute() = if(ballAtTop.get()) Belt.forward() else Belt.reverse()
    override fun isFinished() = false
    override fun end() {
        stop()
        Intake.nextAction = Intake.NextAction.INTAKE
    }
}