package frc.robot.subsystems.intake.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake.Intake;

public class RunIntake extends Command {

  private final Intake intakeSubsystem;
  private double motorSpeed;

  public RunIntake(Intake subsystem, double speedValue) {
    intakeSubsystem = subsystem;
    motorSpeed = speedValue;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    double appliedSpeed = motorSpeed;
    intakeSubsystem.setSpeed(appliedSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    double stopSpeed = 0;
    intakeSubsystem.setSpeed(stopSpeed);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}