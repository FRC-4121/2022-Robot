
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
import frc.robot.ExtraClasses.Ballistics;




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
  private final KillAutoCommand killAutoObject = new KillAutoCommand(); //

  // Intake
  private final RunIntake intakeCommand = new RunIntake(intake);

  //Processor
  private final RunProcessor processorCommand = new RunProcessor(processor);

  //loader
  private final RunLoader runloader = new RunLoader(processor);





  //===BUTTONS===// //They're being identified in RobotContainer

  boolean testing = true; //change this depending on which u want





  //xboxButtons
  private final JoystickButton intakeButton;
  private final JoystickButton climberExtendButton;
  private final JoystickButton climberRetractButton;
  private final JoystickButton shooterButton;
  private final JoystickButton processorButton;
  
  //launchpad buttons/switches
  private final JoystickButton killAutoButton;
  private final JoystickButton AutoPos1;
  private final JoystickButton AutoPos2;
  private final JoystickButton AutoPos3;

  //Driving
  private final JoystickButton invertDirectionButton;
  private final JoystickButton loaderButton;

  //Ballistics
  private final double distance = 50;//in this is temporary value, use getDistance to Goal or something with sensor.
  /*
     *  targetH: The height, in inches, of the desired target above the ground
     *  launchH: The height, in inches, of the launcher release point above the ground
     *  tolerance: A additive factor, in inches, that widens the range to target around the target height 
     *  maxRPM: The maximum speed, in rotations per minute, of the flywheel
     *  wheelD: The diameter, in inches, of the flywheel
     *  slip: The percent of wheel speed that is converted to linear speed of the missile (due to the single-wheel design, much is lost as rotational speed)
     */
  //                     Parameters: target height(~50in and ~110in), launch height(~40in), tolerance (idk~20in), maxRPM(idk needs testing), wheel diameter (~5.8 in), slip(~.1), 
  public final Ballistics ballisticLow = new Ballistics(50,40,20,5050,5.8,.1); 
  public final Ballistics ballisticHigh = new Ballistics(110,40,20,5050,5.8,.1); 
  public final double[] tableQueryLow = ballisticLow.queryBallisticsTable(distance);
  public final double[] tableQueryHigh = ballisticHigh.queryBallisticsTable(distance);
  //===CONSTRUCTOR===//
  public RobotContainer() {
    
  if(testing) //using xbox controller to test
  {
    //xboxButtons
    intakeButton = new JoystickButton(xbox, xboxAButton);
    climberExtendButton = new JoystickButton(xbox, xboxLeftBumber);
    climberRetractButton = new JoystickButton(xbox, xboxRightBumber);
    shooterButton = new JoystickButton(xbox, xboxXButton);
    processorButton = new JoystickButton(xbox, xboxAButton);
    
    //Driving
     invertDirectionButton = new JoystickButton(xbox, 6);
     
     //loader
     loaderButton = new JoystickButton(xbox, 4);
  }
  else{ //using launchpad and xbox as if it's a real match
     intakeButton = new JoystickButton(launchpad, 1);
     climberExtendButton = new JoystickButton(launchpad, 1);
     climberRetractButton = new JoystickButton(launchpad, 1); //FIX THE PARAMTERS DON't LET THEM BE 1
     shooterButton = new JoystickButton(launchpad, 1);
     processorButton = new JoystickButton(launchpad, 1); 

    //Driving
     invertDirectionButton = new JoystickButton(xbox, 6);
     //loader 
     loaderButton = new JoystickButton(xbox, 4);

  }

    //launchpad buttons/switches
    killAutoButton = new JoystickButton(launchpad,LaunchPadButton1);
    AutoPos1 = new JoystickButton(launchpad,LaunchPadDial1);
    AutoPos2 = new JoystickButton(launchpad,LaunchPadDial2);
    AutoPos3 = new JoystickButton(launchpad,LaunchPadDial3);

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
    if(testing){
    //intake
    intakeButton.whileHeld(intakeCommand);

    //climber
    climberExtendButton.whileHeld(extendClimberCommand);
    climberRetractButton.whileHeld(retractClimberCommand);

    //shooter
    shooterButton.whileHeld(shooterCommand);

    //kill auto

    killAutoButton.whenPressed( killAutoObject);
    killAutoButton.whenReleased( killAutoObject);

    //processor
    processorButton.whileHeld(processorCommand);
    //loader
    loaderButton.whileHeld(runloader);

    }


    
    else{ //if not in test mode, change these values. 
      //intake
    intakeButton.whileHeld(intakeCommand);

    //climber
    climberExtendButton.whileHeld(extendClimberCommand);
    climberRetractButton.whileHeld(retractClimberCommand);

    //shooter
    shooterButton.whileHeld(shooterCommand);

    //kill auto

    killAutoButton.whenPressed( killAutoObject);
    killAutoButton.whenReleased( killAutoObject);

    //processor
    processorButton.whileHeld(processorCommand);
    //loader
    loaderButton.whileHeld(runloader);

    }

  }

  

  public Command getAutonomousCommand() {
    return new ExtendClimber(climber);
    // return new AutoGetAllBalls(drivetrain, pneumatics, process2, ntables, ballData, 2, 100);
    // return new AutoShootTimed(drivetrain, shooter, pneumatics, process2, turret, ntables, 60);
    // return new RunHoodToPos(turret, 240);
  }


 
}