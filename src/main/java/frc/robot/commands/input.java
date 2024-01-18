package frc.robot.commands;
import frc.robot.Constants.IOWheel;
import frc.robot.subsystem.İntakeSub;
import edu.wpi.first.wpilibj2.command.Command;

public class input extends Command {
  private final İntakeSub intakesub;
    private  boolean ending;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public input(İntakeSub subsystem) {
    intakesub = subsystem;
    
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("input başladi!!");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(ending = true){
        intakesub.setMotors(-IOWheel.outputSpd);
    }else {
        intakesub.setMotors(IOWheel.outputSpd);
    }
    
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakesub.setMotors(0);
    System.out.println("input bitti!!");
    ending = true;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(ending = true){
        return true;
    }else{
        return false;
    }
  }
}
