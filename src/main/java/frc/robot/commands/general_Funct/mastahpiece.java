package frc.robot.commands.general_Funct;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Constants;
import frc.robot.Constants.IOWheel;
import frc.robot.subsystem.UpperSub;
public class mastahpiece {

    static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    static NetworkTableEntry ty = table.getEntry("ty");
    static double targetOffsetAngle_Vertical = ty.getDouble(0.0);

    // how many degrees back is your limelight rotated from perfectly vertical?
    static double limelightMountAngleDegrees = 25.0; 

    // distance from the center of the Limelight lens to the floor
    static double limelightLensHeightInches = 20.0; 

    // distance from the target to the floor
    static double goalHeightInches = 26.375; 

    static double angleToGoalDegrees = limelightMountAngleDegrees + targetOffsetAngle_Vertical;
    static double angleToGoalRadians = angleToGoalDegrees * (3.14159 / 180.0);

    //calculate distance
    
    public static double Meter(double goalHeightInches){
    double distanceFromLimelightToGoalInches = (goalHeightInches - limelightLensHeightInches) / Math.tan(angleToGoalRadians);
    double distanceFromLimelightToGoalMetres = Units.inchesToMeters(distanceFromLimelightToGoalInches);
    
        return distanceFromLimelightToGoalInches;
    }

    public static double AngleGiver(double targetHeight){
    double y = Units.inchesToMeters(targetHeight) - Constants.VisionConstants.robotheight;
    double x = Meter(targetHeight);
    double alpha = Math.atan(y/x);

    return alpha;

    }
    public static double AngleToMotor(double angle){
        double error = 0 + angle;
    
        double outputSpeed = error/ IOWheel.kP;
        
        if(outputSpeed == (89 / IOWheel.kP)){
            outputSpeed = 85/ IOWheel.kP;
        }
        return outputSpeed;

    }
}