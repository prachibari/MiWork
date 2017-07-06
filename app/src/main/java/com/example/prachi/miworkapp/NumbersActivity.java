package com.example.prachi.miworkapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;

public class NumbersActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new NumbersFragment()).commit();

       /* ArrayList<String> words = new ArrayList<String>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");
        words.add("eleven");
        words.add("twelve");
        words.add("thirteen");

        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);

        int i=0;
        //Log.v("Numbers Activity"," Size of arrayList " +length);
        while(i<words.size())
        {
            TextView wordView = new TextView(this);
            wordView.setText(words.get(i));
            rootView.addView(wordView);
            i++;
        }
        */

        /*ArrayAdapter<String> numbersAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,words);
        ListView listview = (ListView)findViewById(R.id.list);
        listview.setAdapter(numbersAdapter);
         GridView gridView = (GridView)findViewById(R.id.glist);
        gridView.setAdapter(numbersAdapter); */


    }
}
