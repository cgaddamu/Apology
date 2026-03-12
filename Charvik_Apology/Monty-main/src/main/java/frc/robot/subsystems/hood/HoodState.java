package frc.robot.subsystems.hood;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.shooter.Shooter;

public class HoodState extends Command {

  private final Shooter shooter;

  public HoodState(Shooter shooterSubsystem) {
    shooter = shooterSubsystem;
  }

  @Override
  public void initialize() {
    boolean current = shooter.getHood();
    shooter.setHood(!current);
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}