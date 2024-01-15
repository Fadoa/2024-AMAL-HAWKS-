package frc.robot.commands;
import java.util.function.Supplier;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.DriveCon;
import frc.robot.Constants.JoystickCon;
import frc.robot.subsystem.SwearveSub;
public class SwerveJoystick extends Command{
    
    private final SwearveSub swervesub;
    private final Supplier<Double> xSpd, ySpd, AngleSpd;
    private final Supplier<Boolean> fieldBased;
    private final SlewRateLimiter xLimiter,yLimiter, ALimiter;
    
    public SwerveJoystick(SwearveSub swervesub, Supplier<Double> xSpd, Supplier<Double> ySpd,Supplier<Double> AngleSpd, Supplier<Boolean> fieldBased){
        this.swervesub = swervesub;
        this.xSpd = xSpd;
        this.ySpd = ySpd;   
        this.AngleSpd= AngleSpd;
        this.fieldBased = fieldBased;
        this.xLimiter = new SlewRateLimiter(DriveCon.Max_Accel_perS);
        this.yLimiter = new SlewRateLimiter(DriveCon.Max_Accel_perS);
        this.ALimiter = new SlewRateLimiter(DriveCon.Max_Accel_perS);
        addRequirements(swervesub);
    
    }


    @Override
    public void initialize() {
}


    @Override
    public void execute() {
            double xspeed = xSpd.get();
    double yspeed = ySpd.get();
    double ASpeed = AngleSpd.get();
    
    xspeed = Math.abs(xspeed) > JoystickCon.minimum ? xspeed : 0.0;
    yspeed = Math.abs(yspeed) > JoystickCon.minimum ? yspeed : 0.0;
    ASpeed = Math.abs(ASpeed) > JoystickCon.minimum ? ASpeed : 0.0;

    xspeed = xLimiter.calculate(xspeed) * DriveCon.MaxSpeed_Meters_per_S;
    yspeed = yLimiter.calculate(yspeed) * DriveCon.MaxSpeed_Meters_per_S;
    ASpeed = ALimiter.calculate(ASpeed) * DriveCon.MaxSpeed_Meters_per_S;   
    
    ChassisSpeeds chassisSpeeds;
        if(fieldBased.get()){
            chassisSpeeds = ChassisSpeeds.fromFieldRelativeSpeeds(xspeed, yspeed, ASpeed,swervesub.getRotation2d() );
        }else {
            chassisSpeeds = new ChassisSpeeds(xspeed, yspeed, ASpeed);
        }   
        

        SwerveModuleState[] moduleStates = DriveCon.drive_kinematics.toSwerveModuleStates(chassisSpeeds);

        swervesub.setModState(moduleStates);;
}

    @Override
    public void end(boolean interrupted) {
    
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
