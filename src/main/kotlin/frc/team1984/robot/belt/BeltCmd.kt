package frc.team1984.robot.belt

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.belt.Belt.ballAtTop
import frc.team1984.robot.belt.Belt.forward
import frc.team1984.robot.belt.Belt.stop

class BeltCmd : Command("BeltCmd") {
    override fun execute() = forward()
    override fun isFinished(): Boolean = ballAtTop
    override fun end() = stop()
}