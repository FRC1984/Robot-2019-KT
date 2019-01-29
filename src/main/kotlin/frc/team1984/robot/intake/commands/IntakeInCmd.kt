package frc.team1984.robot.intake.commands

import edu.wpi.first.wpilibj.command.InstantCommand
import frc.team1984.robot.intake.Intake

class IntakeInCmd : InstantCommand(){
    override fun execute() { Intake.setOut = false }
}