package frc.robot.commands.UpperSub;

import frc.robot.Constants.IOWheel;
import frc.robot.subsystem.UpperSub;

import edu.wpi.first.wpilibj2.command.Command;

public class expel extends Command {
  private final UpperSub subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public expel(UpperSub subsystem) {
    this.subsystem = subsystem;
    
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("expel başladi!!!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    subsystem.shoot(IOWheel.max_powah);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
System.out.println("expel bitti!!!!");    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
