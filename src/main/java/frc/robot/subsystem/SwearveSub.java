package frc.robot.subsystem;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.util.Units;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveCon;


public class SwearveSub extends SubsystemBase{
    /* L = Left
     * R = Right
     * F = Front
     * B = Back
     * D = Drive
     * A = Angle
     */
    
private final SwearveMod LF = new SwearveMod(
    DriveCon.LFDport,
    DriveCon.LFAport,
    DriveCon.encoderLFM_reversed,
    DriveCon.encoderLFA_Reversed);

    private final SwearveMod LB = new SwearveMod(
    DriveCon.LBDport,
    DriveCon.LBAport,
    DriveCon.encoderLBM_reversed,
    DriveCon.encoderLBA_Reversed);

    private final SwearveMod RF = new SwearveMod(
    DriveCon.RFDport,
    DriveCon.RFAport,
    DriveCon.encoderRFM_reversed,
    DriveCon.encoderRFA_Reversed);

    private final SwearveMod RB = new SwearveMod(
    DriveCon.RBDport,
    DriveCon.RBAport,
    DriveCon.encoderRBM_reversed,
    DriveCon.encoderRBA_Reversed);

    private AHRS gyro = new AHRS(SPI.Port.kMXP);
    Pose2d pose = new Pose2d(0,0,new Rotation2d());
    SwerveDriveOdometry odometry = new SwerveDriveOdometry(
            DriveCon.drive_kinematics,
            getRotation2d(), // returns current gyro reading as a Rotation2d
            new SwerveModulePosition[]{new SwerveModulePosition(), new SwerveModulePosition(), new SwerveModulePosition(), new SwerveModulePosition()},
            // Front-Left, Front-Right, Back-Left, Back-Right
            new Pose2d(0,0,new Rotation2d()) // x=0, y=0, heading=0
        );
    public SwearveSub(){
        new Thread(() ->{
            try{
                Thread.sleep(1000);
                gyroReset();
            } catch(Exception e){
            }
        }).start();
    }
    public static SwearveSub getInstance(){
        SwearveSub instance = new SwearveSub();
        return instance;
    }
    public void drive(double XdistanceDrive, double YdistanceDrive, double DegreePerSecond){
    //14in X, 4in Y ve 30 derece for example
        ChassisSpeeds ChassisSpeeds =  new ChassisSpeeds(Units.inchesToMeters(XdistanceDrive),Units.inchesToMeters(YdistanceDrive),Units.degreesToRadians(DegreePerSecond));
        SwerveModuleState[] swerveModuleStates = DriveCon.drive_kinematics.toSwerveModuleStates(ChassisSpeeds);
        LF.setState(swerveModuleStates[0]);
         RF.setState(swerveModuleStates[1]);
        LB.setState(swerveModuleStates[2]);
        RB.setState(swerveModuleStates[3]);
    }
    public void circular_formation(double angle){
LF.angle_Reset();
RF.angle_Reset();
LB.angle_Reset();
RB.angle_Reset();

LF.set_angle(angle);
RF.set_angle(-angle);
LB.set_angle(angle);
RB.set_angle(-angle);
    }
    public void  angle_manipulation(double angle){
LF.set_angle(angle);
RF.set_angle(angle);
LB.set_angle(angle);
RB.set_angle(angle);
    }

    public SwerveModulePosition[] getCurrentSwerveModulePositions(){
        return new SwerveModulePosition[]{
        new SwerveModulePosition(LF.DriveM_pos(),LF.getAngle()),
        new SwerveModulePosition(RF.DriveM_pos(),RF.getAngle()),
        new SwerveModulePosition(LB.DriveM_pos(),LB.getAngle()),
        new SwerveModulePosition(RB.DriveM_pos(),RB.getAngle())
    };
}

    public boolean gyroReset(){
        gyro.reset();
        return true;
    }

    public double getGyro(){
        return Math.IEEEremainder(gyro.getAngle(), 360);
    }
    public Rotation2d getRotation2d(){
        return Rotation2d.fromDegrees(getGyro());
    }

    @Override
    public void periodic(){
        
        SmartDashboard.putNumber("Robot heading to ", getGyro());
        odometry.update(getRotation2d(), getCurrentSwerveModulePositions());
    }
    public void killMods(){
        LF.stop();
        LB.stop();
        RF.stop();
        RB.stop();
    }

    public void setModState(SwerveModuleState[] desiredStates){
        SwerveDriveKinematics.desaturateWheelSpeeds(desiredStates, DriveCon.MaxSpeed_Meters_per_S);
        LF.setState(desiredStates[0]);
        RF.setState(desiredStates[1]);
        LB.setState(desiredStates[2]);
        RB.setState(desiredStates[3]);
    }

    public void move(){

    }
}
