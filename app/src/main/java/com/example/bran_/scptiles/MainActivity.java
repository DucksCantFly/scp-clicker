package com.example.bran_.scptiles;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceDataStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import java.util.*;
import java.lang.*;

public class MainActivity extends FragmentActivity {
    ViewPager viewPager;
    TextView showCount;
    TextView screen;
    Button Tapbtn, Buildbtn, creep_btn, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, nxt;
    boolean[] Monster = new boolean[9]; //TODO - Going forward we should agree on a naming convention.
    boolean[] Tiles = new boolean[9];
    double tileCost = 50;
    double monsterCost = 100; //Further development will call for a vector of ints for various monster costs
    double counter = 0;       //Tap Counter
    double incrementVal = 50;
    double perSecondIncrement = 0;
    long timer = System.currentTimeMillis();

    int matrix[][]  = new int[3][3]; // note: Tiles and Monsters fills a similar role. When refactoring code, account for that.

    public static int monsterID; //Use to identify which monster and tile button is active
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = findViewById(R.id.prompt);
        Tapbtn = findViewById(R.id.the_tap);
        Buildbtn = findViewById(R.id.tile_build);
        creep_btn = findViewById(R.id.creeper_btn);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        nxt = findViewById(R.id.next);
        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                setFragment((new TileFrag()));
            }
        });
        /*
        GRID VIEW - used in Matrix
        btn1    btn2    btn3
        btn4    btn5    btn6
        btn7    btn8    btn9
         */
        //intialize matrix to zero
        /*
        for(int i = 0; i < 3;i++){
            for(int j = 0; j<3;j++){
                matrix[i][j] = 0;
            }
        }
        */

        Buildbtn.setVisibility(View.INVISIBLE);
        creep_btn.setVisibility(View.INVISIBLE);

        creep_btn.setEnabled(false);
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
    //TODO Count Should Be Able to Increment Without Player Input
    public void updatePerSecondIncrement(){
        perSecondIncrement += 1;
    }

    public void IncreaseCount(View view) {
        if(System.currentTimeMillis() - timer > 1000){
            timer = System.currentTimeMillis();
            counter+= perSecondIncrement;
        }
        counter += incrementVal;
        //counter = counter + 50;
        if (counter >= tileCost) {
            Buildbtn.setVisibility(View.VISIBLE);
            Buildbtn.setEnabled(true);
        }
        if(counter >= monsterCost){
            creep_btn.setVisibility(View.VISIBLE);
            creep_btn.setEnabled(true);
        }
        showCount.setText(Double.toString(counter));
        screen.setVisibility(View.INVISIBLE);
    }


    public void onBuild(View view) {
        screen.setVisibility(View.VISIBLE);
        screen.setText(R.string.Tile_prompt);
        if(!Tiles[0]) {
            btn1.setEnabled(true);
        }
        if(!Tiles[1]) {
            btn2.setEnabled(true);
        }
        if(!Tiles[2]) {
            btn3.setEnabled(true);
        }
        if(!Tiles[3]) {
            btn4.setEnabled(true);
        }
        if(!Tiles[4]) {
            btn5.setEnabled(true);
        }
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
                if(!Tiles[0] && !Monster[0]) {
                    btn1.setBackgroundColor(Color.GRAY);
                    btn1.setEnabled(false);
                    Tiles[0] = true;
                    screen.setText(R.string.Tile_prompt2);
                    counter = counter - tileCost;
                    tileCost = tileCost + 50;
                    break;
                }
                else if(Tiles[0] && !Monster[0]) {
                    placeMonster(monsterID, R.id.button1);
                    Monster[0] = false;
                    break;
                }

            case(R.id.button2):
                if(!Tiles[1] && !Monster[1]) {
                    btn2.setBackgroundColor(Color.GRAY);
                    btn2.setEnabled(false);
                    Tiles[1] = true;
                    screen.setText(R.string.Tile_prompt2);
                    counter = counter - tileCost;
                    tileCost = tileCost + 50;
                    break;
                }
                else if(Tiles[1] && !Monster[1]) {
                    placeMonster(monsterID, R.id.button2);
                    Monster[1] = false;
                    break;
                }

            case(R.id.button3):
                if(!Tiles[2] && !Monster[2]) {
                    btn3.setBackgroundColor(Color.GRAY);
                    btn3.setEnabled(false);
                    Tiles[2] = true;
                    screen.setText(R.string.Tile_prompt2);
                    counter = counter - tileCost;
                    tileCost = tileCost + 50;
                    break;
                }
                else if(Tiles[2] && !Monster[2]) {
                    placeMonster(monsterID, R.id.button3);
                    Monster[2] = false;
                    break;
                }

            case(R.id.button4):
                if(!Tiles[3] && !Monster[3]) {
                    btn4.setBackgroundColor(Color.GRAY);
                    btn4.setEnabled(false);
                    Tiles[3] = true;
                    screen.setText(R.string.Tile_prompt2);
                    counter = counter - tileCost;
                    tileCost = tileCost + 50;
                    break;
                }
                else if(Tiles[3] && !Monster[3]){
                    placeMonster(monsterID, R.id.button4);
                    Monster[3] = false;
                    break;
                }

            case(R.id.button5):
                if(!Tiles[4] && !Monster[4]) {
                    btn5.setBackgroundColor(Color.GRAY);
                    btn5.setEnabled(false);
                    Tiles[4] = true;
                    screen.setText(R.string.Tile_prompt2);
                    counter = counter - tileCost;
                    tileCost = tileCost + 50;
                    break;
                }
                else if(Tiles[4] && !Monster[4]){
                    placeMonster(monsterID, R.id.button5);
                    Monster[4] = false;
                    break;
                }

            case(R.id.button6):
                if(!Tiles[5] && !Monster[5]) {
                    btn6.setBackgroundColor(Color.GRAY);
                    btn6.setEnabled(false);
                    Tiles[5] = true;
                    screen.setText(R.string.Tile_prompt2);
                    counter = counter - tileCost;
                    tileCost = tileCost + 50;
                    break;
                }
                else if(Tiles[5] && !Monster[5]){
                    placeMonster(monsterID, R.id.button6);
                    Monster[5] = false;
                    break;
                }

            case(R.id.button7):
                if(!Tiles[6] && !Monster[6]) {
                    btn7.setBackgroundColor(Color.GRAY);
                    btn7.setEnabled(false);
                    Tiles[6] = true;
                    screen.setText(R.string.Tile_prompt2);
                    counter = counter - tileCost;
                    tileCost = tileCost + 50;
                    break;
                }
                else if(Tiles[6] && !Monster[6]){
                    placeMonster(monsterID, R.id.button7);
                    Monster[6] = false;
                    break;
                }

            case(R.id.button8):
                if(!Tiles[7] && !Monster[7]) {
                    btn8.setBackgroundColor(Color.GRAY);
                    btn8.setEnabled(false);
                    Tiles[7] = true;
                    screen.setText(R.string.Tile_prompt2);
                    counter = counter - tileCost;
                    tileCost = tileCost + 50;
                    break;
                }
                else if(Tiles[7] && !Monster[7]){
                    placeMonster(monsterID, R.id.button8);
                    Monster[7] = false;
                    break;
                }

            case(R.id.button9):
                if(!Tiles[8] && !Monster[8]) {
                    btn9.setBackgroundColor(Color.GRAY);
                    btn9.setEnabled(false);
                    Tiles[8] = true;
                    screen.setText(R.string.Tile_prompt2);
                    counter = counter - tileCost;
                    tileCost = tileCost + 50;
                    break;
                }
                else if(Tiles[8] && !Monster[8]){
                    placeMonster(monsterID, R.id.button9);
                    Monster[8] = false;
                    break;
                }


        }
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
        if(counter < monsterCost)
            creep_btn.setEnabled(false);
        showCount.setText(Double.toString(counter));
    }

    /////////////////////////////////////////////////////
    //Where more monsters would be added/////////////////
    /////////////////////////////////////////////////////

    //The placeMonster function passes two arguments; the monster button ID and the Button ID.
    //The mID in the first switch statement is used to determine which monster button was clicked.
    //The bID in the second switch statement is used to determine which button to place the monster icon on.
    private void placeMonster(int mID, int bID) {
        switch(mID){
            case(R.id.creeper_btn):
                switch(bID) {
                    case (R.id.button1):
                        btn1.setBackgroundResource(R.drawable.creeper_icon2);
                        matrix[0][0] = 1;
                        incrementVal += 1;
                        break;

                    case(R.id.button2):
                        btn2.setBackgroundResource(R.drawable.creeper_icon2);
                        matrix[0][1] = 1;
                        incrementVal += 1;
                        break;

                    case(R.id.button3):
                        btn3.setBackgroundResource(R.drawable.creeper_icon2);
                        matrix[0][2] = 1;
                        incrementVal += 1;
                        break;

                    case(R.id.button4):
                        btn4.setBackgroundResource(R.drawable.creeper_icon2);
                        matrix[1][0] = 1;
                        incrementVal += 1;
                        break;

                    case(R.id.button5):
                        btn5.setBackgroundResource(R.drawable.creeper_icon2);
                        matrix[1][1] = 1;
                        incrementVal += 1;
                        break;

                    case(R.id.button6):
                        btn6.setBackgroundResource(R.drawable.creeper_icon2);
                        matrix[1][2] = 1;
                        incrementVal += 1;
                        break;

                    case(R.id.button7):
                        btn7.setBackgroundResource(R.drawable.creeper_icon2);
                        matrix[2][0] = 1;
                        incrementVal += 1;
                        break;

                    case(R.id.button8):
                        btn8.setBackgroundResource(R.drawable.creeper_icon2);
                        matrix[2][1] = 1;
                        incrementVal += 1;
                        break;

                    case(R.id.button9):
                        btn9.setBackgroundResource(R.drawable.creeper_icon2);
                        matrix[2][2] = 1;
                        incrementVal += 1;
                        break;
                }
        }
        screen.setText(getString(R.string.Creeper_prompt2));
        counter = counter - monsterCost;
        if(counter < 0){
            counter = 0;
        }
        monsterCost = monsterCost + 50;
        if(counter < monsterCost)
            creep_btn.setEnabled(false);
        else
            creep_btn.setEnabled(true);
    }

    /////////////////////////////////////////////////////////////////////////////
    //Creeper Monster button would enable all tiles that have a container built//
    /////////////////////////////////////////////////////////////////////////////
    public int creeper(View view) {
        screen.setVisibility(View.VISIBLE);
        screen.setText(getString(R.string.Creeper_prompt1));
        monsterID = view.getId();
        if(Tiles[0] && !Monster[0])
            btn1.setEnabled(true);
        if(Tiles[1] && !Monster[1])
            btn2.setEnabled(true);
        if(Tiles[2] && !Monster[2])
            btn3.setEnabled(true);
        if(Tiles[3] && !Monster[3])
            btn4.setEnabled(true);
        if(Tiles[4] && !Monster[4])
            btn5.setEnabled(true);
        if(Tiles[5] && !Monster[5])
            btn6.setEnabled(true);
        if(Tiles[6] && !Monster[6])
            btn7.setEnabled(true);
        if(Tiles[7] && !Monster[7])
            btn8.setEnabled(true);
        if(Tiles[8] && !Monster[8])
            btn9.setEnabled(true);
        return monsterID;
    }

    public void setFragment(Fragment f){

        FragmentManager fMananger = getSupportFragmentManager();
        FragmentTransaction ft = fMananger.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
        ft.replace(R.id.TileFrame,f);
        ft.commit();
        btn1.setEnabled(false);
        btn2.setBackgroundResource(android.R.drawable.btn_default);
    }
}
