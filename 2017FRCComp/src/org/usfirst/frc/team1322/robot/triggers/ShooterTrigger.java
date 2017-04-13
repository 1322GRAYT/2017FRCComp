package org.usfirst.frc.team1322.robot.triggers;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class ShooterTrigger extends Trigger {

    public boolean get() {
    	return Robot.oi.AuxStick.getTriggerAxis(Hand.kRight) > 0.5 &&
    			!(Robot.oi.AuxStick.getTriggerAxis(Hand.kLeft) > 0.5);
    }
}
