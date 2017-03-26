package org.usfirst.frc.team1322.robot.triggers;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class ShooterTrigger extends Trigger {

    public boolean get() {
        return Robot.oi.AuxStick.Triggers.Right > 0.5;
    }
}
