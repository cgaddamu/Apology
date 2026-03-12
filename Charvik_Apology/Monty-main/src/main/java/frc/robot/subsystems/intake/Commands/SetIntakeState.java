package frc.robot.subsystems.intake.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake.Intake;

public class SetIntakeState extends Command {

  private Intake subsystem;
  private boolean desiredState;

  public SetIntakeState(Intake intakeSubsystem, boolean newState) {
    subsystem = intakeSubsystem;
    desiredState = newState;
  }

  private void applyState(boolean value) {
    subsystem.setState(value);
  }

  @Override
  public void initialize() {
    applyState(desiredState);
  }

  @Override
  public void execute() {
    applyState(desiredState);
  }

  @Override
  public void end(boolean interrupted) {
    applyState(false);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}