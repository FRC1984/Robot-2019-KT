package frc.team1984.robot.intake

import edu.wpi.first.wpilibj.command.InstantCommand

class IntakeInCmd : InstantCommand(){
    override fun execute() { Intake.setOut = false }
}