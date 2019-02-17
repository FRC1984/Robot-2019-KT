package frc.team1984.robot

import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.RobotController
import frc.team1984.lib.sensors.CurrentManager
import frc.team1984.lib.sensors.PressureSwitch

object RobotMap {

    //PWM
    const val INTAKE_MOTOR = 0
    const val INTAKE_MOTOR_2 = 1
    const val BELT_MOTOR = 2

    //Relay
    const val PRESSURE_SWITCH = 0

    //CAN
    const val LEFT_SRX_ID = 4
    const val LEFT_SPX_ID = 5
    const val RIGHT_SRX_ID = 2
    const val RIGHT_SPX_ID = 3

    //PCM
    const val HATCH_SOLENOID = 7

    const val INTAKE_SOLENOID = 1

    const val SHIFTER_SOLENOID = 2
    }