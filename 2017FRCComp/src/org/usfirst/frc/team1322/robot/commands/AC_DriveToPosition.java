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
	double turnPower;
	
    public AC_DriveToPosition(double driveToPosition, boolean resetPosition, 
    							double speed, double turnpower) {
    	requires(Robot.DriveSystem);
    	DriveToPosition = driveToPosition;
    	ResetPosition = resetPosition;
    	forwardPwr = speed;
    	turnPower = turnpower;
    			
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(ResetPosition){
    		Robot.DriveSystem.resetEncoder();
    	}
    	//Robot.DriveSystem.setPID(1, 0, 0);
    	Robot.DriveSystem.setAutonMode();
    	Robot.DriveSystem.ArcadeDrive(forwardPwr, turnPower);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putInt("Encoder Value", Robot.DriveSystem.getEncoderPosition());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return (Robot.DriveSystem.getError() < 30);
    	return (Math.abs(Robot.DriveSystem.getEncoderPosition()) >= (DriveToPosition * 5800));
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
