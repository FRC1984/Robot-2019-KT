package frc.team1984.robot.belt.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.lib.oi.XboxMap
import frc.team1984.robot.OI
import frc.team1984.robot.belt.Belt
import frc.team1984.robot.belt.Belt.forward
import frc.team1984.robot.belt.Belt.reverse

class ManualBeltCmd : Command() {
    init {
        this.requires(Belt)
        this.isInterruptible = true
    }
    override fun execute() {
/*        if(OI.Con2.leftDPad.get() || ) {
            reverse()
        } else if(OI.Con2.rightDPad.get()) {
            forward()
        } else {
            Belt.stop()
        }*/

        Belt.run(OI.Con2.getAxis(XboxMap.Axis.LT) - OI.Con2.getAxis(XboxMap.Axis.RT))
    }

    override fun isFinished() = false
    override fun end() = Belt.stop()
}