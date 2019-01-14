package frc.team1984.robot

import frc.team1984.lib.oi.JawaXboxController
import frc.team1984.lib.util.commandify
import frc.team1984.robot.catapult.Catapult
import frc.team1984.robot.drivetrain.Drivetrain
import frc.team1984.robot.drumbrake.DrumBrake

object OI {
    val Con1 = JawaXboxController(0)
    val Con2 = JawaXboxController(1)

    init {
        //Driver 1
        //Shifting
        Con1.lbButton.whenPressed(commandify { Drivetrain.shiftLow() })
        Con1.rbButton.whenPressed(commandify { Drivetrain.shiftHigh() })

        //Catapult
        Con1.bButton.whenPressed(commandify { Catapult.launch = true }) //Setting launch to true toggles launch between true/false
        Con1.yButton.whenPressed(commandify { Catapult.safe = false }) //Setting safe to false toggles safe between true/false

        //DrumBrake
        Con1.xButton.whenPressed(commandify { DrumBrake.holding = false })
    }
}