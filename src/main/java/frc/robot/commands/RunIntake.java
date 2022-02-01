// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Intake;

public class RunIntake extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Intake mainIntake;
  private XboxController xboxJoysticks;


  public RunIntake(Intake intake, XboxController xbox){
    mainIntake = intake;
    xboxJoysticks = xbox;

    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
      mainIntake.runIntake(xboxJoysticks);      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mainIntake.stopIntake(xboxJoysticks);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

