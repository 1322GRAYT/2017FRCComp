package org.usfirst.frc.team1322.robot.commands;

import org.usfirst.frc.team1322.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class BM_GearControl extends InstantCommand {
	
	boolean Eject;

    public BM_GearControl(boolean Eject) {
        super();
        requires(Robot.GearSubsystem);
        this.Eject = Eject;
    }

    // Called once when the command executes
    protected void initialize() {
    	//Robot.GearSubsystem.run();
    	if(Eject){Robot.GearSubsystem.eject();}
    	else{Robot.GearSubsystem.close();}
    }

}
