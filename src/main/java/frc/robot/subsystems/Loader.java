//processor subsystem
//includes: intake
//Seth Anderson, Francesco Canossi

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class Loader extends SubsystemBase {
  
  //we have two motors facing each other but both running to feed in, so one of them must be in the oposite direction AKA negative.
  private WPI_TalonSRX loader = new WPI_TalonSRX(27);
  

  public Loader(){}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  // method to run tyhe motor for the processor wheels
  public void runProcessor()
  {
    loader.set(0.2);
    
  }
//method to stop the motor for the processor wheels
  public void stopProcessor()
  {
    loader.set(0);
    
  }
 


}
