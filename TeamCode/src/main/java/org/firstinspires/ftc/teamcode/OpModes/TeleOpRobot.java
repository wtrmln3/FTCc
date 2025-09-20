/*package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Clutch;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.Lift;
import org.firstinspires.ftc.teamcode.Subsystems.TakeServos;

@TeleOp(name = "Panama", group = "TeleOp")

public class TeleOpRobot extends LinearOpMode {
    @Override
    public void runOpMode(){
        Drivetrain drivetrain = new Drivetrain(hardwareMap);
        Intake intake = new Intake(hardwareMap);
        Clutch clutch = new Clutch(hardwareMap);
        TakeServos takeServos = new TakeServos(hardwareMap);
        Lift lift = new Lift(hardwareMap);

        waitForStart();

        while (opModeIsActive()){
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;

            drivetrain.driveRobot(drive, turn);

            if(gamepad1.a){
                intake.forward();
            }else if(gamepad1.b){
                intake.backward();
            }else{
                intake.stop();
            }

            if(gamepad1.x){
                clutch.open();
            }else if(gamepad1.y){
                clutch.close();
            }

            if(gamepad1.right_bumper){
                lift.moveUp();
            }else if(gamepad1.left_bumper){
                lift.moveDown();
            }else{
                lift.stop();
            }

            if(gamepad1.dpad_up){
                takeServos.up();
            }else if(gamepad1.dpad_down){
                takeServos.down();
            }else{
                takeServos.stop();
            } //adad
        }
    }

}
*/