package frc.team1984.robot.intake.commands

import edu.wpi.first.wpilibj.command.ConditionalCommand
import frc.team1984.robot.intake.Intake
import frc.team1984.robot.intake.IntakeConsts
import frc.team1984.robot.intake.commands.RunIntakeCmd


class ChooseShootCmd : ConditionalCommand(IntakeInCmd(),
                                          RunIntakeCmd(IntakeConsts.FRONT_SHOOTLOW_SPEED,
                                                       IntakeConsts.BACK_SHOOTLOW_SPEED,
                                                    true )) {
    init {
        requires(Intake)
    }
    override fun condition(): Boolean {
        return Intake.nextAction == Intake.NextAction.SHOOTHIGH
    }
}