package frc.robot;
import edu.wpi.first.wpilibj.Timer;
public class wait {
    static public boolean waiter(double step_start, double duration){

        return Timer.getMatchTime() < step_start+duration;
    }
}
