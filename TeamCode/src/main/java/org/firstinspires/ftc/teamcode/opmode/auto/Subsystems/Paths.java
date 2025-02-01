package org.firstinspires.ftc.teamcode.opmode.auto.Subsystems;

import android.annotation.SuppressLint;

import com.pedropathing.follower.Follower;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.PathBuilder;
import com.pedropathing.pathgen.PathChain;

import java.sql.Struct;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Paths {
    private Poses pos = new Poses();
    private Functions functions = new Functions();

    private Follower follower;

    /*----------PathChains----------*/
    // alianza - inicio - sector - secuencia
    public Queue<Path> basquet;


    @SuppressLint("SuspiciousIndentation")
    public Paths(){
        basquet = new LinkedList<Path>();
        basquet.add(functions.createPath(pos.bStartPos.get("M"), pos.brPickUpPos.get("blueU"), 2, true));
            basquet.add(functions.createPath(pos.brPickUpPos.get("blueU"), pos.HumanPlayerPos.get("bluePk"), 1, false));
            basquet.add(functions.createPath(pos.HumanPlayerPos.get("bluePk"), pos.HumanPlayerPos.get("bluePt"), 1, false));
        basquet.add(functions.createPath(pos.HumanPlayerPos.get("bluePt"), pos.Scorepos.get("blueP"), 0, false));
        basquet.add(functions.createPath(pos.Scorepos.get("blueP"), pos.brPickUpPos.get("blueM"), 1, false));
        basquet.add(functions.createPath(pos.brPickUpPos.get("blueM"), pos.HumanPlayerPos.get("bluePt"), 1, false));
        basquet.add(functions.createPath(pos.HumanPlayerPos.get("bluePt"), pos.HumanPlayerPos.get("bluePk"), 1, false));
        basquet.add(functions.createPath(pos.HumanPlayerPos.get("bluePk"), pos.Scorepos.get("blueP"), 0, false));
        basquet.add(functions.createPath(pos.Scorepos.get("blueP"), pos.brPickUpPos.get("blueDw "), 1, false));
        basquet.add(functions.createPath(pos.brPickUpPos.get("blueDw"), pos.HumanPlayerPos.get("bluePt"), 1, false));
        basquet.add(functions.createPath(pos.HumanPlayerPos.get("bluePt"), pos.HumanPlayerPos.get("bluePk"), 1, false));
        basquet.add(functions.createPath(pos.HumanPlayerPos.get("bluePk"), pos.Scorepos.get("blueP"), 0, false));
    }
}
