// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RightClimber;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;

public class RightRetractClimber extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RightClimber m_climber;
  private XboxController xboxJoysticks;

   
  //constructor
  public RightRetractClimber(RightClimber subsystem, XboxController xbox) {
    m_climber = subsystem;
    xboxJoysticks=xbox;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      m_climber.climbRetract(xboxJoysticks);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted){
    m_climber.climbStop(xboxJoysticks);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
