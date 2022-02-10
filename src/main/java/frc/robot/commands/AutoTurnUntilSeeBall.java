// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Drivetrain;
import frc.robot.ExtraClasses.NetworkTableQuerier;
import static frc.robot.Constants.*;


public class AutoTurnUntilSeeBall extends CommandBase {
   
  private NetworkTableQuerier ntables;
  private Drivetrain drivetrain = new Drivetrain();
  private double stopTime;

  /** Creates a new AutoTurnUntilSeeBall. */
  public AutoTurnUntilSeeBall(Drivetrain drive, NetworkTableQuerier table, double time) {
    
    drivetrain = drive;
    ntables = table;
    stopTime = time;
  
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

     // Get vision values
     double ballOffset = ntables.getVisionDouble("BallOffset0");
     double ballDistance = ntables.getVisionDouble("BallDistance0");
     boolean foundBall = ntables.getVisionBoolean("FoundBall");
  }

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
