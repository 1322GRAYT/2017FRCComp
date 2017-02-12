package org.usfirst.frc.team1322.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1322.robot.RobotMap;

import com.ctre.CANTalon;

/**
 *
 */
public class WinchSubsystem extends Subsystem {

		private CANTalon CAN_WINCH;
		
		public WinchSubsystem(){
			
			CAN_WINCH = new CANTalon(RobotMap.CAN_WINCH);
			
		}
		public void run(boolean up,boolean down){
			if (up){
				CAN_WINCH.set(100);
			}else if (down){
				CAN_WINCH.set(-100);
			}else{
				stop();
			}
		}
		
		public void stop(){
			CAN_WINCH.set(0);
		}
		
		public void brake(boolean enable){
			CAN_WINCH.enableBrakeMode(enable);
		}

    public void initDefaultCommand() {
    
        setDefaultCommand(new Winch());
    }
}

