package frc.robot;

import static frc.robot.Constants.Drive.*;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.subsystems.drive.*;
import frc.robot.subsystems.hood.HoodState;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.intake.Commands.*;
import frc.robot.subsystems.shooter.Shooter;
import frc.robot.subsystems.shooter.Commands.*;

public class RobotContainer {

  private CommandXboxController driver;
  private PneumaticHub pneumatics;

  private Drive drivetrain;
  private Intake intakeSystem;
  private Shooter shooterSystem;

  public RobotContainer(boolean realRobot) {

    driver = new CommandXboxController(0);
    pneumatics = new PneumaticHub(31);

    createSubsystems(realRobot);
    configureController();
  }

  private void createSubsystems(boolean real) {

    if (real) {
      drivetrain =
          new Drive(
              new DrivetrainIOReal(
                  FL,
                  FR,
                  BL,
                  BR));
    } else {
     
    }

    intakeSystem = new Intake(pneumatics);
    shooterSystem = new Shooter(pneumatics);
  }

  private void configureController() {

    drivetrain.setDefaultCommand(
        drivetrain.arcadeDrive(
            () -> -driver.getRightX(),
            () -> driver.getLeftY()));

    driver.x().whileTrue(new RunIntake(intakeSystem, 1));
    driver.b().toggleOnTrue(new SetIntakeState(intakeSystem, true));

    driver.rightTrigger(0.5).whileTrue(new RunFeed(shooterSystem, 1));
    driver.y().toggleOnTrue(new RunLaunch(shooterSystem, 1));

    driver.povUp().toggleOnTrue(new HoodState(shooterSystem));

    driver.leftBumper().whileTrue(new RunIntake(intakeSystem, -1));
    driver.leftBumper().whileTrue(new RunFeed(shooterSystem, -1));
  }

  public Command getAutonomousCommand() {
    Command auto = Commands.none();
    return auto;
  }
}