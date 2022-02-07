//processor subsystem
//includes: intake
//Seth Anderson, Francesco Canossi

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class Processor extends SubsystemBase {
  
  //we have two motors facing each other but both running to feed in, so one of them must be in the oposite direction AKA negative.
  private WPI_TalonSRX processor1 = new WPI_TalonSRX( FEEDER);
  private WPI_TalonSRX processor2 = new WPI_TalonSRX(-FEEDER);

  public Processor(){}

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
    processor1.set(-0.6);
    processor2.set(-0.6);
  }
//method to stop the motor for the processor wheels
  public void stopProcessor()
  {
    processor1.set(0);
    processor2.set(0);
  }
 


}
