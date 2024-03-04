package frc.robot.commands.UpperSub;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystem.UpperSub;

public class dpadup extends Command{


  private final UpperSub subsystem;
    public dpadup(UpperSub subsystem) {
    this.subsystem = subsystem;
      addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
System.out.println("dpad çalıştı!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {



      UpperSub.getInstance().move_arm(-0.025);
      SmartDashboard.putNumber("values", subsystem.getPosition());

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }

}
