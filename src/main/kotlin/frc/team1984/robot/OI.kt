package frc.team1984.robot

import edu.wpi.first.wpilibj.Compressor
import frc.team1984.lib.oi.JawaXboxController
import frc.team1984.lib.oi.XboxMap
import frc.team1984.lib.util.commandify
import frc.team1984.robot.belt.commands.BeltCmd
import frc.team1984.robot.belt.commands.BeltShootCmd
import frc.team1984.robot.commandgroups.IntakeBall
import frc.team1984.robot.drivetrain.Drivetrain
import frc.team1984.robot.drumbrake.commands.DrumBrakeCmd
import frc.team1984.robot.intake.Intake
import frc.team1984.robot.intake.commands.IntakeInCmd
import frc.team1984.robot.intake.commands.IntakeOutCmd
import frc.team1984.robot.intake.commands.ManualIntakeCmd
//CONTROLS - Pay attention to Con1 vs Con2
object OI {
    val Con1 = JawaXboxController(0)
    val Con2 = JawaXboxController(1)

    init {
        //Driver 1
        //Shifting
        Con1.lbButton.whenPressed(commandify { Drivetrain.shiftLow() })
        Con1.rbButton.whenPressed(commandify { Drivetrain.shiftHigh() })
        Con1.aButton.whenPressed(IntakeOutCmd())
        Con1.lbButton.whenPressed(IntakeInCmd())
        Con1.bButton.toggleWhenPressed(DrumBrakeCmd())
        //Intake
        Con1.xButton.whenPressed(IntakeBall()) //Immediately after the ball has been intaked this will spit the ball either to go high or to go low

        Con2.xButton.whenPressed(commandify { Intake.wants = Intake.State.SHOOTLOW })
        Con2.bButton.whenPressed(commandify { Intake.wants = Intake.State.SHOOTHIGH })
        Con2.aButton.whenPressed(BeltShootCmd()) //Cmd for shooting - this will stop the intake

        //Manual
        Con2.lbButton.toggleWhenPressed(ManualIntakeCmd({Con2.getAxis(XboxMap.Axis.RT)}, {Con2.getAxis(XboxMap.Axis.LT)}))


        //DrumBrake
        Con1.aButton.toggleWhenPressed(DrumBrakeCmd())

    }
}