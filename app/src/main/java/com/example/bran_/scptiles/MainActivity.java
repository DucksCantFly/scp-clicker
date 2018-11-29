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
    //Button [] Monster = new Button[3];
    class Tile
    {
        public boolean isBuilt = false;
        public boolean hasMonster = false;
    };

    Tile [] Floor = new Tile[9];
    double tileCost = 50;
    double monsterCost = 100;
    double counter = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tapbtn = (Button) findViewById(R.id.the_tap);
        Buildbtn = (Button) findViewById(R.id.tile_build);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
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

        showCount = (TextView) findViewById(R.id.counter);
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
        if(counter >= monsterCost){

        }

        showCount.setText(Double.toString(counter));
        }


    public void onBuild(View view) {
        if(!Floor[0].isBuilt)
            btn1.setEnabled(true);
        if(!Floor[1].isBuilt)
            btn2.setEnabled(true);
        if(!Floor[2].isBuilt)
            btn3.setEnabled(true);
        if(!Floor[3].isBuilt)
            btn4.setEnabled(true);
        if(!Floor[4].isBuilt)
            btn5.setEnabled(true);
        if(!Floor[5].isBuilt)
            btn6.setEnabled(true);
        if(!Floor[6].isBuilt)
            btn7.setEnabled(true);
        if(!Floor[7].isBuilt)
            btn8.setEnabled(true);
        if(!Floor[8].isBuilt)
            btn9.setEnabled(true);
    }

    public void add_Tile(View view) {
        switch(view.getId()){
            case(R.id.button1):
                btn1.setBackgroundColor(Color.BLUE);
                btn1.setEnabled(false);
                Floor[0].isBuilt = true;
                break;

            case(R.id.button2):
                btn2.setBackgroundColor(Color.BLUE);
                btn2.setEnabled(false);
                Floor[1].isBuilt = true;
                break;

            case(R.id.button3):
                btn3.setBackgroundColor(Color.BLUE);
                btn3.setEnabled(false);
                Floor[2].isBuilt = true;
                break;

            case(R.id.button4):
                btn4.setBackgroundColor(Color.BLUE);
                btn4.setEnabled(false);
                Floor[3].isBuilt = true;
                break;

            case(R.id.button5):
                btn5.setBackgroundColor(Color.BLUE);
                btn5.setEnabled(false);
                Floor[4].isBuilt = true;
                break;

            case(R.id.button6):
                btn6.setBackgroundColor(Color.BLUE);
                btn6.setEnabled(false);
                Floor[5].isBuilt = true;
                break;

            case(R.id.button7):
                btn7.setBackgroundColor(Color.BLUE);
                btn7.setEnabled(false);
                Floor[6].isBuilt = true;
                break;

            case(R.id.button8):
                btn8.setBackgroundColor(Color.BLUE);
                btn8.setEnabled(false);
                Floor[7].isBuilt = true;
                break;
            case(R.id.button9):
                btn9.setBackgroundColor(Color.BLUE);
                btn9.setEnabled(false);
                Floor[8].isBuilt = true;
                break;


        }
        counter = counter - tileCost;
        tileCost = tileCost + 50;
        if(!Floor[0].isBuilt)
            btn1.setEnabled(false);
        if(!Floor[1].isBuilt)
            btn2.setEnabled(false);
        if(!Floor[2].isBuilt)
            btn3.setEnabled(false);
        if(!Floor[3].isBuilt)
            btn4.setEnabled(false);
        if(!Floor[4].isBuilt)
            btn5.setEnabled(false);
        if(!Floor[5].isBuilt)
            btn6.setEnabled(false);
        if(!Floor[6].isBuilt)
            btn7.setEnabled(false);
        if(!Floor[7].isBuilt)
            btn8.setEnabled(false);
        if(!Floor[8].isBuilt)
            btn9.setEnabled(false);
        if(counter < tileCost)
            Buildbtn.setEnabled(false);
        showCount.setText(Double.toString(counter));
    }

    public void creeper(View view) {
        if(!Floor[0].hasMonster)
            btn1.setEnabled(true);
        if(!Floor[1].hasMonster)
            btn2.setEnabled(true);
        if(!Floor[2].hasMonster)
            btn3.setEnabled(true);
        if(!Floor[3].hasMonster)
            btn4.setEnabled(true);
        if(!Floor[4].hasMonster)
            btn5.setEnabled(true);
        if(!Floor[5].hasMonster)
            btn6.setEnabled(true);
        if(!Floor[6].hasMonster)
            btn7.setEnabled(true);
        if(!Floor[7].hasMonster)
            btn8.setEnabled(true);
        if(!Floor[8].hasMonster)
            btn9.setEnabled(true);


    }
}
