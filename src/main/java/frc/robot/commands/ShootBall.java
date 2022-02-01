// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Shooter;

public class ShootBall extends CommandBase {
  //attributes; variables
  private final Shooter shooter;
  private XboxController xbox;
  
  
  /** Creates a new ShootBall. */
  public ShootBall(Shooter subsystem, XboxController xboxJoysticks) {
    shooter = subsystem;
    xbox = xboxJoysticks;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    shooter.shooterRun();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted){
    shooter.shooterStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}