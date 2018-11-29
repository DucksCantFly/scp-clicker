package com.example.bran_.scptiles;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.sql.Struct;
import java.util.Arrays;

public class MainActivity extends FragmentActivity {
    ViewPager viewPager;
    TextView showCount;
    Button Tapbtn, Buildbtn, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    boolean[] Monster = new boolean[9];
    boolean[] Tiles = new boolean[9];
    double tileCost = 50;
    double monsterCost = 100;
    double counter = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tapbtn = findViewById(R.id.the_tap);
        Buildbtn = findViewById(R.id.tile_build);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        Buildbtn.setVisibility(View.INVISIBLE);
        Buildbtn.setEnabled(false);
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);

        showCount = findViewById(R.id.counter);
        /*
        Attempt to make part of the screen swipe
        viewPager = (ViewPager) findViewById(R.id.my_pager);
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);
        */
    }


    public void IncreaseCount(View view) {
        //counter++;
        counter = counter + 50;
        if (counter >= tileCost) {
            Buildbtn.setVisibility(View.VISIBLE);
            Buildbtn.setEnabled(true);
        }
        showCount.setText(Double.toString(counter));
        }


    public void onBuild(View view) {
        if(!Tiles[0])
            btn1.setEnabled(true);
        if(!Tiles[1])
            btn2.setEnabled(true);
        if(!Tiles[2])
            btn3.setEnabled(true);
        if(!Tiles[3])
            btn4.setEnabled(true);
        if(!Tiles[4])
            btn5.setEnabled(true);
        if(!Tiles[5])
            btn6.setEnabled(true);
        if(!Tiles[6])
            btn7.setEnabled(true);
        if(!Tiles[7])
            btn8.setEnabled(true);
        if(!Tiles[8])
            btn9.setEnabled(true);
    }

    public void add_Tile(View view) {
        switch(view.getId()){
            case(R.id.button1):
                btn1.setBackgroundColor(Color.GRAY);
                btn1.setEnabled(false);
                Tiles[0] = true;
                break;

            case(R.id.button2):
                btn2.setBackgroundColor(Color.GRAY);
                btn2.setEnabled(false);
                Tiles[1] = true;
                break;

            case(R.id.button3):
                btn3.setBackgroundColor(Color.GRAY);
                btn3.setEnabled(false);
                Tiles[2] = true;
                break;

            case(R.id.button4):
                btn4.setBackgroundColor(Color.GRAY);
                btn4.setEnabled(false);
                Tiles[3] = true;
                break;

            case(R.id.button5):
                btn5.setBackgroundColor(Color.GRAY);
                btn5.setEnabled(false);
                Tiles[4] = true;
                break;

            case(R.id.button6):
                btn6.setBackgroundColor(Color.GRAY);
                btn6.setEnabled(false);
                Tiles[5] = true;
                break;

            case(R.id.button7):
                btn7.setBackgroundColor(Color.GRAY);
                btn7.setEnabled(false);
                Tiles[6] = true;
                break;

            case(R.id.button8):
                btn8.setBackgroundColor(Color.GRAY);
                btn8.setEnabled(false);
                Tiles[7] = true;
                break;
            case(R.id.button9):
                btn9.setBackgroundColor(Color.GRAY);
                btn9.setEnabled(false);
                Tiles[8] = true;
                break;


        }
        counter = counter - tileCost;
        tileCost = tileCost + 50;
        if(!Tiles[0])
            btn1.setEnabled(false);
        if(!Tiles[1])
            btn2.setEnabled(false);
        if(!Tiles[2])
            btn3.setEnabled(false);
        if(!Tiles[3])
            btn4.setEnabled(false);
        if(!Tiles[4])
            btn5.setEnabled(false);
        if(!Tiles[5])
            btn6.setEnabled(false);
        if(!Tiles[6])
            btn7.setEnabled(false);
        if(!Tiles[7])
            btn8.setEnabled(false);
        if(!Tiles[8])
            btn9.setEnabled(false);
        if(counter < tileCost)
            Buildbtn.setEnabled(false);
        showCount.setText(Double.toString(counter));
    }

    public void creeper(View view) {
        if(!Monster[0])
            btn1.setEnabled(true);
        if(!Monster[1])
            btn2.setEnabled(true);
        if(!Monster[2])
            btn3.setEnabled(true);
        if(!Monster[3])
            btn4.setEnabled(true);
        if(!Monster[4])
            btn5.setEnabled(true);
        if(!Monster[5])
            btn6.setEnabled(true);
        if(!Monster[6])
            btn7.setEnabled(true);
        if(!Monster[7])
            btn8.setEnabled(true);
        if(!Monster[8])
            btn9.setEnabled(true);
    }
}
