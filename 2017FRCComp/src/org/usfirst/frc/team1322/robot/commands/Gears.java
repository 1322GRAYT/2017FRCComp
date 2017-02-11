package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Gears extends Command {

    public Gears() {
        requires(Robot.GearSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.GearSubsystem.close();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.oi.AuxStick.refresh();
    	boolean open = Robot.oi.AuxStick.Buttons.RB.changedDown;
    	boolean close = Robot.oi.AuxStick.Buttons.LB.changedDown;
    	Robot.GearSubsystem.run(open, close);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}