package frc.team1984.robot.intake.commands

import edu.wpi.first.wpilibj.command.InstantCommand

import frc.team1984.robot.intake.Intake

class IntakeInCmd : InstantCommand(){
    init {
        this.isInterruptible = true
        this.requires(Intake)
    }
    override fun execute() { Intake.solenoid.set(false) }
    override fun end() {
        Intake.nextAction = Intake.NextAction.SHOOTLOW
    }
}