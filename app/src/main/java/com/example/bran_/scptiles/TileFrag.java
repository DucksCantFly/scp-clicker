package com.example.bran_.scptiles;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TileFrag extends Fragment {

    TextView showCount;
    TextView screen;
    Button Tapbtn, Buildbtn, creep_btn, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, nxt;
    boolean[] Monster = new boolean[9]; //TODO - Going forward we should agree on a naming convention.
    boolean[] Tiles = new boolean[9];
    double tileCost = 50;
    double monsterCost = 100; //Further development will call for a vector of ints for various monster costs
    double counter = 0;       //Tap Counter
    double incrementVal = 1;
    double perSecondIncrement = 0;
    long timer = System.currentTimeMillis();

    int matrix[][]  = new int[3][3]; // note: Tiles and Monsters fills a similar role. When refactoring code, account for that.

    public static int monsterID; //Use to identify which monster and tile button is active

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tile, container, false);
    }

}
