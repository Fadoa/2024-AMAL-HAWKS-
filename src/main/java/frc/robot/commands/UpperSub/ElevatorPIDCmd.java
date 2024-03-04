/*package frc.robot.commands.UpperSub;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Constants.IOWheel;
import frc.robot.subsystem.UpperSub;

public class ElevatorPIDCmd extends Command{
    private final UpperSub upperSub;
    private final PIDController pidController;

    public ElevatorPIDCmd(UpperSub upperSub, double setpoint) {
        this.upperSub = upperSub;
        this.pidController = new PIDController(//
                IOWheel.kP, IOWheel.kI, IOWheel.kD);
        pidController.setSetpoint(setpoint);
        addRequirements(upperSub);
    }

    @Override
    public void initialize() {
        System.out.println("ElevatorPIDCmd started!");
        pidController.reset();
    }

    @Override
    public void execute() {
        double speed = pidController.calculate(UpperSub.getEncoderMeters());
        upperSub.move_arm(speed);;
    }

    @Override
    public void end(boolean interrupted) {
        UpperSub.setMotor(0);
        System.out.println("ElevatorPIDCmd ended!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}*/