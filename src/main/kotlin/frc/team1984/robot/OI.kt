package frc.team1984.robot

import frc.team1984.lib.oi.JawaXboxController
import frc.team1984.lib.util.commandify
import frc.team1984.robot.belt.commands.BeltCmd
import frc.team1984.robot.belt.commands.BeltShootCmd
import frc.team1984.robot.commandgroups.IntakeBall
import frc.team1984.robot.drivetrain.Drivetrain
import frc.team1984.robot.drumbrake.commands.DrumBrakeCmd
import frc.team1984.robot.intake.Intake

object OI {
    val Con1 = JawaXboxController(0)
    val Con2 = JawaXboxController(1)

    init {
        //Driver 1
        //Shifting
        Con1.lbButton.whenPressed(commandify { Drivetrain.shiftLow() })
        Con1.rbButton.whenPressed(commandify { Drivetrain.shiftHigh() })

        //Intake
        Con1.xButton.whenPressed(IntakeBall())

        Con2.xButton.whenPressed(commandify { Intake.wants = Intake.State.SHOOTLOW })
        Con2.bButton.whenPressed(commandify { Intake.wants = Intake.State.SHOOTHIGH })
        Con2.aButton.whenPressed(BeltCmd())
        Con2.aButton.whileHeld(BeltShootCmd())


        //DrumBrake
        Con1.aButton.toggleWhenPressed(DrumBrakeCmd())

    }
}