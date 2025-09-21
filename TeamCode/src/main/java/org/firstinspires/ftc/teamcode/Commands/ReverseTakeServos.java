package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.Subsystems.TakeServos;

public class ReverseTakeServos extends CommandBase {
    private final TakeServos takeServos;
    private final double power;

    public ReverseTakeServos(TakeServos takeServos, double power) {
        this.takeServos = takeServos;
        this.power = power;

        addRequirements(takeServos);
    }

    @Override
    public void initialize() {
        takeServos.setPower(-power);
    }

    @Override
    public void end(boolean interrupted) {
        takeServos.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

