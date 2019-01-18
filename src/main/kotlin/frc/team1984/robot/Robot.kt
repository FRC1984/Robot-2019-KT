package frc.team1984.robot

import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import frc.team1984.robot.catapult.Catapult
import frc.team1984.robot.drivetrain.Drivetrain
import frc.team1984.robot.drumbrake.DrumBrake

class Robot : TimedRobot() {
    companion object {
        // Sensors
        val gyro = ADXRS450_Gyro()
        private val cameraServer = CameraServer.getInstance()
        val pressureGauge = AnalogInput(1)

        val driverStation: DriverStation = DriverStation.getInstance()
        val scheduler: Scheduler = Scheduler.getInstance()
        val prefs: Preferences = Preferences.getInstance()
        private val subsystemList = listOf(Drivetrain, Catapult, DrumBrake)
    }

    override fun robotInit() {
        OI

        subsystemList.forEach { SmartDashboard.putData(it) }
    }

    override fun robotPeriodic() {
        scheduler.run()
    }

    override fun autonomousInit() {

    }

    override fun autonomousPeriodic() {

    }

    override fun teleopInit() {
        scheduler.removeAll()
    }

    override fun teleopPeriodic() {

    }

    override fun disabledInit() {

    }

    override fun disabledPeriodic() {

    }

    override fun testInit() {

    }

    override fun testPeriodic() {

    }
}
