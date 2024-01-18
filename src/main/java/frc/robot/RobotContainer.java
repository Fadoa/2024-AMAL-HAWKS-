package frc.robot;

import com.fasterxml.jackson.databind.util.PrimitiveArrayBuilder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystem.SwearveSub;
import frc.robot.subsystem.İntakeSub;
import frc.robot.Constants;
import frc.robot.Constants.JoystickCon;
import frc.robot.commands.SwerveJoystick;
import frc.robot.commands.input;
public class RobotContainer {

  private final SwearveSub swervesub = new SwearveSub();
  private final İntakeSub intakesub = new İntakeSub(9, false);
  private final input input = new input(intakesub);
  private final XboxController xboyJoy = new XboxController(JoystickCon.port); 
  public RobotContainer() {
  

    swervesub.setDefaultCommand(new SwerveJoystick(
      swervesub,
       ()-> -xboyJoy.getLeftY() ,
        ()-> xboyJoy.getLeftX(),
         ()-> xboyJoy.getRightX(),
          ()-> !xboyJoy.getAButton()));

    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(xboyJoy,1).onTrue(input);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}
