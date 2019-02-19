package frc.team1984.robot

import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import frc.team1984.lib.oi.XboxMap
import frc.team1984.lib.sensors.PressureSwitch
import frc.team1984.robot.belt.Belt
import frc.team1984.robot.intake.Intake
import frc.team1984.robot.drivetrain.Drivetrain
import frc.team1984.robot.drumbrake.DrumBrake

class Robot : TimedRobot() {
    companion object {
        val driverStation: DriverStation = DriverStation.getInstance()
        val scheduler: Scheduler = Scheduler.getInstance()
        val pressure = PressureSwitch(RobotMap.COMPRESSOR_SPIKE, RobotMap.PRESSURE_SWITCH)
        private val subsystemList = listOf(Drivetrain, Intake, DrumBrake, Belt)
    }

    override fun robotInit() {
        OI
        subsystemList.forEach { SmartDashboard.putData(it) }
        pressure.isEnabled = true
        pressure.launch()
    }

    override fun robotPeriodic() {
        scheduler.run()
    }

    override fun autonomousInit() {
    }

    override fun autonomousPeriodic() {
    }

    override fun teleopInit() {
        pressure.isEnabled = true
        scheduler.removeAll()
    }

    override fun teleopPeriodic() { pressure.run() }

    override fun disabledInit() {
        pressure.isEnabled = false
    }

    override fun disabledPeriodic() {
    }

    override fun testInit() {
        pressure.isEnabled = true
    }

    override fun testPeriodic() {
        Intake.run(OI.Con1.getAxis(XboxMap.Axis.LEFT_Y), if (Intake.hasBall) OI.Con1.getAxis(XboxMap.Axis.RIGHT_Y) else 0.0)
    }
}
