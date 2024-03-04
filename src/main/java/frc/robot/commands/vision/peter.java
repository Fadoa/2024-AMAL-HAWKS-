package frc.robot.commands.vision;

import java.io.File;
import java.sql.Driver;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.networktables.Subscriber;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.LimelightHelpers;
import frc.robot.commands.general_Funct.*;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import frc.robot.subsystem.UpperSub;
import frc.robot.subsystem.swervedrive.SwerveSubsystem;
public class peter extends Command{
  double id = 0;
  private final SwerveSubsystem drivebase = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(),
                                                                         "swerve/neo"));


    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("havari peter باللس ");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    id = LimelightHelpers.getFiducialID(getName());
    int idInt = (int)id;
        switch (idInt) {
          case 5:
            double angle = (mastahpiece.AngleGiver(Constants.VisionConstants.amptarget))/(UpperSub.ArmRatio);
            drivebase.drive(new ChassisSpeeds(0,0,LimelightSwerve.limelight_aim_proportional()));
            
            //bitmedi
            break;
          
          case 3:
          case 4:

          default:
            break;
        }
    
}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
System.out.println("یورولدم");    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
