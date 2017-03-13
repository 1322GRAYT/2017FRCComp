package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TC_Shooter extends Command {
    public TC_Shooter() {
    	requires(Robot.ShooterSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run

	protected void execute() {
    	Robot.oi.AuxStick.refresh();
    	if(Robot.oi.AuxStick.Triggers.Combined > 0.5){
    		Robot.ShooterSubsystem.ShootBalls();
    	}
    	else if (Robot.oi.AuxStick.Triggers.Combined < -0.5){
    		Robot.ShooterSubsystem.BackFeed();
    	}
    	else{
    		Robot.ShooterSubsystem.StopShooter();
    	}
    	
    	Robot.ShooterSubsystem.ballIntake(Robot.oi.AuxStick.DPad.Up,
    			Robot.oi.AuxStick.DPad.Down);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//TODO: Add end statements to all the commands
    	Robot.ShooterSubsystem.StopShooter();
    	Robot.ShooterSubsystem.ballIntake(false, false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
