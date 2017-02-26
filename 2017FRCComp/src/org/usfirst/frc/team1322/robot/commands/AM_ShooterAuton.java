package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AM_ShooterAuton extends CommandGroup {

    public AM_ShooterAuton() {
    	//Start Shooting
    	addSequential(new AC_Shooter(14));
    	//Stops After 14 seconds
    }
}
