package frc.team1984.robot.commandgroups

import edu.wpi.first.wpilibj.command.CommandGroup
import frc.team1984.robot.intake.IntakeConsts
import frc.team1984.robot.intake.*
import frc.team1984.robot.intake.commands.ChooseShootCmd
import frc.team1984.robot.intake.commands.IntakeInCmd
import frc.team1984.robot.intake.commands.IntakeOutCmd
import frc.team1984.robot.intake.commands.RunIntakeCmd

class IntakeBall : CommandGroup() {
    init {
        this.requires(Intake)
        addSequential(IntakeOutCmd())
        addSequential(RunIntakeCmd(IntakeConsts.FRONT_INTAKING_SPEED, IntakeConsts.BACK_INTAKING_SPEED))
        addSequential(ChooseShootCmd())
    }
}