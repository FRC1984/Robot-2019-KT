package frc.team1984.robot.belt.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.belt.Belt.ballAtBottom
import frc.team1984.robot.belt.Belt.ballAtTop
import frc.team1984.robot.belt.Belt.forward
import frc.team1984.robot.belt.Belt.reverse

import frc.team1984.robot.intake.Intake

class BeltCmd : Command("BeltCmd") {
    override fun execute() = if(Intake.nextAction == Intake.NextAction.SHOOTHIGH) forward() else reverse()
    override fun isFinished() = !ballAtBottom.get() || !ballAtTop.get()
    override fun end() {
        Intake.nextAction = Intake.NextAction.INTAKE
    }
}