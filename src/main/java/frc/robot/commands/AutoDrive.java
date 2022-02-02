package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
//import frc.robot.extraClasses.PIDControl;
import frc.robot.subsystems.Drivetrain;
public class AutoDrive extends Command {

    double driveAngle;  //drive angle
    double stopTime;  //timeout time
    double gyroAngle;
    double angleCorrection;
    double robotAngle;      //angle of the robot with respect to robot front
    double startTime;
    double speedMultiplier;
	
	//PIDControl pidControl;

	public Timer timer = new Timer();
	
	//Class constructor
    public AutoDrive(double ang, double orientAng, double time, double speed) {
    	
    	//requires(Robot.Drivetrain);//how does this work
    	
    	//Set local variables
        driveAngle = ang;
        robotAngle = orientAng;
        stopTime = time;
        speedMultiplier = speed;
    	    	
    	//Set up PID control
    	//pidControl = new PIDControl(RobotMap.kP_Straight, RobotMap.kI_Straight, RobotMap.kD_Straight);
    	
    }

    
    // Called just before this Command runs the first time
    protected void initialize() {
        
        if(stopTime != 0)
        {
            timer.start();
            startTime= timer.get();
        }

        angleCorrection = 0;
        
    }

    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        //write execute
        //Drop the intake system and run it
        //shoot ball
        //Move back fully outside of the initial region
        //Pick up a second ball, if you can't skip to third line
        //Move even further to assure the bot is fully outside the region
        //scoot closer to the goal and score in the lower goal
        //if there's time left keep rotating until you find another ball.

        //Plan to pick up second ball run AutoDriveToBall

    }

    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
        //Initialize return flag
    	boolean thereYet = false;
 
       //write a conditions to decide thereYet like master kill switch, or end of 15 seconds,etc.
        

        //Return flag
        return thereYet;
        
    }
    
    // Called once after isFinished returns true
    protected void end() {

        //Stop the robot
        
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
    
}