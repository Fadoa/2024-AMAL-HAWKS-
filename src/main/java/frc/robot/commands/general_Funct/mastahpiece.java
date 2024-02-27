package frc.robot.commands.general_Funct;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Constants;
public class mastahpiece {

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry ty = table.getEntry("ty");
    double targetOffsetAngle_Vertical = ty.getDouble(0.0);

    // how many degrees back is your limelight rotated from perfectly vertical?
    double limelightMountAngleDegrees = 25.0; 

    // distance from the center of the Limelight lens to the floor
    double limelightLensHeightInches = 20.0; 

    // distance from the target to the floor
    double goalHeightInches = 26.375; 

    double angleToGoalDegrees = limelightMountAngleDegrees + targetOffsetAngle_Vertical;
    double angleToGoalRadians = angleToGoalDegrees * (3.14159 / 180.0);

    //calculate distance
    
    public double Meter(double goalHeightInches){
    double distanceFromLimelightToGoalInches = (goalHeightInches - limelightLensHeightInches) / Math.tan(angleToGoalRadians);
    double distanceFromLimelightToGoalMetres = Units.inchesToMeters(distanceFromLimelightToGoalInches);
    
        return distanceFromLimelightToGoalMetres;
    }

    public double AngleGiver(double targetHeight){
    double y = targetHeight - Constants.VisionConstants.robotheight;
    double x = Meter(targetHeight);
    double alpha = Math.atan(y/x);

    return alpha;

    }

}