// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.ExtraClasses.PIDControl;
import static frc.robot.Constants.DrivetrainConstants.*;

public class AutoTurn extends CommandBase {
 
   // Declare class variables
   double targetAngle;
   double startTime;
   double stopTime;
   double angleError;
   double angleCorrection;
   double motorOutput;
 
   PIDControl pidControl;

   private Timer timer = new Timer();
  
   private final Drivetrain drivetrain;
 
  /** Creates a new AutoTurn. */
  public AutoTurn(Drivetrain drive) {
    drivetrain = drive;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);

    //Set up PID control
    pidControl = new PIDControl(kP_Turn, kI_Turn, kD_Turn);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
