package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BM_ShootBalls extends Command {

	private static final double rampTime = 1.5;
	Timer ShooterStartup;
	
    public BM_ShootBalls() {
    	requires(Robot.BallShooter);
    	requires(Robot.ShooterIntake);
    	ShooterStartup = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	ShooterStartup.reset();
    	ShooterStartup.start();
    	Robot.BallShooter.set(1.0);
    	Robot.BallShooter.openBallBlock(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (ShooterStartup.get() > rampTime){
    		Robot.ShooterIntake.set(0.27);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	ShooterStartup.stop();
		ShooterStartup.reset();
		Robot.ShooterIntake.set(0);
		Robot.BallShooter.set(0);
		Robot.BallShooter.openBallBlock(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    
}
