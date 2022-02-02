/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

public final class Constants {
    //Talon SRX and FX IDs (must be unique, may range from 0+)
    //drivetrain motors
    public static final int LEFT_MASTER_F = 3;
    public static final int LEFT_SLAVE_F = 2;
    public static final int RIGHT_MASTER_F = 1;
    public static final int RIGHT_SLAVE_F = 4;

    //climber motors
    public static final int RIGHT_CLIMBER = 7;
    public static final int LEFT_CLIMBER = 6;
    
    //processor motors
    public static final int INTAKE=5;
    public static final int INTAKERELEASE = 99;
    public static final int FEEDER = 999;
    public static final int SHOOTER = 999;

    //Drive control port IDs
    public static final int XBOX_PORT = 0;

    //Xbox controller button IDS
    public static final int xboxAButton = 1;
    public static final int xboxBButton = 2;
    public static final int xboxXButton = 3;
    public static final int xboxYButton = 4;
    public static final int xboxLeftBumber = 5;
    public static final int xboxRightBumber = 6;

    //Climber
    public static final int kPIDLoopIdxClimb = 0;
    public static final int kTimeoutMsClimb = 20;
    public static final int maxHeight = -135000; //TBD encoder raw sensor units (2048 in one rotation) for max height that climber should go



    public static class DrivetrainConstants {

        public static final boolean kMotorInvert = true;//True -> right side motors are inverted
        public static final int kPIDLoopIdxDrive = 0;
        public static final int kTimeoutMsDrive = 20;
        public static final double kTalonFXPPR = 2048;
        public static final double kWheelDiameter = 6.0;
        public static final double kLowGearSpeedCap = 0.8;//In case full speed draws excessive power, these are an emergency measure
        public static final double kHighGearSpeedCap = 1.0;
        public static double kJoystickSpeedCorr = 0.55;
        public static final double kAutoDriveSpeed = .4;
        public static final double kAutoDriveSpeedMin = 0.25;
        public static final double kAutoShootDriveSpeed = 0.75;
        public static final double kAutoTurnSpeed = 0.5;
        // public static final double kLowGearRatio = 30.0;
        // public static final double kHighGearRatio = 70.0;
        public static final double kGearRatio = 7; 
        public static final double kTurnAngleTolerance = 0.001;
        public static final double kDriveDistanceTolerance = 10.0;
        public static final double AUTO_ENCODER_REVOLUTION_FACTOR = 14750.0;

        public static final double kP_Straight = 0.012;  //was 0.024
        public static final double kI_Straight = 0.0;
        public static final double kD_Straight = 0.0;
        public static final double kP_Turn = .002;//was .003
        public static final double kI_Turn = 0.0;
        public static final double kD_Turn = 0.001;//was 0.0004
        public static final double kP_DriveAngle = .003;//was .005
        public static final double kI_DriveAngle = 0.0;
        public static final double kD_DriveAngle = 0.0004;

        public static final double kAutoRightSpeedCorrection = 0.9;

        //Filtering (for gyro)
        public static final int FILTER_WINDOW_SIZE = 150;

        public static int DIRECTION_MULTIPLIER = 1;//Controls whether forward on joysticks is forward or backward on robot
        
        
    
    }
}