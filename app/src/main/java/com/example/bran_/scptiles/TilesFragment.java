package com.example.bran_.scptiles;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TilesFragment extends android.support.v4.app.Fragment {
    Button pgBtn;

    public TilesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View my_view = inflater.inflate(R.layout.tiles_fragment_layout, container,true);
        pgBtn = (Button) my_view.findViewById(R.id.button2);
        Bundle bundle = getArguments();
        return my_view;
    }

}
