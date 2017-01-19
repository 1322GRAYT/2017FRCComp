package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleopDriveSystem extends Command {

    public TeleopDriveSystem() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.DriveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.DriveSystem.Stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// @ TODO: When merged into main, add in joysticks
    	Robot.oi.DriverStick.refresh();
    	Robot.DriveSystem.ArcadeDrive(Robot.oi.DriverStick.LeftStick.Y,
    			Robot.oi.DriverStick.RightStick.X);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.DriveSystem.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
