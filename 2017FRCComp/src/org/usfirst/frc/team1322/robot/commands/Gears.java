package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Gears extends Command {

    public Gears() {
        requires(Robot.GearSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.GearSubsystem.close();
    	SmartDashboard.putDouble("Left Door ANgle", 0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.oi.AuxStick.refresh();
    	boolean open = Robot.oi.AuxStick.Buttons.RB.current;
    	boolean close = Robot.oi.AuxStick.Buttons.LB.current;
    	Robot.GearSubsystem.run(open, close);
    	//Robot.GearSubsystem.setup(180);
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
