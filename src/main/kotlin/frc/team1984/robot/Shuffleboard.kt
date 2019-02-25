package frc.team1984.robot

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import frc.team1984.robot.belt.Belt
import frc.team1984.robot.intake.Intake
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object Shuffleboard {
    init {
        launch()
    }

    fun launch() = GlobalScope.launch {
/*        SmartDashboard.putBoolean("Ball At Top?: ", Belt.ballAtTop.get())
        SmartDashboard.putBoolean("Ball At Bottom?: ", Belt.ballAtBottom.get())
        SmartDashboard.putBoolean("Belt Stop Ball?: ", Belt.stopBall)
        SmartDashboard.putBoolean("Intake In?: ", Intake.isIn)
        SmartDashboard.putBoolean("Intake Has Ball?: ", Intake.hasBall)*/
    }
}