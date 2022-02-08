// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Constants.*;

public class KillAutoCommand extends CommandBase {
  /** Creates a new KillAutoCommand. */
  public KillAutoCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
<<<<<<< HEAD

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(killAuto == false){
    killAuto = true;
    } else
    {
    killAuto = false;
    }
   //if kill button clicked execute
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
=======

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(killAuto == false){
      killAuto = true;
    } else
    {
      killAuto = false;
    }
     //if kill button clicked execute
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
>>>>>>> a57699f452e8005d9e4e4b784f3ec84fb3ff3cc5
  public boolean isFinished() {
    return true;
  }
}
