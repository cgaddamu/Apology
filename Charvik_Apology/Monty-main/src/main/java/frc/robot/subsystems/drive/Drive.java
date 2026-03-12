package frc.robot.subsystems.drive;

import java.util.function.DoubleSupplier;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.*;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.util.Units;

import edu.wpi.first.wpilibj.smartdashboard.Field2d;

import edu.wpi.first.wpilibj2.command.*;

public class Drive extends SubsystemBase {

  private final DrivetrainIO io;
  private final DrivetrainIOInputsAutoLogged inputs;

  private final Field2d field = new Field2d();

  private final DifferentialDriveOdometry odometry =
      new DifferentialDriveOdometry(
          new Rotation2d(),
          0,
          0,
          new Pose2d(0, 0, new Rotation2d()));

  public Drive(DrivetrainIO drivetrainIO) {
    io = drivetrainIO;
    inputs = new DrivetrainIOInputsAutoLogged();
  }

  public void arcadeDrive(double speed, double rotation) {

    double s = MathUtil.applyDeadband(speed, 0.2);
    double r = MathUtil.applyDeadband(rotation, 0.2);

    double leftOutput = (s + r) * DriveConstants.maxSpeed;
    double rightOutput = (s - r) * DriveConstants.maxSpeed;

    io.arcadeDrive(leftOutput, rightOutput);
  }

  public Command arcadeDrive(DoubleSupplier speedSupplier, DoubleSupplier rotationSupplier) {
    return new RunCommand(
        () ->
            arcadeDrive(
                speedSupplier.getAsDouble(),
                rotationSupplier.getAsDouble()),
        this);
  }

  @Override
  public void periodic() {

    Rotation2d newRotation =
        odometry.getPoseMeters()
            .getRotation()
            .plus(
                Rotation2d.fromRadians(
                    (inputs.leftVelocityMetersPerSecond
                            - inputs.rightVelocityMetersPerSecond)
                        * 0.020
                        / Units.inchesToMeters(26)));

    inputs.robotPose =
        odometry.update(
            newRotation,
            inputs.leftPositionMeters,
            inputs.rightPositionMeters);

    io.updateInputs(inputs);

    Logger.processInputs("Drivetrain", inputs);
    Logger.recordOutput("Drivetrain Pose", odometry.getPoseMeters());

    field.setRobotPose(odometry.getPoseMeters());
  }
}