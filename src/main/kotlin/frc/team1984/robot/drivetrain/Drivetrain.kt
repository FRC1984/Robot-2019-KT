package frc.team1984.robot.drivetrain

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.SpeedControllerGroup
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import frc.team1984.lib.Jawasystem
import frc.team1984.lib.motion.pid.JawaDriveEncoder
import frc.team1984.lib.oi.XboxMap
import frc.team1984.robot.OI
import frc.team1984.robot.RobotMap
import frc.team1984.robot.drivetrain.commands.ArcadeDriveCmd

object Drivetrain : Jawasystem() {

        private var lSRX = JawaDriveEncoder(RobotMap.LEFT_SRX_ID, DriveConsts.kDTVals)
        private var lSPX = WPI_VictorSPX(RobotMap.LEFT_SPX_ID)
        private var rSRX = JawaDriveEncoder(RobotMap.RIGHT_SRX_ID, DriveConsts.kDTVals)
        private var rSPX = WPI_VictorSPX(RobotMap.RIGHT_SPX_ID)

        private var shifter = DoubleSolenoid(RobotMap.SHIFTER_DOUBLE_A, RobotMap.SHIFTER_DOUBLE_B)

        private val l = SpeedControllerGroup(lSRX, lSPX)
        private val r = SpeedControllerGroup(rSRX, rSPX)
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
                { -OI.Con1.getAxis(XboxMap.Axis.LEFT_Y) },
                { -OI.Con1.getAxis(XboxMap.Axis.RIGHT_X) })
    }

    override fun reset() {
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
        return (lSRX.getVel() + rSRX.getVel()) / 2
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