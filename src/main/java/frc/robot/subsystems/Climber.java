// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import static frc.robot.Constants.DrivetrainConstants.*;

import edu.wpi.first.wpilibj.XboxController;


public class Climber extends SubsystemBase {
    
    //attributes
    //motor controller
     //private final WPI_TalonFX slaveClimberMotor = new WPI_TalonFX(RIGHT_CLIMBER);
     private final WPI_TalonFX masterClimberMotor = new WPI_TalonFX(LEFT_CLIMBER);
     private double motorDistance;
     
    
    //constructor
    public Climber(){
        //slaveClimberMotor.follow(masterClimberMotor);
        //slaveClimberMotor.setInverted(kMotorInvert);

        masterClimberMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, kPIDLoopIdxClimb, kTimeoutMsClimb);
    }



    //methods
    public void climbStop(XboxController xbox){
        masterClimberMotor.set(ControlMode.PercentOutput, 0);
    }

    public void climbExtend(XboxController xbox){
        masterClimberMotor.set(ControlMode.PercentOutput, -0.3);
    }

    public void climbRetract(XboxController xbox){
        masterClimberMotor.set(ControlMode.PercentOutput, 0.3);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}

