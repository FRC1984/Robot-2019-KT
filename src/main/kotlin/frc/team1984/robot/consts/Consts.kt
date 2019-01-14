package frc.team1984.robot.consts

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import frc.team1984.robot.Robot
import frc.team1984.robot.drivetrain.DriveConsts

object Consts {

    const val K_DT = 0.02 // Seconds
    const val K_TIMEOUT_MS = 10
    const val PF_PATH = "" //Path to PF CSV Files TODO: This

    //These will eventually be const or val, but we will need to test them so var for now


    fun update() {
        DriveConsts.quickTurnThreshold = SmartDashboard.getNumber("Quick Turn Threshold", 0.2)
        /*armP = Robot.prefs.getDouble("Arm P", armP)
        armI = Robot.prefs.getDouble("Arm I", armI)
        armD = Robot.prefs.getDouble("Arm D", armD)

        wristP = Robot.prefs.getDouble("Wrist P", wristP)
        wristI = Robot.prefs.getDouble("Wrist I", wristI)
        wristD = Robot.prefs.getDouble("Wrist D", wristD)*/
    }
}