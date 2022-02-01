// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj.XboxController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Intake extends SubsystemBase {
  
  //motor to run the intake wheels
  private WPI_TalonSRX intakeMain = new WPI_TalonSRX( INTAKE);
  private WPI_TalonSRX intakeRelease = new WPI_TalonSRX(INTAKERELEASE);

  public Intake() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
// method to run tyhe motor for the intake wheels
  public void runIntake(XboxController xbox)
  {
      intakeMain.set(-0.6);
  }
//method to stop the motor for the intake wheels
  public void stopIntake(XboxController xbox)
  {
      intakeMain.set(0);
  }
 
  public void intakeRelease(XboxController xbox)
  {
      intakeRelease.set(0.1);
  }
  public void intakeReleaseStop(XboxController xbox)
  {
    intakeRelease.set(0);
  }

}
