package frc.team1984.robot.catapult

import edu.wpi.first.wpilibj.command.Command

class IntakeRunCmd(val speedFun: () -> Double) : Command() {
    init {
        this.requires(Catapult)
        this.isInterruptible = true
    }

    override fun execute() = Catapult.intake(speedFun())

    override fun  isFinished() = false //If mode not teleop?

    override fun end() = Catapult.intake(0.0)
}