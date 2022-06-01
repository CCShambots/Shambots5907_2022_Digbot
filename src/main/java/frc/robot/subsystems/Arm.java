package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import static edu.wpi.first.wpilibj.DoubleSolenoid.*;
import static edu.wpi.first.wpilibj.PneumaticsModuleType.*;
import static frc.robot.Constants.Arm.*;

public class Arm extends SubsystemBase{

    private DoubleSolenoid armSolenoid = new DoubleSolenoid(Constants.COMPRESSOR_ID, CTREPCM, ARM_SOLENOID_FORWARD, ARM_SOLENOID_REVERSE);
    private DoubleSolenoid dumperSolenoid = new DoubleSolenoid(Constants.COMPRESSOR_ID, CTREPCM, DUMPER_SOLENOID_FORWARD, DUMPER_SOLENOID_REVERSE);

    public Arm() {
        armSolenoid.set(Value.kReverse);
        dumperSolenoid.set(Value.kForward);
    }

    public void actuateArm() {
        Value current = armSolenoid.get();
        if(current == Value.kForward) {
            current = Value.kReverse;
        } else {
            current = Value.kForward;
        }

        armSolenoid.set(current);
    }

    public void actuateDumper() {
        Value current = dumperSolenoid.get();
        if(current == Value.kForward) {
            current = Value.kReverse;
        } else {
            current = Value.kForward;
        }

        dumperSolenoid.set(current);
    }

    public void setArm(Value value) {armSolenoid.set(value);}

    public void setDumper(Value value) {dumperSolenoid.set(value);}
    
}
