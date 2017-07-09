package com.example.prachi.miworkapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class NumbersFragment extends Fragment {
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    AudioManager.OnAudioFocusChangeListener changeListener = new AudioManager.OnAudioFocusChangeListener()
    {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange== AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                //pause
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
            else if(focusChange== AudioManager.AUDIOFOCUS_GAIN)
            {
                //resume playback
                mediaPlayer.start();
            }
            else if(focusChange==AudioManager.AUDIOFOCUS_LOSS)
            {
                //stop playback
                releaseMediaPlayer();
            }
        }
    };

    public NumbersFragment() {

        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_numbers, container, false);
        audioManager = (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one","ek",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("two","do",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("three","teen",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("four","char",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("five","panch",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("six","che",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("seven","sath",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("eight","ath",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("nine","nav",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("ten","daha",R.drawable.number_ten,R.raw.number_ten));

        WordAdapter wordAdapter = new WordAdapter(getActivity(),words,R.color.category_numbers);
        ListView listView = (ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                Word word = words.get(position);
                int result = audioManager.requestAudioFocus(changeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(onCompletionListener);
                }


            }
        });
    return rootView;

    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer()
    {
        if(mediaPlayer != null)
        {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(changeListener);
        }
    }
}
