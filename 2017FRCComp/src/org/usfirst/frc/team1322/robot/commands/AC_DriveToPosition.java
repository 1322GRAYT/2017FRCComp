package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AC_DriveToPosition extends Command {

	double DriveToPosition;
	boolean ResetPosition;
	double forwardPwr;
	double turnPwr;
	
	/****************************
	 * Constructor
	 * 
	 * @param driveToPosition In inches, type distance to travel
	 * @param resetPosition Reset encoder
	 * @param forwardPower How fast to travel forward
	 * @param turnPower How fast to turn
	 */
    public AC_DriveToPosition(double driveToPosition, boolean resetPosition, 
    							double forwardPower, double turnPower) {
    	requires(Robot.DriveSystem);
    	DriveToPosition = driveToPosition;
    	ResetPosition = resetPosition;
    	forwardPwr = forwardPower;
    	turnPwr = turnPower;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(ResetPosition){
    		Robot.DriveSystem.resetEncoder();
    	}
    	Robot.DriveSystem.setSafety(false);
    	Robot.DriveSystem.ArcadeDrive(forwardPwr, turnPwr);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//TODO Remove SmartDashboard Reference
    	SmartDashboard.putNumber("Encoder Value", Robot.DriveSystem.getScaledEncoderPosition());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (Math.abs(Robot.DriveSystem.getScaledEncoderPosition()) >= DriveToPosition);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.DriveSystem.ArcadeDrive(0,0);
    	Robot.DriveSystem.setSafety(true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
