package org.usfirst.frc.team1322.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AM_DriveToWhite extends CommandGroup {

    public AM_DriveToWhite() {
        addSequential(new AC_DriveAuton(3, 100, -.25));
    }
}
