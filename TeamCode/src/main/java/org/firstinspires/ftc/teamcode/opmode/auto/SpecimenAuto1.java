package org.firstinspires.ftc.teamcode.opmode.auto;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.Point;
import com.pedropathing.util.Constants;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.common.commandbase.command.drive.FollowPathCommand;
import org.firstinspires.ftc.teamcode.opmode.auto.Subsystems.Functions;
import org.firstinspires.ftc.teamcode.opmode.auto.Subsystems.Paths;
import org.firstinspires.ftc.teamcode.opmode.auto.Subsystems.Poses;

import pedroPathing.constants.FConstants;
import pedroPathing.constants.LConstants;

@Autonomous
public class SpecimenAuto1 extends LinearOpMode {

    @Override
    public void runOpMode(){
        CommandScheduler.getInstance().reset();

        Telemetry telem = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        VoltageSensor vs = hardwareMap.voltageSensor.iterator().next();

        Constants.setConstants(FConstants.class, LConstants.class);
        Follower f = new Follower(hardwareMap);

        Pose start = new Pose(10,57,0);

        f.setPose(start);
        f.setMaxPower(0.75);

        double pivotVConstant = 13.4/vs.getVoltage();

        SequentialCommandGroup auto = new SequentialCommandGroup(
                new ParallelCommandGroup(
                    new FollowPathCommand(f, f.pathBuilder()
                        .addPath(
                                // Line 1
                                new BezierCurve(
                                        new Point(10.000, 57.000, Point.CARTESIAN),
                                        new Point(35.000, 57.000, Point.CARTESIAN),
                                        new Point(35.000, 72.000, Point.CARTESIAN)
                                )
                        )
                        .setConstantHeadingInterpolation(Math.toRadians(0))
                        .build()
                    ),
                    new ParallelCommandGroup(
                            new FollowPathCommand(f, f.pathBuilder()
                        .addPath(
                                // Line 2
                                new BezierLine(
                                        new Point(35.000, 72.000, Point.CARTESIAN),
                                        new Point(35.000, 35.000, Point.CARTESIAN)
                                )
                        )
                        .setConstantHeadingInterpolation(Math.toRadians(0))
                        .addPath(
                                // Line 3
                                new BezierLine(
                                        new Point(35.000, 35.000, Point.CARTESIAN),
                                        new Point(60.000, 35.000, Point.CARTESIAN)
                                )
                        )
                        .setTangentHeadingInterpolation()
                        .addPath(
                                // Line 4
                                new BezierLine(
                                        new Point(60.000, 35.000, Point.CARTESIAN),
                                        new Point(60.000, 23.000, Point.CARTESIAN)
                                )
                        )
                        .setConstantHeadingInterpolation(Math.toRadians(0))
                        .addPath(
                                // Line 5
                                new BezierLine(
                                        new Point(60.000, 23.000, Point.CARTESIAN),
                                        new Point(15.000, 23.000, Point.CARTESIAN)
                                )
                        )
                        .setConstantHeadingInterpolation(Math.toRadians(0))
                        .addPath(
                                // Line 6
                                new BezierLine(
                                        new Point(15.000, 23.000, Point.CARTESIAN),
                                        new Point(60.000, 23.000, Point.CARTESIAN)
                                )
                        )
                        .setConstantHeadingInterpolation(Math.toRadians(0))
                        .addPath(
                                // Line 7
                                new BezierLine(
                                        new Point(60.000, 23.000, Point.CARTESIAN),
                                        new Point(60.000, 13.000, Point.CARTESIAN)
                                )
                        )
                        .setConstantHeadingInterpolation(Math.toRadians(0))
                        .addPath(
                                // Line 8
                                new BezierLine(
                                        new Point(60.000, 13.000, Point.CARTESIAN),
                                        new Point(15.000, 13.000, Point.CARTESIAN)
                                )
                        )
                        .setConstantHeadingInterpolation(Math.toRadians(0))
                        .addPath(
                                // Line 9
                                new BezierLine(
                                        new Point(15.000, 13.000, Point.CARTESIAN),
                                        new Point(60.000, 13.000, Point.CARTESIAN)
                                )
                        )
                        .setConstantHeadingInterpolation(Math.toRadians(0))
                        .addPath(
                                // Line 10
                                new BezierLine(
                                        new Point(60.000, 13.000, Point.CARTESIAN),
                                        new Point(60.000, 9.000, Point.CARTESIAN)
                                )
                        )
                        .setConstantHeadingInterpolation(Math.toRadians(0))
                        .addPath(
                                // Line 11
                                new BezierLine(
                                        new Point(60.000, 9.000, Point.CARTESIAN),
                                        new Point(15.000, 9.000, Point.CARTESIAN)
                                )
                        )
                        .setConstantHeadingInterpolation(Math.toRadians(0))
                        .build()
                        )
                    )
                )
        );

        waitForStart();
        CommandScheduler.getInstance().schedule(auto);

        // OpMode loop
        while (opModeIsActive()) {
            f.setMaxPower(10.0 / vs.getVoltage());
            CommandScheduler.getInstance().run();
            f.update();
            f.telemetryDebug(telem);
        }

    }

}
