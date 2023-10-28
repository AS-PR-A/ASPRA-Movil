package com.example.aspra_app;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MultimediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);
        VideoView video = (VideoView) findViewById(R.id.videoView1);
        Uri path = Uri.parse("android.resource://com.example.aspra_app/" + R.raw.videos);
        video.setVideoURI(path);
        video.setMediaController(new MediaController(this));
        video.start();
        video.requestFocus();
    }
}