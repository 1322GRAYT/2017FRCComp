package org.usfirst.frc.team1322.robot.subsystems;

import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.TC_CameraControl;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class CameraSubsystem extends Subsystem {
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	NetworkTable table;
	private static final double[] defVal = {0,0};
	
	public CameraSubsystem(){
		table = NetworkTable.getTable(RobotMap.ContourReport);
	}
	
	public double[] getcenterX(){
		return table.getNumberArray("centerX", defVal);
	}
	
	public double[] getcenterY(){
		return table.getNumberArray("centerY", defVal);
	}
	
	public double[] getheight(){
		return table.getNumberArray("height", defVal);
	}
	
	public double[] getwidth(){
		return table.getNumberArray("width", defVal);
	}
	
	public double[] getarea(){
		return table.getNumberArray("area", defVal);
	}

    public void initDefaultCommand() {
        //set the default command for a subsystem here.
        setDefaultCommand(new TC_CameraControl());
    }
}

