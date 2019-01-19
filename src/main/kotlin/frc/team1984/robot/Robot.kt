package frc.team1984.robot

import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import frc.team1984.robot.catapult.Intake
import frc.team1984.robot.drivetrain.Drivetrain

class Robot : TimedRobot() {
    companion object {
        val driverStation: DriverStation = DriverStation.getInstance()
        val scheduler: Scheduler = Scheduler.getInstance()
        private val subsystemList = listOf(Drivetrain, Intake)
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
        print("some gay shit")
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
