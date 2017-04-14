package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AM_RedShoot extends CommandGroup {

    public AM_RedShoot() {
    	addSequential(new BM_ShootBalls(), 8);
    	addSequential(new AC_DriveAuton(4, 1.0, 0));
    	addSequential(new AC_DriveAuton(5, -.75, 0));
    }
}
