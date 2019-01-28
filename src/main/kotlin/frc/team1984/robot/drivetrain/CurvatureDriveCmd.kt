package frc.team1984.robot.drivetrain

import edu.wpi.first.wpilibj.command.Command

class CurvatureDriveCmd(var xSpeed: () -> Double, var xRotation: () -> Double) : Command() {
    init {
        this.requires(Drivetrain)
        this.isInterruptible = true
    }

    override fun execute() = Drivetrain.curvatureDrive(xSpeed(), xRotation(), true)

    override fun isFinished() = false

    override fun end() = Drivetrain.stop()
}