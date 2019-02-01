package frc.team1984.robot.intake.commands

import edu.wpi.first.wpilibj.command.ConditionalCommand
import frc.team1984.robot.commandgroups.ShootHigh
import frc.team1984.robot.commandgroups.ShootLow
import frc.team1984.robot.intake.Intake

class ChooseShootCmd : ConditionalCommand(ShootHigh(), ShootLow()) {
    init {
        requires(Intake)
    }
    override fun condition(): Boolean {
        when(Intake.wants) {
            Intake.State.SHOOTHIGH -> {
                return true
            }
            Intake.State.SHOOTLOW -> {
                return false
            }
            else -> { }
        }
        return false
    }
}