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
import android.widget.ImageButton;
import android.widget.Toast;

import com.sukusuku.android.dero.R;

public class Stage4Photo extends AppCompatActivity {
    private SharedPreferences.Editor editor;
    private ImageButton buttonDokodemodoorKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage4_photo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Stage4StartActivity.pref = getSharedPreferences("dasshutsu_data", MODE_PRIVATE);
        //buttonKey変数 と activity_main.xmlの@+id/buttonKeyを結びつける
        buttonDokodemodoorKey = (ImageButton) findViewById(R.id.buttonDokodemodoorKey);

        //鍵をとっていれば
        if (Stage4StartActivity.pref.getBoolean("key1", false) == true) {
            //鍵を見えなくする
            buttonDokodemodoorKey.setVisibility(View.INVISIBLE);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void toStage4MessageFromPhoto(View v) {
        Intent intent = new Intent(this, Stage4Message.class);
        startActivity(intent);
    }
    public void toStage4DokodemoDoorFromPhoto(View v) {
        Intent intent = new Intent(this, Stage4DokodemoDoor.class);
        startActivity(intent);
    }
    public void clickDokodemodoorKey(View v) {
        //トーストを表示
        Toast.makeText(this, "鍵を手に入れたよ！", Toast.LENGTH_SHORT).show();
        //SharedPreferencesに鍵を手に入れたことを書き込む
        editor = Stage4StartActivity.pref.edit();
        editor.putBoolean("key1", true);
        editor.commit();
        //鍵を見えなくする
        buttonDokodemodoorKey.setVisibility(View.INVISIBLE);

    }

}
