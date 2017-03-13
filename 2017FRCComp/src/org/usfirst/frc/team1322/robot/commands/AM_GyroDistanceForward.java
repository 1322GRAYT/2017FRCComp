package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AM_GyroDistanceForward extends CommandGroup {

    public AM_GyroDistanceForward() {
    	addSequential(new AC_DriveGyroTimed(3.25, -0.6));
    }
}