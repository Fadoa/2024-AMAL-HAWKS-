package frc.robot;



import com.pathplanner.lib.util.PIDConstants;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;
public class Constants {


  public static final double ROBOT_MASS = 61; // 32lbs * kg per pound
  public static final Matter CHASSIS    = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8)), ROBOT_MASS);
  public static final double LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag

  public static final class AutonConstants
  {

    public static final PIDConstants TRANSLATION_PID = new PIDConstants(0.7, 0, 0);
    public static final PIDConstants ANGLE_PID   = new PIDConstants(0.4, 0, 0.01);
  }

  public static final class DrivebaseConstants
  {

    // Hold time on motor brakes when disabled
    public static final double WHEEL_LOCK_TIME = 10; // seconds
  }

  public static class OperatorConstants
  {

    // Joystick Deadband
    public static final double LEFT_X_DEADBAND  = 0.1;
    public static final double LEFT_Y_DEADBAND  = 0.1;
    public static final double RIGHT_X_DEADBAND = 0.1;
    public static final double TURN_CONSTANT    = 6;
  }

    public class IOWheel{
    public static final double kP = 2;
    public static final double SetPoint = 14;
    public static final int CPR = 20;
    public static final int outputSpd = 25;
    public static final int İnputID = 9;
    public static final int L_armID = 10;
    public static final int R_armID = 11;

    public static final int shooter_1ID = 12;
    public static final int shooter_2ID = 13;
    public static final int Aencoder = 5;

    public static final double Arm_Pos_Floor = 0.584;  // intaking
    public static final double Arm_Pos_Fender = 0.53;  // close shot
    public static final double Arm_Pos_Beginning = 0.376;  // start config
    public static final double Arm_Pos_Amp   = 0.325;  // amp scoring
    public static final double max_powah = 0.5;
    }
}

