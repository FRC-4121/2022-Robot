//shooter subsystem -- motors that shoot the ball
//Francesco Canossi

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import static frc.robot.Constants.*;
import com.ctre.phoenix.motorcontrol.ControlMode;


public class Shooter extends SubsystemBase {
  //attributes; variables
  private WPI_TalonFX shooterMotor = new WPI_TalonFX(SHOOTER);
  
  /** Creates a new Shooter. */
  public Shooter(){
    //nothing here yet :>
  }


  //methods
  public void shooterStop(){
    shooterMotor.set(ControlMode.PercentOutput, 0);  
  }

  public void shooterRun(){
    shooterMotor.set(ControlMode.PercentOutput, -0.2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
