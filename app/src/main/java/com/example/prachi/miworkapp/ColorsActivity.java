// NOte that in the final version of the App once the tabs are used, Only MainActivity and Fragment
// Classes are used. Activity_Numbers, Activity_Colors are no longer used.

// Also only one xml ie activity_numbers that contains list view can be used to inflate all the fragments
// And activity_category is used. fragment xmls are not used .
package com.example.prachi.miworkapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new ColorsFragment()).commit();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}



