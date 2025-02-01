package org.firstinspires.ftc.teamcode.opmode.auto.Subsystems;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.PathBuilder;
import com.pedropathing.pathgen.Point;

public class Functions {
    private Follower follower;

    public static String BLUE_Y = "blueY";
    public static String BLUE_B = "blueB";
    public static String RED_Y = "redY";
    public static String RED_R = "redR";

    public Poses pos = new Poses();

    Pose st;

    public Point conectorPonit(Pose start, Pose end, int numConect){
        Point conector = null;
        if(numConect == 1){
            conector = new Point(start.getY(), end.getX(),Point.CARTESIAN);
        } else if (numConect == 2){
            conector = new Point(end.getY(), start.getX(),Point.CARTESIAN);
        }
        return  conector;
    }

    public Path createPath(Pose start, Pose end, int numConect, boolean first){
        if (first){st =start;}

        Path path = null;
        switch (numConect) {
            case 0://Sin conectores
                path = new Path(
                        new BezierLine(
                                new Point(start),
                                new Point(end)
                        )
                );
                break;

            case 1://Un conector
                path = new Path(
                        new BezierCurve(
                                new Point(start),
                                conectorPonit(start, end, 1),
                                new Point(end)));
                break;
            case 2://Dos conectores
                path = new Path(
                        new BezierCurve(
                                new Point(start),
                                conectorPonit(start, end, 1),
                                conectorPonit(start, end, 2),
                                new Point(end)));
                break;
        }
        return path;  // Devuelves el path creado
    }//Crea un path según numConect(#conectores)

    /*public PathBuilder Chain(Pose start, Pose end, int ConectorPt) {
        return follower.pathBuilder()
                .addPath(createPath(start, end, ConectorPt))
                .setLinearHeadingInterpolation(start.getHeading(), end.getHeading());
    }*/

    public Pose getSt(){
        return st;
    }

    /*public double getX(PathChain chain){
        Path target = chain.getPath(2);
        Point point = target.getPoint(target.getPathEndTimeoutConstraint());
        return point.getX();
    }

    public double getY(PathChain chain){
        Path target = chain.getPath(2);
        Point point = target.getPoint(target.getPathEndTimeoutConstraint());
        return point.getY();
    }*/
}
