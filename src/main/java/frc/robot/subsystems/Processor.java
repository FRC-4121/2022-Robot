// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj.XboxController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import com.ctre.phoenix.motorcontrol.ControlMode;



public class Processor extends SubsystemBase {
  private WPI_TalonSRX intakeMain = new WPI_TalonSRX( INTAKE);

  public Processor(){

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void runIntake(XboxController xbox)
  {
      intakeMain.set(-0.6);
  }

  public void stopIntake(XboxController xbox)
  {
      intakeMain.set(0);
  }
}
