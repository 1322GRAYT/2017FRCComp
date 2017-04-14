package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AM_RightGear extends CommandGroup {

    public AM_RightGear() {
    	addSequential(new AC_DriveToPosition(80, true, -.7, 0));
    	addSequential(new AC_TurnGyro(-45, true));
    	addSequential(new AC_DriveGyroTimed(1, -0.6));
    }
}
