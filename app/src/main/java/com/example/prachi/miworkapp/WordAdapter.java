package com.example.prachi.miworkapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prachi.miworkapp.R;
import com.example.prachi.miworkapp.Word;

import java.util.ArrayList;

/**
 * Created by Prachi on 28-06-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int colorResource;

    public WordAdapter(Context context, ArrayList<Word> resource,int colorResourceId) {
        super(context,0, resource);
        colorResource = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null)
        {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item_numbers,parent,false);
        }

        Word word = getItem(position);

        TextView engTextView = (TextView)listItemView.findViewById(R.id.englishText);
        engTextView.setText(word.getEnglishTranslation());

        TextView miTextView = (TextView)listItemView.findViewById(R.id.miText);
        miTextView.setText(word.getMiTransalation());

        ImageView imageView = (ImageView)listItemView.findViewById(R.id.imageId);
        if(word.hasImage())
        {
            imageView.setImageResource(word.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else
        {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.textContainer);
        int color = ContextCompat.getColor(getContext(),colorResource);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}