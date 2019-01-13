package frc.team1984.robot.consts

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import frc.team1984.robot.Robot
import frc.team1984.robot.drivetrain.DriveConsts

object Consts {

    const val K_DT = 0.02 // Seconds
    const val K_TIMEOUT_MS = 10
    const val INTAKE_MAX_SPEED = .6
    const val WRIST_DANGER_VAL = 0 // Force wrist closed - determine this value
    const val PF_PATH = "" //Path to PF CSV Files TODO: This

    //These will eventually be const or val, but we will need to test them so var for now

    //Arm Positions
    var armDown = 0.0
    var armSwitch = 0.0
    var armClimb = 0.0
    var armScale = 0.0

    //Wrist Positions
    var wristIn = 0.0
    var wristOut = 0.0
    var wristSwitch = 0.0
    var wristClimb = 0.0
    var wristScale = 0.0

    //TODO: Test PID
    var armP = 10.0
    var armI = 0.0
    var armD = 0.0

    var wristP = 10.0
    var wristI = 0.0
    var wristD = 0.0

    var cubeP = 10.0
    var cubeI = 0.0
    var cubeD = 0.0

    fun update() {
        DriveConsts.quickTurnThreshold = SmartDashboard.getNumber("Quick Turn Threshold", 0.2)
        armP = Robot.prefs.getDouble("Arm P", armP)
        armI = Robot.prefs.getDouble("Arm I", armI)
        armD = Robot.prefs.getDouble("Arm D", armD)

        wristP = Robot.prefs.getDouble("Wrist P", wristP)
        wristI = Robot.prefs.getDouble("Wrist I", wristI)
        wristD = Robot.prefs.getDouble("Wrist D", wristD)
    }
}