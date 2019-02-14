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

    private const val BROWNOUT_MAX_THRESHOLD = 11.0
    val pressure = PressureSwitch(PRESSURE_SWITCH)
    val pressureManager = CurrentManager({RobotController.getBatteryVoltage()}, BROWNOUT_MAX_THRESHOLD, 1500, pressure)


    }