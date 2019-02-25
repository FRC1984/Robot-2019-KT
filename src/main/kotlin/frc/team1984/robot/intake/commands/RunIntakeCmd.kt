package frc.team1984.robot.intake.commands

import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard
import frc.team1984.robot.belt.Belt
import frc.team1984.robot.intake.Intake
import frc.team1984.robot.Robot

class RunIntakeCmd(private val fSpeed: Double, private val bSpeed: Double, private var b: Boolean = false) : Command("RunIntakeCmd") {
    init {
        this.requires(Intake)
        this.isInterruptible = true
    }

    override fun initialize() {
        if(!b) Robot.camServer.source = Robot.cam2
    }

    override fun execute() {
        Intake.run(fSpeed, bSpeed)
        if(Intake.hasBall) Shuffleboard.selectTab("Default")
    }

    override fun  isFinished() = if(b) Belt.ballAtBottom.get() else Intake.hasBall

    override fun end() {
        Robot.camServer.source = Robot.cam
        Intake.stop()
//        if(b) IntakeInCmd()
    }
}