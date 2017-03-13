package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AM_VisionTest extends CommandGroup {

    public AM_VisionTest() {
    	addSequential(new AC_GetDistanceFromVision());
    }
}
