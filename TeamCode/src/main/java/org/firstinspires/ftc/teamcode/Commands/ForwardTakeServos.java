package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.Subsystems.TakeServos;

    public class ForwardTakeServos extends CommandBase {
        private final TakeServos takeServos;
        private final double power;

        public ForwardTakeServos(TakeServos takeServos) {
            this.takeServos = takeServos;

            addRequirements(takeServos);
        }

        @Override
        public void initialize() {
            takeServos.forward();
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

