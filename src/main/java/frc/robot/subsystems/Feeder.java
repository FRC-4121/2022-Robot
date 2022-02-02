//Feeder portion of processor
//Francesco Canossi

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; //importing both in the meantime until this gets actually built and we know what motors they are using


public class Feeder extends SubsystemBase {
  //attributes; variables
  private WPI_TalonFX feederMotor = new WPI_TalonFX(FEEDER); //potentially need a second motor
  
  
  /** Creates a new Feeder. */
  public Feeder(){
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
