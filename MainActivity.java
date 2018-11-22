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
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends FragmentActivity {
    ViewPager viewPager;
    TextView showCount;
    Button Tapbtn, Buildbtn, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    //Boolean tiled1, tiled2, tiled3, tiled4, tiled5, tiled6, tiled7, tiled8, tiled9;
    Boolean[] Tiles = new Boolean[9];
    double tileCost = 50;
    double counter = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Arrays.fill(Tiles, Boolean.FALSE);
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
        counter++;
        if (counter >= tileCost) {
            Buildbtn.setVisibility(View.VISIBLE);
            Buildbtn.setEnabled(true);
        }

        showCount.setText(Double.toString(counter));
        }


    public void onBuild(View view) {
        if(Tiles[0] == false)
            btn1.setEnabled(true);
        if(Tiles[1] == false)
            btn2.setEnabled(true);
        if(Tiles[2] == false)
            btn3.setEnabled(true);
        if(Tiles[3] == false)
            btn4.setEnabled(true);
        if(Tiles[4] == false)
            btn5.setEnabled(true);
        if(Tiles[5] == false)
            btn6.setEnabled(true);
        if(Tiles[6] == false)
            btn7.setEnabled(true);
        if(Tiles[7] == false)
            btn8.setEnabled(true);
        if(Tiles[8] == false)
            btn9.setEnabled(true);
    }

    public void add_Tile(View view) {
        switch(view.getId()){
            case(R.id.button1):
                btn1.setBackgroundColor(Color.BLUE);
                btn1.setEnabled(false);
                Tiles[0] = true;
                break;

            case(R.id.button2):
                btn2.setBackgroundColor(Color.BLUE);
                btn2.setEnabled(false);
                Tiles[1] = true;
                break;

        }
        counter = counter - 55;
        tileCost = tileCost + 50;
        if(Tiles[0] == false)
            btn1.setEnabled(false);
        if(Tiles[1] == false)
            btn2.setEnabled(false);
        if(Tiles[2] == false)
            btn3.setEnabled(false);
        if(Tiles[3] == false)
            btn4.setEnabled(false);
        if(Tiles[4] == false)
            btn5.setEnabled(false);
        if(Tiles[5] == false)
            btn6.setEnabled(false);
        if(Tiles[6] == false)
            btn7.setEnabled(false);
        if(Tiles[7] == false)
            btn8.setEnabled(false);
        if(Tiles[8] == false)
            btn9.setEnabled(false);
        if(counter < tileCost){
            Buildbtn.setVisibility(View.INVISIBLE);
            Buildbtn.setEnabled(false);
        }
        showCount.setText(Double.toString(counter));
    }
}
