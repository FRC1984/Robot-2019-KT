package frc.team1984.robot.drivetrain

import frc.team1984.lib.motion.util.PIDVAVals
import frc.team1984.lib.motion.util.PIDVals

object DriveConsts {
    const val WHEEL_RADIUS = 3.0 / 12.0 // Inches
    const val TICKS_PER_REV = 4096 // CTRE MagEncoder Ticks/Rev

    const val kMaxVel = 10.0
    const val kMaxAccel = kMaxVel/2
    const val kMaxJerk = 120.0

    var quickTurnThreshold = 0.0 // Speed required for Curvature Quickturn to be false, Will eventually be const

    val kPIDVAPF = PIDVAVals(
            kP = 0.3,
            kI = 0.0,
            kD = 0.0,
            kV = 1 / kMaxVel,
            kA = 0.0
    )

    val kPIDVals = PIDVals(
            kP = 0.3,
            kI = 0.0,
            kD = 0.0
    )
}