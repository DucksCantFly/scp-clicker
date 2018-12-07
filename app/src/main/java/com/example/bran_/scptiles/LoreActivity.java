package com.example.bran_.scptiles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Button;

public class LoreActivity extends AppCompatActivity{
    ImageButton creepBtn, maskBtn, shadowBtn;
    ImageView selected;
    Button learnMore;
    Button goToMain;
    String pageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lore);

        creepBtn = findViewById(R.id.creepBtn);
        maskBtn = findViewById(R.id.maskBtn);
        shadowBtn = findViewById(R.id.shadowBtn);
        selected = findViewById(R.id.selected);
        learnMore = findViewById(R.id.linkToPage);
        learnMore.setVisibility(View.INVISIBLE);
        goToMain = findViewById(R.id.backToMain);
    }

    public void showLore(View view){
        switch(view.getId()){
            case(R.id.shadowBtn): {
                selected.setImageResource(R.drawable.shadowlore);
                pageUrl = "http://www.scp-wiki.net/scp-017";
                break;
            }
            case(R.id.creepBtn): {
                selected.setImageResource(R.drawable.creeplore);
                pageUrl = "http://www.scp-wiki.net/scp-966";
                break;
            }
            case(R.id.maskBtn): {
                // mask lore not yet finalized
                pageUrl = "http://www.scp-wiki.net/scp-035";
            }
        }
        learnMore.setVisibility(View.VISIBLE);


    }


    public void VisitPage(View view){
        // To Be added:
        //function to open browser and direct to assigned page.
    }
}
