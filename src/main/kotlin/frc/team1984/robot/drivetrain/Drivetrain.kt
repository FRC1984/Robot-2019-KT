package frc.team1984.robot.drivetrain

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.SpeedControllerGroup
import edu.wpi.first.wpilibj.Talon
import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import frc.team1984.lib.oi.XboxMap
import frc.team1984.robot.OI
import frc.team1984.robot.RobotMap

object Drivetrain : Subsystem() {
    private val lT = Talon(RobotMap.LEFT_TALON_1)
    private val lT2 = Talon(RobotMap.LEFT_TALON_2)
    private val rT = Talon(RobotMap.RIGHT_TALON_1)
    private val rT2 = Talon(RobotMap.RIGHT_TALON_2)

    private var shifter = DoubleSolenoid(RobotMap.SHIFTER_DOUBLE_A, RobotMap.SHIFTER_DOUBLE_B)

    private val l = SpeedControllerGroup(lT, lT2)
    private val r = SpeedControllerGroup(rT, rT2)
    private val drive = DifferentialDrive(l, r)
/*    private val dtVals = DTVals(DriveConsts.WHEEL_RADIUS, DriveConsts.TICKS_PER_REV)

    val lEnc = JawaDriveEncoder(RobotMap.L_DRIVE_ENC_ID,
                                dtVals)

    val rEnc = JawaDriveEncoder(RobotMap.R_DRIVE_ENC_ID,
                                dtVals)*/

    init {
        reset()
    }

    override fun initDefaultCommand() {
        defaultCommand = ArcadeDriveCmd(
                {OI.Con1.getAxis(XboxMap.Axis.LEFT_Y)},
                {-OI.Con1.getAxis(XboxMap.Axis.RIGHT_X)})
    }

    fun reset() {
        stop()
        shiftHigh() //Maybe low?
    }

    fun curvatureDrive(xSpeed: Double, zRotation: Double, isQuickTurn: Boolean) {
        drive.curvatureDrive(xSpeed, zRotation, isQuickTurn)
    }

    fun arcadeDrive(xSpeed: Double, zRotation: Double) {
        drive.arcadeDrive(xSpeed, zRotation, false)
    }

    fun set(l: Double, r: Double) {
        this.l.set(l)
        this.r.set(r)
    }

    fun getAvgSpeed(): Double {
        //return (lEnc.getVel() + rEnc.getVel()) / 2
        return 0.0
    }

    fun stop() {
        drive.arcadeDrive(0.0, 0.0)
    }

    fun shiftHigh() {
        shifter.set(DoubleSolenoid.Value.kForward)
    }

    fun shiftLow() {
        shifter.set(DoubleSolenoid.Value.kReverse)
    }
}