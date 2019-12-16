package com.ARashad96.androidbeginnerdeveloperkit;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class AnimateImages extends AppCompatActivity {
    ImageView ps;
    ImageView xbox;
    Button github;
    Button info;
    Button pscont;
    Button xboxcont;
    Animation fadein;
    Animation fadeout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_animation);

        ps = findViewById(R.id.ps);
        xbox = findViewById(R.id.xbox);
        //set any type of animation
        fadein = AnimationUtils.loadAnimation(this,R.anim.fadein);
        fadeout = AnimationUtils.loadAnimation(this,R.anim.fadeout);

        pscont = findViewById(R.id.pscont);
        pscont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ps.animate().alpha(1).setDuration(2000);
                xbox.animate().alpha(0).setDuration(2000);
            }
        });
        xboxcont = findViewById(R.id.xboxcont);
        xboxcont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xbox.animate().alpha(1).setDuration(2000);
                ps.animate().alpha(0).setDuration(2000);
            }
        });
        github = findViewById(R.id.github);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ARashad96/Collection_of_Animation"));
                startActivity(intent);
            }
        });
        info = findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new android.app.AlertDialog.Builder(AnimateImages.this)
                        .setIcon(R.drawable.profile)
                        .setTitle("App info")
                        .setMessage("This app is performing a transition between images using listview, buttons, animation, Imageview and linearlayout.")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            }
        });
    }
}
