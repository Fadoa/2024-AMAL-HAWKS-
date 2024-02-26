
/* 
package frc.robot.autonomous;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.wait;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystem.SwearveSub;
import frc.robot.subsystem.UpperSub;
public class Two_point {
    public static double value = Timer.getMatchTime();
    public void Sendinfo(){
SmartDashboard.putNumber("start time", value);
    }

    void run(){
        SmartDashboard.putNumber("time", Timer.getMatchTime());
    if(wait.waiter(value ,2)){
UpperSub.getInstance().shoot(0.5);
UpperSub.getInstance().Arm_Pos_Beginning(0.545);
    }
    else if(wait.waiter(value, 4)){
UpperSub.getInstance().intake(1);
UpperSub.getInstance().shoot(0.5);
UpperSub.getInstance().Arm_Pos_Beginning(0.53);}

else if(wait.waiter(value, 5.5)){}
else if(wait.waiter(value, 7)){
NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
NetworkTableEntry tx = table.getEntry("tx");
NetworkTableEntry ty = table.getEntry("ty");


//read values periodically
double x = tx.getDouble(0.0);
double y = ty.getDouble(0.0);

double angle = -0.00008 * Math.pow(y,2) + .00252*y + .4992;
UpperSub.getInstance().Arm_Pos_Beginning(angle);

double Kp = 0.05;
SwearveSub.getInstance().drive(0, 0, Kp*x);
}

    }
    
    
}
*/