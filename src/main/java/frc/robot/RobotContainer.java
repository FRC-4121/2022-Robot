/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

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


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  
  //Driver controllers
  private final XboxController xbox = new XboxController(XBOX_PORT);
  
  

  //Subsystems
  private final Drivetrain drivetrain = new Drivetrain();
  private final Processor intake = new Processor();
  private final Climber climber = new Climber();
  private final RightClimber rightClimber = new RightClimber();
  private final Shooter shooter = new Shooter();


  //Commands
  //Driving
  private final DriveWithJoysticks driveCommand = new DriveWithJoysticks(drivetrain, xbox);

  //Climbing
  private final ExtendClimber extendClimberCommand = new ExtendClimber(climber, xbox);
  private final RetractClimber retractClimberCommand = new RetractClimber(climber, xbox);

  private final RightExtendClimber rightextendClimberCommand = new RightExtendClimber(rightClimber, xbox);
  private final RightRetractClimber rightretractClimberCommand = new RightRetractClimber(rightClimber, xbox);

  //Shooting
  private final ShootBall shooterCommand = new ShootBall(shooter, xbox);
  

  //Buttons
  private final JoystickButton intakeButton = new JoystickButton(xbox, 1);
  private final JoystickButton climberExtendButton = new JoystickButton(xbox, xboxLeftBumber);
  private final JoystickButton climberRetractButton = new JoystickButton(xbox, xboxRightBumber);
  private final JoystickButton rightclimberExtendButton = new JoystickButton(xbox, xboxBButton);
  private final JoystickButton rightclimberRetractButton = new JoystickButton(xbox, xboxYButton);
  private final JoystickButton shooterButton = new JoystickButton(xbox, xboxXButton);

  //Driving
  private final JoystickButton invertDirectionButton = new JoystickButton(xbox, 6);

  

  // Processor
  //private final RunIntake intakeCommand = new RunIntake(intake, xbox);
  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    
    //Configure default commands
    configureDefaultCommands();

    // Configure the button bindings
    configureButtonBindings();

  }

  //For subsystem default commands (driving, etc.)
  private void configureDefaultCommands(){

    //Drivetrain -> drive with xbox joysticks
    drivetrain.setDefaultCommand(driveCommand);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings(){
    
    //intake
    

    //climber
    climberExtendButton.whileHeld(extendClimberCommand);
    climberRetractButton.whileHeld(retractClimberCommand);
    rightclimberExtendButton.whileHeld(rightextendClimberCommand);
    rightclimberRetractButton.whileHeld(rightretractClimberCommand);

    //shooter
    shooterButton.whileHeld(shooterCommand);
  }

 /**
   * Use this to pass the autonomous command to the main {@link Robot} class. 
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new ExtendClimber(climber, xbox);
    // return new AutoGetAllBalls(drivetrain, pneumatics, process2, ntables, ballData, 2, 100);
    // return new AutoShootTimed(drivetrain, shooter, pneumatics, process2, turret, ntables, 60);
    // return new RunHoodToPos(turret, 240);
  }


 
}