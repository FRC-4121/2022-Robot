//climber subsystem
//Seth Anderson, Francesco Canossi

package frc.robot.subsystems;

import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Climber extends SubsystemBase {
    
    //attributes
    //motor controller
     //private final WPI_TalonFX slaveClimberMotor = new WPI_TalonFX(RIGHT_CLIMBER);
     private final WPI_TalonFX masterClimberMotor = new WPI_TalonFX(LEFT_CLIMBER);
     private double motorDistance;
     
    
    //constructor
    public Climber(){
        //slaveClimberMotor.follow(masterClimberMotor);
        //slaveClimberMotor.setInverted(kMotorInvert);
        masterClimberMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, kPIDLoopIdxClimb, kTimeoutMsClimb);
        //SmartDashboard.putNumber("ClimbEncoder",0);
        masterClimberMotor.setSelectedSensorPosition(0);
    }

    //methods
    public void climbStop(XboxController xbox){
        masterClimberMotor.set(ControlMode.PercentOutput, 0);
    }

    public void climbExtend(XboxController xbox){
        masterClimberMotor.set(ControlMode.PercentOutput, -0.3);
        SmartDashboard.putNumber("ClimbEncoder", masterClimberMotor.getSelectedSensorPosition());
    }

    public void climbRetract(XboxController xbox){
      while(masterClimberMotor.getSelectedSensorPosition() <= 0) //  the more negative the value is, the higher the hook of the climber. 0 should be when it is at rest position and fully retracted. This line is to make sure that the value doesn't go higher than the starting position
      {
        masterClimberMotor.set(ControlMode.PercentOutput, 0.3);
        SmartDashboard.putNumber("ClimbEncoder", masterClimberMotor.getSelectedSensorPosition());
      }
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}

