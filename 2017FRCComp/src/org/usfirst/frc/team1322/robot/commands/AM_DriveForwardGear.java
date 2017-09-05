package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class AM_DriveForwardGear extends CommandGroup {

    public AM_DriveForwardGear() {
    	
    	addSequential(new AC_ShiftAuton(true));
    	addSequential(new AC_DriveToPosition(1, true, -.75, 0));
    	addSequential(new AC_ShiftAuton(false));
    	//addSequential(new AC_DriveAuton(1, 0.75, 0));
    	//addSequential(new AC_GearsAuton(true));
    }
}
