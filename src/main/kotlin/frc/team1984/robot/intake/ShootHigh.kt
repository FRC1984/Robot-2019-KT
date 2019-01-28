package frc.team1984.robot.intake

import edu.wpi.first.wpilibj.command.CommandGroup
import frc.team1984.robot.consts.IntakeConsts

class ShootHigh() : CommandGroup() {
    init {
        this.requires(Intake)
    }
    override fun execute() {

    }

    override fun isFinished() = false

    override fun end() {

    }


}