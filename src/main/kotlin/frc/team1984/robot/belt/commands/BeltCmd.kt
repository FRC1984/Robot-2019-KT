package frc.team1984.robot.belt.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.belt.Belt.ballAtTop
import frc.team1984.robot.belt.Belt.forward
import frc.team1984.robot.belt.Belt.reverse
import frc.team1984.robot.belt.Belt.stop

import frc.team1984.robot.intake.Intake

class BeltCmd : Command("BeltCmd") {
    override fun execute() = if(Intake.wants == Intake.State.SHOOTHIGH) forward() else reverse()
    override fun isFinished() = ballAtTop()
    override fun end() {
        Intake.wants = Intake.State.INTAKE
    }
}