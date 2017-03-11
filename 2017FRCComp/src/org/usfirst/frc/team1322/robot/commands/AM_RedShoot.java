package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AM_RedShoot extends CommandGroup {

    public AM_RedShoot() {
    	addSequential(new AC_Shooter(7));
    	addSequential(new AC_DriveAuton(1.5, 1.0, 0));
    	addSequential(new AC_DriveAuton(.75, 0, 1));
    	addSequential(new AC_DriveAuton(5, -.75, 0));
    }
}