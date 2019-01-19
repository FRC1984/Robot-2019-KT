package frc.team1984.robot.catapult

import edu.wpi.first.wpilibj.command.Command

class CatapultOutCmd : Command() {
    init {
        this.requires(Catapult)
        this.isInterruptible = true
    }

    override fun execute() = Catapult.isOut(true)

    override fun isFinished() = false
    override fun end() = Catapult.isOut(false)
}