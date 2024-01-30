package frc.robot.subsystem;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModuleState;
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
    DriveCon.encoderLFA_Reversed,
    DriveCon.Abs_encoder_LFDport,
    DriveCon.Abs_encoder_LFD_offset,
    DriveCon.Abs_encoder_LFAport_R);

    private final SwearveMod LB = new SwearveMod(
    DriveCon.LBDport,
    DriveCon.LBAport,
    DriveCon.encoderLBM_reversed,
    DriveCon.encoderLBA_Reversed,
    DriveCon.Abs_encoder_LBDport,
    DriveCon.Abs_encoder_LBD_offset,
    DriveCon.Abs_encoder_LBAport_R);

    private final SwearveMod RF = new SwearveMod(
    DriveCon.RFDport,
    DriveCon.RFAport,
    DriveCon.encoderRFM_reversed,
    DriveCon.encoderRFA_Reversed,
    DriveCon.Abs_encoder_RFDport,
    DriveCon.Abs_encoder_RFD_offset,
    DriveCon.Abs_encoder_RFAport_R);

    private final SwearveMod RB = new SwearveMod(
    DriveCon.RBDport,
    DriveCon.RBAport,
    DriveCon.encoderRBM_reversed,
    DriveCon.encoderRBA_Reversed,
    DriveCon.Abs_encoder_RBDport,
    DriveCon.Abs_encoder_RBD_offset,
    DriveCon.Abs_encoder_RBAport_R);

    private AHRS gyro = new AHRS(SPI.Port.kMXP);
    private final SwerveDriveOdometry odometer =  new SwerveDriveOdometry(DriveCon.drive_kinematics, getRotation2d(), null);

    public SwearveSub(){
        new Thread(() ->{
            try{
                Thread.sleep(1000);
                gyroReset();
            } catch(Exception e){
            }
        }).start();
    
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
        LB.setState(desiredStates[1]);
        RF.setState(desiredStates[2]);
        RB.setState(desiredStates[3]);
    }

    public void move(){

    }
}
