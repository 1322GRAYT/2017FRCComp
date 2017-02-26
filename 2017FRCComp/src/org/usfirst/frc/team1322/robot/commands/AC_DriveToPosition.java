package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AC_DriveToPosition extends Command {

	double DriveToPosition;
	boolean ResetPosition;
	
    public AC_DriveToPosition(double driveToPosition, boolean resetPosition) {
    	requires(Robot.DriveSystem);
    	DriveToPosition = driveToPosition;
    	ResetPosition = resetPosition;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(ResetPosition){
    		Robot.DriveSystem.resetEncoder();
    	}
    	Robot.DriveSystem.setPID(1, 0, 0);
    	Robot.DriveSystem.setAutonMode();
    	Robot.DriveSystem.setPosition(DriveToPosition);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.DriveSystem.getError() < 30);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.DriveSystem.Stop();
    	Robot.DriveSystem.deactivateAutonMode();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
