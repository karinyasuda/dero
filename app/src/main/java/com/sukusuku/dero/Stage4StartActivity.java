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

public class Stage4StartActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Button next;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage4_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //SharedPreferencesを使うための初期設定
        pref = getSharedPreferences("dasshutsu_data", MODE_PRIVATE);
        //buttonKey変数 と activity_main.xmlの@+id/buttonKeyを結びつける
        //buttonKey = (Button) findViewById(R.id.next);
        next = (Button) findViewById(R.id.next);

        //鍵をとっていれば
        if (pref.getBoolean("key1", false) == true) {
            //鍵を見えなくする
            //buttonKey.setVisibility(View.INVISIBLE);
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
    public void goStage4Message(View v) {
        Intent intent = new Intent(this, Stage4Message.class);
        startActivity(intent);
    }
    public void clickDoor(View v) {
        //鍵があるかどうか
        if (pref.getBoolean("key1", false) == true) { //鍵がある
            //トーストを表示
            Toast.makeText(this, "ドアが開いたよ！", Toast.LENGTH_SHORT).show();
            //画面の移動(インテント)
            Intent intent = new Intent(this, Stage4Message.class);
            startActivity(intent);
        } else { //鍵がない
            Toast.makeText(this, "鍵ないがないよ！", Toast.LENGTH_SHORT).show();
        }
    }
    public void clickKey(View v) {
        //トーストを表示
        Toast.makeText(this, "鍵を手に入れたよ！", Toast.LENGTH_SHORT).show();
        //SharedPreferencesに鍵を手に入れたことを書き込む
        editor = pref.edit();
        editor.putBoolean("key1", true);
        editor.commit();
        //鍵を見えなくする
        //buttonKey.setVisibility(View.INVISIBLE);

    }

}
