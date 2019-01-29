package frc.team1984.robot.intake.commands

import edu.wpi.first.wpilibj.command.InstantCommand
import frc.team1984.robot.intake.Intake

class IntakeOutCmd : InstantCommand() {
    override fun execute() { Intake.setOut = true }
}