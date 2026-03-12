package frc.robot;

import edu.wpi.first.math.util.Units;

public final class Constants {

  public static final class Drive {

    public static final int FL = 1;
    public static final int FR = 2;
    public static final int BL = 3;
    public static final int BR = 4;

    public static final double GEAR_RATIO = 34;
    public static final double MAX_RPM = 100;

    public static final double ROBOT_WIDTH_METERS = Units.inchesToMeters(15);

    public static final double DRIVE_LIMIT = 0.4;

    public Object arcadeDrive(Object object, Object object2) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'arcadeDrive'");
    }
  }

  public static final class Shooter {

    public static final int LEFT_LAUNCH = 21;
    public static final int RIGHT_LAUNCH = 22;
    public static final int FEEDER = 23;

    public static final int HOOD_SOLENOID = 15;

    public static final double FEED_LIMIT = 0.4;
    public static final double LAUNCH_LIMIT = 0.6;
  }

  public static final class Intake {

    public static final int ROLLER_MAIN = 11;
    public static final int INDEXER_LEFT = 12;
    public static final int INDEXER_RIGHT = 13;

    public static final int SOLENOID_CHANNEL = 7;

    public static final double INTAKE_LIMIT = 0.8;
  }

}