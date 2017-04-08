package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AC_TurnGyro extends Command {

    private double direction;
	private boolean reset;
	private double kP = .017;

	public AC_TurnGyro(double direction, boolean reset) {
    	requires(Robot.DriveSystem);
    	this.direction = direction;
    	this.reset = reset;
    }

	private double Error(){
		return (this.direction - Robot.gyro.getAngle());
	}
    // Called just before this Command runs the first time
    protected void initialize() {
    	if (reset) Robot.gyro.reset();
    	
    	Robot.DriveSystem.ArcadeDrive(0, kP*Math.abs(Error())>0.4?kP*Error():Math.abs(Error())/Error()*0.4);    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.DriveSystem.ArcadeDrive(0, Math.abs(Error())>0.4?kP*Error():Math.abs(Error())/Error()*0.4);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Error()) < 3;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.DriveSystem.ArcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
