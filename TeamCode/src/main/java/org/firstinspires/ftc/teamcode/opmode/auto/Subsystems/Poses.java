package org.firstinspires.ftc.teamcode.opmode.auto.Subsystems;

import com.pedropathing.localization.Pose;

import java.util.HashMap;
import java.util.Map;

public class Poses {
    /*----------Poses----------*/
    public Map<String, Pose> bStartPos;
    public Map<String, Pose> rStartPos;

    public Map<String, Pose> Scorepos;

    public Map<String, Pose> yPickUpPos;
    public Map<String, Pose> brPickUpPos;

    public Map<String, Pose> HumanPlayerPos;

   public Poses(){

       //Start
       bStartPos = new HashMap<>();
       rStartPos = new HashMap<>();

       bStartPos.put("L",new Pose(10, 88, Math.toRadians(0)));
       bStartPos.put("M",new Pose(10, 72, Math.toRadians(0)));
       bStartPos.put("R", new Pose(10, 57, Math.toRadians(0)));

       rStartPos.put("L",new Pose(134, 57, Math.toRadians(180)));
       rStartPos.put("M",new Pose(134, 72, Math.toRadians(180)));
       rStartPos.put("R",new Pose(134, 88, Math.toRadians(180)));

       //Score
       Scorepos = new HashMap<>();

       Scorepos.put("blueB",new Pose(21,123, Math.toRadians(135)));
       Scorepos.put("blueP",new Pose(37,72, Math.toRadians(0)));

       Scorepos.put("redB",new Pose(123,21, Math.toRadians(135)));
       Scorepos.put("redP",new Pose(107,72, Math.toRadians(180)));

       //PickUp
       yPickUpPos = new HashMap<>();
       brPickUpPos = new HashMap<>();

       yPickUpPos.put("blueU",new Pose(45.25, 130, Math.toRadians(90)));
       yPickUpPos.put("blueM",new Pose(34, 132, Math.toRadians(0)));
       yPickUpPos.put("blueD",new Pose(34, 121, Math.toRadians(0)));

       yPickUpPos.put("redU",new Pose(111, 23, Math.toRadians(180)));
       yPickUpPos.put("redM",new Pose(111, 12, Math.toRadians(180)));
       yPickUpPos.put("redD",new Pose(98.4, 15, Math.toRadians(270)));

       brPickUpPos.put("blueU",new Pose(33, 23, Math.toRadians(0)));
       brPickUpPos.put("blueM",new Pose(33, 12, Math.toRadians(0)));
       brPickUpPos.put("blueD",new Pose(45.25, 15, Math.toRadians(270)));

       brPickUpPos.put("redU",new Pose(98.4, 130, Math.toRadians(90)));
       brPickUpPos.put("redM",new Pose(111, 132, Math.toRadians(180)));
       brPickUpPos.put("redD",new Pose(111, 121, Math.toRadians(180)));

       //Human player
       HumanPlayerPos = new HashMap<>();

       HumanPlayerPos.put("redPt",new Pose(24,12, Math.toRadians(180)));
       HumanPlayerPos.put("redPk", new Pose(134,96,Math.toRadians(0)));
       HumanPlayerPos.put("bluePt",new Pose(119,132, Math.toRadians(0)));
       HumanPlayerPos.put("bluePk", new Pose(10,48, Math.toRadians(180)));

   }
}
