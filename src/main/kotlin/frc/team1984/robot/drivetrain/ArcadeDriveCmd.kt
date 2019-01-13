package frc.team1984.robot.drivetrain

import edu.wpi.first.wpilibj.command.Command

class ArcadeDriveCmd(var xSpeed: Double, var xRotation: Double) : Command() {
    init {
        this.requires(Drivetrain)
        this.isInterruptible = true
    }

    override fun execute() = Drivetrain.arcadeDrive(xSpeed, xRotation)

    override fun isFinished() = false

    override fun end() = Drivetrain.stop()
}