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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RightClimber extends SubsystemBase {
    
    //attributes
    //motor controller
     private final WPI_TalonFX slaveClimberMotor = new WPI_TalonFX(RIGHT_CLIMBER);
     //private final WPI_TalonFX masterClimberMotor = new WPI_TalonFX(LEFT_CLIMBER);
     private double motorDistance;
     
    
    //constructor
    public RightClimber(){
        //slaveClimberMotor.follow(masterClimberMotor);
        slaveClimberMotor.setInverted(kMotorInvert);
        slaveClimberMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, kPIDLoopIdxClimb, kTimeoutMsClimb);
        //SmartDashboard.putNumber("RightClimbEncoder", 0);
        slaveClimberMotor.setSelectedSensorPosition(0);
    }



    //methods
    public void climbStop(XboxController xbox){
        slaveClimberMotor.set(ControlMode.PercentOutput, 0);
    }

    public void climbExtend(XboxController xbox){
        slaveClimberMotor.set(ControlMode.PercentOutput, -0.3);
        SmartDashboard.putNumber("RightClimbEncoder", slaveClimberMotor.getSelectedSensorPosition());
    }

    public void climbRetract(XboxController xbox){
        while(slaveClimberMotor.getSelectedSensorPosition() <= 0){ //  the more negative the value is, the higher the hook of the climber. 0 should be when it is at rest position and fully retracted. This line is to make sure that the value doesn't go higher than the starting position
            slaveClimberMotor.set(ControlMode.PercentOutput, 0.3);
            SmartDashboard.putNumber("RightClimbEncoder", slaveClimberMotor.getSelectedSensorPosition());
        }
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

