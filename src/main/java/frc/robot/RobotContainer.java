
package frc.robot;

import static frc.robot.Constants.*;
////import static frc.robot.Constants.ShooterConstants.*;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
//import frc.robot.extraClasses.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;




public class RobotContainer {
  
  //Driver controllers
  private final XboxController xbox = new XboxController(XBOX_PORT);
  private final Joystick launchpad = new Joystick(3);
  

  //Subsystems
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Climber climber = new Climber();
  private final Shooter shooter = new Shooter();
  private final Processor processor = new Processor();






  //===COMMANDS===//

  //Driving Commands
  private final DriveWithJoysticks driveCommand = new DriveWithJoysticks(drivetrain, xbox);

  //Climbing Commands
  private final ExtendClimber extendClimberCommand = new ExtendClimber(climber);
  private final RetractClimber retractClimberCommand = new RetractClimber(climber);


  //Shooting Commands
  private final ShootBall shooterCommand = new ShootBall(shooter);

  //KillAuto Command
  private final KillAutoCommand killAutoObject = new KillAutoCommand();

  // Intake
  private final RunIntake intakeCommand = new RunIntake(intake);

  //Processor
  private final RunProcessor processorCommand = new RunProcessor(processor);







  //===BUTTONS===//


  //xboxButtons
  private final JoystickButton intakeButton = new JoystickButton(xbox, 1);
  private final JoystickButton climberExtendButton = new JoystickButton(xbox, xboxLeftBumber);
  private final JoystickButton climberRetractButton = new JoystickButton(xbox, xboxRightBumber);
  private final JoystickButton shooterButton = new JoystickButton(xbox, xboxXButton);
  private final JoystickButton processorButton = new JoystickButton(xbox, xboxAButton);
  
  //launchpad buttons/switches
  private final JoystickButton killAutoButton = new JoystickButton(launchpad,LaunchPadButton1);
  //Driving
  private final JoystickButton invertDirectionButton = new JoystickButton(xbox, 6);
  
  
  




  
  //===CONSTRUCTOR===//
  public RobotContainer() {
    
    //Configure default commands
    configureDefaultCommands();

    // Configure the button bindings
    configureButtonBindings();

  }






  //===METHODS,WHERE STUFF IS CONFIGURED===///


  //For subsystem default commands (driving, etc.)
  private void configureDefaultCommands(){

    //Drivetrain -> drive with xbox joysticks
    drivetrain.setDefaultCommand(driveCommand);
  }
  
  private void configureButtonBindings() {
    
    //intake
    intakeButton.whileHeld(intakeCommand);

    //climber
    climberExtendButton.whileHeld(extendClimberCommand);
    climberRetractButton.whileHeld(retractClimberCommand);

    //shooter
    shooterButton.whileHeld(shooterCommand);

    //kill auto
    killAutoButton.whenPressed(killAutoObject);
    killAutoButton.whenReleased(killAutoObject);

    //processor
    processorButton.whileHeld(processorCommand);

  }

  

  public Command getAutonomousCommand() {
    return new ExtendClimber(climber);
    // return new AutoGetAllBalls(drivetrain, pneumatics, process2, ntables, ballData, 2, 100);
    // return new AutoShootTimed(drivetrain, shooter, pneumatics, process2, turret, ntables, 60);
    // return new RunHoodToPos(turret, 240);
  }


 
}