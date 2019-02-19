package frc.team1984.robot.intake.commands

import edu.wpi.first.wpilibj.command.Command

import frc.team1984.robot.intake.Intake

class IntakeInCmd : Command(){
    init {
        this.requires(Intake)
    }
    override fun execute() { Intake.solenoid.set(false) }
    override fun isFinished() = Intake.isIn
}