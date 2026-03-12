package frc.robot.subsystems.drive;

import java.lang.Cloneable;
import java.lang.Override;
import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public class DrivetrainIOInputsAutoLogged extends DrivetrainIO.DrivetrainIOInputs implements LoggableInputs, Cloneable {
  @Override
  public void toLog(LogTable table) {
    table.put("RobotPose", robotPose);
    table.put("LeftOutputVolts", leftOutputVolts);
    table.put("RightOutputVolts", rightOutputVolts);
    table.put("LeftVelocityMetersPerSecond", leftVelocityMetersPerSecond);
    table.put("RightVelocityMetersPerSecond", rightVelocityMetersPerSecond);
    table.put("LeftPositionMeters", leftPositionMeters);
    table.put("RightPositionMeters", rightPositionMeters);
    table.put("LeftCurrentAmps", leftCurrentAmps);
    table.put("RightCurrentAmps", rightCurrentAmps);
  }

  @Override
  public void fromLog(LogTable table) {
    robotPose = table.get("RobotPose", robotPose);
    leftOutputVolts = table.get("LeftOutputVolts", leftOutputVolts);
    rightOutputVolts = table.get("RightOutputVolts", rightOutputVolts);
    leftVelocityMetersPerSecond = table.get("LeftVelocityMetersPerSecond", leftVelocityMetersPerSecond);
    rightVelocityMetersPerSecond = table.get("RightVelocityMetersPerSecond", rightVelocityMetersPerSecond);
    leftPositionMeters = table.get("LeftPositionMeters", leftPositionMeters);
    rightPositionMeters = table.get("RightPositionMeters", rightPositionMeters);
    leftCurrentAmps = table.get("LeftCurrentAmps", leftCurrentAmps);
    rightCurrentAmps = table.get("RightCurrentAmps", rightCurrentAmps);
  }

  public DrivetrainIOInputsAutoLogged clone() {
    DrivetrainIOInputsAutoLogged copy = new DrivetrainIOInputsAutoLogged();
    copy.robotPose = this.robotPose;
    copy.leftOutputVolts = this.leftOutputVolts;
    copy.rightOutputVolts = this.rightOutputVolts;
    copy.leftVelocityMetersPerSecond = this.leftVelocityMetersPerSecond;
    copy.rightVelocityMetersPerSecond = this.rightVelocityMetersPerSecond;
    copy.leftPositionMeters = this.leftPositionMeters;
    copy.rightPositionMeters = this.rightPositionMeters;
    copy.leftCurrentAmps = this.leftCurrentAmps.clone();
    copy.rightCurrentAmps = this.rightCurrentAmps.clone();
    return copy;
  }
}
