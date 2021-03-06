// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.ExtraClasses.NetworkTableQuerier;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoGroup extends SequentialCommandGroup {

  /** Creates a new AutoGroup1. */
  public AutoGroup(Intake intake, Shooter shoot, Drivetrain drive, NetworkTableQuerier table, Processor processor) {

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands( new DropIntake(intake), new ShootBall(shoot), new AutoPickUpBall(drive,intake,processor,table,0.01,3), new AutoDrive(drive,12, 0, -1, 3), new ShootBall(shoot)); // we need to add commands in this for evrerything we do in auto
    //to add:
    //drop intake, shoot ball, autodrive to ball, pickup ball. 
  
}
}