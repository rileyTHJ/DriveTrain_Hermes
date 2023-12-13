// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Drive;
import frc.robot.Constants;

public class TeleopDrive extends CommandBase {
  /** Creates a new TeleopDrive. */
  private Drive S_Drive;
  private CommandXboxController DriveController;
  public TeleopDrive(Drive S_Drive, CommandXboxController DriveController) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.S_Drive = S_Drive;
    this.DriveController = DriveController;
    addRequirements(S_Drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double DriveSpeed = DriveController.getLeftY();
    double TurnSpeed = DriveController.getRightX();
    double RightDriveSpeed = (DriveSpeed + TurnSpeed) * Constants.SpeedModifier;
    double LeftDriveSpeed = (DriveSpeed - TurnSpeed) * .3 ;
    S_Drive.drive(RightDriveSpeed,LeftDriveSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
