package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class AM_DriveForwardGear extends CommandGroup {

    public AM_DriveForwardGear() {
    	//Passing Through Variables in this order: Time Out, Forward Power, Turn Power
    	addSequential(new AC_DriveAuton(5, 0.75, 0));
    	//Open Gears
    	addSequential(new AC_GearsAuton(true));
    }
}
