package frc.team1984.robot

import frc.team1984.lib.oi.JawaXboxController
import frc.team1984.lib.util.commandify
import frc.team1984.robot.intake.IntakeMoveCmd
import frc.team1984.robot.drivetrain.Drivetrain
import frc.team1984.robot.drumbrake.DrumBrakeCmd

object OI {
    val Con1 = JawaXboxController(0)
    val Con2 = JawaXboxController(1)

    init {
        //Driver 1
        //Shifting
        Con1.lbButton.whenPressed(commandify { Drivetrain.shiftLow() })
        Con1.rbButton.whenPressed(commandify { Drivetrain.shiftHigh() })

        //Intake
        Con1.bButton.toggleWhenPressed(IntakeMoveCmd())

        //DrumBrake
        Con1.aButton.toggleWhenPressed(DrumBrakeCmd())

        //Intake
        print("OI Initialized")
    }
}