package frc.team1984.robot

import frc.team1984.lib.sensors.PressureSwitch

object RobotMap {

    //PWM
    const val INTAKE_MOTOR = 0
    const val INTAKE_MOTOR_2 = 1
    //Relay
    const val BELT_MOTOR = 0
    const val PRESSURE_SWITCH = 1

    //CAN
    const val LEFT_SRX_ID = 2
    const val LEFT_SPX_ID = 3
    const val RIGHT_SRX_ID = 4
    const val RIGHT_SPX_ID = 5

    //PCM
    const val HATCH_DOUBLE_A = 0
    const val HATCH_DOUBLE_B = 1

    const val INTAKE_DOUBLE_A = 2
    const val INTAKE_DOUBLE_B = 3

    const val SHIFTER_DOUBLE_A = 4
    const val SHIFTER_DOUBLE_B = 5

    val pressure = PressureSwitch(PRESSURE_SWITCH)

    }