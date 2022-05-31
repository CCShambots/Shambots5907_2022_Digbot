package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import static edu.wpi.first.wpilibj.DoubleSolenoid.*;
import static edu.wpi.first.wpilibj.PneumaticsModuleType.*;
import static frc.robot.Constants.Arm.*;

public class Arm extends SubsystemBase{

    private DoubleSolenoid armSolenoid = new DoubleSolenoid(CTREPCM, ARM_SOLENOID_FORWARD, ARM_SOLENOID_REVERSE);
    private DoubleSolenoid dumperSolenoid = new DoubleSolenoid(CTREPCM, DUMPER_SOLENOID_FORWARD, DUMPER_SOLENOID_REVERSE);

    public Arm() {}

    public void actuateArm() {armSolenoid.toggle();}

    public void actuateDumper() {dumperSolenoid.toggle();}

    public void setArm(Value value) {armSolenoid.set(value);}

    public void setDumper(Value value) {dumperSolenoid.set(value);}
    
}
