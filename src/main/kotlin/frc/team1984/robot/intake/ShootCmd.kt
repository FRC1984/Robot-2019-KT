package frc.team1984.robot.intake

import edu.wpi.first.wpilibj.command.ConditionalCommand

class ChooseShootCmd : ConditionalCommand(ShootHigh(), ShootLowCmd()) {
    init {
        requires(Intake)
    }
    override fun condition(): Boolean {
        when(Intake.wants) {
            Intake.State.EJECTHIGH -> {
                return true
            }
            Intake.State.EJECTLOW -> {
                return false
            }
            else -> {
                this.cancel()
            }
        }
        return false
    }
}