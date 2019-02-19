package frc.team1984.robot.commandgroups

import edu.wpi.first.wpilibj.command.CommandGroup
import frc.team1984.robot.belt.Belt
import frc.team1984.robot.belt.commands.BeltCmd
import frc.team1984.robot.intake.IntakeConsts
import frc.team1984.robot.intake.Intake
import frc.team1984.robot.intake.commands.IntakeInCmd
import frc.team1984.robot.intake.commands.RunIntakeCmd

class ShootLow : CommandGroup() {
    init {
        this.requires(Intake)
        addParallel(RunIntakeCmd(IntakeConsts.FRONT_SHOOTLOW_SPEED, IntakeConsts.BACK_SHOOTLOW_SPEED, true))
        addSequential(BeltCmd())
        addSequential(IntakeInCmd())
    }
}