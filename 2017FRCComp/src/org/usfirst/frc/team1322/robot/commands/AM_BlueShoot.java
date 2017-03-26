package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AM_BlueShoot extends CommandGroup {

    public AM_BlueShoot() {
    	addSequential(new BM_ShootBalls(), 9.0);
    	addSequential(new AC_DriveAuton(1.5, 1.0, 0));
    	addSequential(new AC_DriveAuton(5, -.75, 0));
    }
}
