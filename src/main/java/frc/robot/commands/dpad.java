package frc.robot.commands;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.GenericHID;
import frc.robot.Constants.IOWheel;
import frc.robot.Constants.JoystickCon;
import frc.robot.subsystem.UpperSub;

public class dpad extends Command{
    /**
 * Gets the dpad up value
 *
 * @return DPad up value
 */
private final GenericHID dpad = new GenericHID(JoystickCon.port);
public boolean getDPadUp() {
	int dPadValue = dpad.getPOV();
	var direction = 0;
	return (dPadValue == direction) || (dPadValue == (direction + 45) % 360)
			|| (dPadValue == (direction + 315) % 360);
}

/**
 * Gets the dpad down value
 *
 * @return DPad down value
 */
public boolean getDPadDown() {
	int dPadValue = dpad.getPOV();
	var direction = 180;
	return (dPadValue == direction) || (dPadValue == (direction + 45) % 360)
			|| (dPadValue == (direction + 315) % 360);
}

/**
 * Gets the dpad left value
 *
 * @return DPad left value
 */
public boolean getDPadLeft() {
	int dPadValue = dpad.getPOV();
	var direction = 270;
	return (dPadValue == direction) || (dPadValue == (direction + 45) % 360)
			|| (dPadValue == (direction + 315) % 360);
	
}

/**
 * Gets the dpad right value
 *
 * @return DPad right value
 */
public boolean getDPadRight() {
	int dPadValue = dpad.getPOV();
	var direction = 90;
	return (dPadValue == direction) || (dPadValue == (direction + 45) % 360)
			|| (dPadValue == (direction + 315) % 360);
}
    private final UpperSub subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public dpad(UpperSub subsystem) {
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
