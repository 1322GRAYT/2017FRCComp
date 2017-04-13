package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AM_LeftGear extends CommandGroup {

    public AM_LeftGear() {
    	addSequential(new AC_DriveToPosition(40, true, -.7, 0));
    	addSequential(new AC_TurnGyro(45, true));
    	addSequential(new AC_DriveGyroTimed(3.25, -0.6));
    	addSequential(new BM_GearControl(true));
    	addSequential(new AC_DriveGyroTimed(1, 0.6));
    	addSequential(new BM_GearControl(false));
    }
}
