// Copyright (c) FIRST and other WPILib contributors.
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  TalonSRX FrontRightMotor = new TalonSRX(Constants.FrontRightMotor_ID);
  TalonSRX FrontLeftMotor = new TalonSRX(Constants.FrontLeftMotor_ID);
  TalonSRX BackRightMotor = new TalonSRX(Constants.BackRightMotor_ID);
  TalonSRX BackLeftMotor = new TalonSRX(Constants.BackLeftMotor_ID);

  public Drive() {}

  public void drive(double SpeedRight, double SpeedLeft)
  {
    FrontRightMotor.set(TalonSRXControlMode.PercentOutput, SpeedRight);
    FrontLeftMotor.set(TalonSRXControlMode.PercentOutput, -SpeedLeft);
    BackRightMotor.set(TalonSRXControlMode.PercentOutput, SpeedRight);
    BackLeftMotor.set(TalonSRXControlMode.PercentOutput, -SpeedLeft);
  }

  @Override
  public void periodic() {

  }
}
