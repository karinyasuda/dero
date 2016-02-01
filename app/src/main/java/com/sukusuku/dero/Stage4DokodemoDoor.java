package com.sukusuku.dero;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sukusuku.android.dero.R;

public class Stage4DokodemoDoor extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage4_dokodemo_door);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void toPhotoFromDokodemoDoor(View v) {
        Intent intent = new Intent(this, Stage4Photo.class);
        startActivity(intent);
    }
    public void toMessageFromDokodemoDoor(View v) {
        Intent intent = new Intent(this, Stage4Message.class);
        startActivity(intent);
    }
    public void goEnding(View v) {
        if (Stage4StartActivity.pref.getBoolean("key1", false) == true) { //鍵がある
            //トーストを表示
            Toast.makeText(this, "ドアが開いたよ！", Toast.LENGTH_SHORT).show();
            //画面の移動(インテント)
            Intent intent = new Intent(this, Ending.class);
            startActivity(intent);
        } else { //鍵がない
            Toast.makeText(this, "鍵ないがないよ！", Toast.LENGTH_SHORT).show();
        }

    }

}
