package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystem.UpperSub;

public class dpadup extends Command{
    public dpadup(UpperSub subsystem) {
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
      UpperSub.getInstance().move_arm(-2);
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