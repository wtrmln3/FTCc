package org.firstinspires.ftc.teamcode.Commands;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import com.arcrobotics.ftclib.command.CommandBase;

import java.util.function.DoubleSupplier;

public class Drive extends CommandBase{
    private Drivetrain drive;
    private DoubleSupplier leftSupplier;
    private DoubleSupplier rightSupplier;

    public Drive(Drivetrain drive, DoubleSupplier leftSupplier, DoubleSupplier rightSupplier){
        this.drive = drive;
        this.leftSupplier = leftSupplier;
        this.rightSupplier = rightSupplier;

        addRequirements(drive);
    }

    @Override
    public void execute(){
        drive.tankDrive(leftSupplier.getAsDouble(), rightSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted){
        drive.stop();
    }

    public boolean isFinished(){
        return false;
    }
}
