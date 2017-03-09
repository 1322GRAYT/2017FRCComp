package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class AM_DriveForwardGear extends CommandGroup {

    public AM_DriveForwardGear() {
    	addSequential(new AC_DriveToPosition(8, true, -.75, 0));
    	addSequential(new AC_GearsAuton(true));
    	addSequential(new AC_Wait(5));
    	//addSequential(new AC_DriveAuton(1, 0.75, 0));
    	//addSequential(new AC_GearsAuton(true));
    }
}
