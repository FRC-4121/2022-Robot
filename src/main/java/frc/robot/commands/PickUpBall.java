// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Processor;

public class PickUpBall extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  //creating intake subsystem
  private final Intake mainIntake;
  private final Processor mainProcessor; //processor should run when intake runs

  //constructor
  public PickUpBall(Intake intake, Processor processor){
    mainIntake = intake;
    mainProcessor = processor;
    addRequirements(intake, processor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
      mainIntake.runIntake();
      mainProcessor.runProcessor();      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mainIntake.stopIntake();
    mainProcessor.stopProcessor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

