package org.usfirst.frc.team1322.robot.subsystems;

import java.util.concurrent.TimeUnit;
import org.usfirst.frc.team1322.robot.RobotMap;
import org.usfirst.frc.team1322.robot.commands.TC_Shooter;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
		
	Servo ballBlocker;
	CANTalon ballAgitator, ballAgitator2, ballShooter, ballShooter2, ballIntake;
	/**ANDREW ADJUST THESE**/
	double agitatorSpeed = .27;
	int shooterSpinUpTime = 1325;//Miliseconds
	/**DONT ADJUST ANYTHING MORE**/
	
	boolean enableShooterPLoop = false;
	
	public ShooterSubsystem(){
		ballBlocker = new Servo(RobotMap.ballBlocker);
		ballAgitator = new CANTalon(RobotMap.CAN_BALL_AGI);
		ballAgitator2 = new CANTalon(RobotMap.CAN_BALL_AGI2);
		setupAgitatorEncoder();
		//TODO: Create Similar P loop for Agitator as Like Shooter
		ballShooter = new CANTalon(RobotMap.CAN_SHT);	
		ballShooter2 = new CANTalon(RobotMap.CAN_SHOOT_2);
		if(enableShooterPLoop){
			setupShooterEncoder();
		}
		ballShooter2.reverseOutput(true);
		ballShooter2.reverseSensor(true);		
		ballIntake = new CANTalon(RobotMap.CAN_BALL_IT);
	}
	
	public void setupShooterEncoder(){
		/**Set Encoder Up for Shooter Motor **/
		ballShooter2.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		ballShooter2.changeControlMode(CANTalon.TalonControlMode.Speed);
		ballShooter2.setP(0);
		ballShooter2.setF(0);
		ballShooter.changeControlMode(CANTalon.TalonControlMode.Follower);
		ballShooter.set(RobotMap.CAN_SHOOT_2);
	
		SmartDashboard.putNumber("P Value", 0);
		SmartDashboard.putNumber("F Value", 0);
		SmartDashboard.putNumber("Set Value", 0);		
	}
	
	public void setupAgitatorEncoder(){
		/**Set Encoder Up for Agitator**/
		ballAgitator2.setFeedbackDevice(CANTalon.FeedbackDevice.AnalogPot);
	}
	
	public double getShooterSpeed(){
		return ballShooter2.getSpeed();
	}
	
	public double getAgiatorSpeed(){
		return ballAgitator2.getSpeed();
	}
	
	public void ShootBalls(){
		ballBlocker.setAngle(180);
		if(enableShooterPLoop){
			runShooterP();
		}else{
			runShooter(1);
		}
		
		
		try {TimeUnit.MILLISECONDS.sleep(shooterSpinUpTime);}
		catch (InterruptedException e) {e.printStackTrace();}
		
		runBallAgi(agitatorSpeed);
	}
	
	public void BackFeed(){
		runShooter(-0.5);
		runBallAgi(-.50);
	}
	
	public void StopShooter(){
		ballBlocker.setAngle(120);
		stopShooter();
		stopBallAgi();
	}
	
	public void ballIntake(boolean in, boolean out){
		if(in){
			ballIntake.set(-100);
		}else if(out){
			ballIntake.set(100);
		}else{
			ballIntake.set(0);
		}
	}
	
	private void runBallAgi(double power){
		ballAgitator.set(power);
		ballAgitator2.set(power);
	}
	
	private void runShooter(double power){
		ballShooter.set(power);
		ballShooter2.set(power);
	}
	
	private void runShooterP(){
		double pV = SmartDashboard.getNumber("P Value", 0);
		double fV = SmartDashboard.getNumber("F Value", 0);
		double sV = SmartDashboard.getNumber("Set Value", 0);
		ballShooter2.set(sV);
		ballShooter2.setP(pV);
		ballShooter2.setF(fV);
	}
	
	private void stopShooter(){
		ballShooter.set(0);
		ballShooter2.set(0);
	}
	
	private void stopBallAgi(){
		ballAgitator.set(0);
		ballAgitator2.set(0);
	}
	
    public void initDefaultCommand(){
    	setDefaultCommand(new TC_Shooter());
    }
}

