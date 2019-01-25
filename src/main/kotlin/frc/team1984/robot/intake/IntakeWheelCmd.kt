package frc.team1984.robot.intake

import edu.wpi.first.wpilibj.command.Command

class IntakeWheelCmd(val speedFun: () -> Double) : Command() {
    init {
        this.requires(Intake)
        this.isInterruptible = true
    }

    override fun execute() = Intake.intake(speedFun())

    override fun  isFinished() = false //If mode not teleop?

    override fun end() = Intake.intake(0.0)
}