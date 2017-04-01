package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class BM_GearControl extends InstantCommand {
	
	boolean Open;

    public BM_GearControl(boolean Open) {
        super();
        requires(Robot.GearSubsystem);
        this.Open = Open;
    }

    // Called once when the command executes
    protected void initialize() {
    	if (Open) Robot.GearSubsystem.open();
    	else Robot.GearSubsystem.close();
    }

}
