package frc.team1984.robot

import edu.wpi.first.cameraserver.CameraServer
import edu.wpi.first.networktables.NetworkTableInstance
import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import frc.team1984.lib.oi.XboxMap
import frc.team1984.robot.belt.Belt
import frc.team1984.robot.intake.Intake
import frc.team1984.robot.drivetrain.Drivetrain
import frc.team1984.robot.drumbrake.DrumBrake
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard

class Robot : TimedRobot() {
    companion object {
        val driverStation: DriverStation = DriverStation.getInstance()
        val scheduler: Scheduler = Scheduler.getInstance()
        val cam = CameraServer.getInstance().startAutomaticCapture()
        val cam2 = CameraServer.getInstance().startAutomaticCapture(1)
        val camServer = CameraServer.getInstance().server
        private val subsystemList = listOf(Drivetrain, Intake, DrumBrake, Belt)
    }

    override fun robotInit() {
        OI
        Shuffleboard
        cam.setExposureManual(0)
        cam2.setExposureManual(40)
        cam2.setResolution(300, 200)
        camServer.source = cam
        subsystemList.forEach { SmartDashboard.putData(it) }
    }

    override fun robotPeriodic() {
        scheduler.run()
        SmartDashboard.putBoolean("ShootHigh", Intake.nextAction == Intake.NextAction.SHOOTHIGH)
        SmartDashboard.putBoolean("Ball At Bottom?: ", Belt.ballAtBottom.get())
        SmartDashboard.putBoolean("Intake Has Ball?: ", Intake.hasBall)
    }

    override fun autonomousInit() {
    }

    override fun autonomousPeriodic() {
    }

    override fun teleopInit() {
        scheduler.removeAll()
    }

    override fun teleopPeriodic() {
        camServer.source = if(OI.Con1.getAxis(XboxMap.Axis.LT) > 0.1) cam2 else cam
    }


    override fun disabledInit() { }

    override fun disabledPeriodic() {
        SmartDashboard.putBoolean("Ball At Bottom?: ", Belt.ballAtBottom.get())
        SmartDashboard.putBoolean("Intake Has Ball?: ", Intake.hasBall)
    }

    override fun testInit() { }

    override fun testPeriodic() {
        Intake.run(OI.Con1.getAxis(XboxMap.Axis.LEFT_Y), if (Intake.hasBall) OI.Con1.getAxis(XboxMap.Axis.RIGHT_Y) else 0.0)
    }
}
