package org.usfirst.frc.team1322.robot.triggers;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class BallIn extends Trigger {

    public boolean get() {
        return Robot.oi.AuxStick.getPOV(0) == 0;
    }
}
