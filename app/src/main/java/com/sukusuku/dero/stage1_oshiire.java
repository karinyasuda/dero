package com.sukusuku.dero;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.sukusuku.android.dero.R;

public class stage1_oshiire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage1_oshiire2);
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

    public void goheya(View v) {
        Intent intent = new Intent(this, stage1_room.class);
        startActivity(intent);
    }

    public void gofloor1(View v) {
        Intent intent = new Intent(this, stage1_floor1.class);
        startActivity(intent);
    }

    public void gostage2(View v) {
        if (stage1_start.pref.getBoolean("key1", false) == true) { //鍵がある
            //トーストを表示
            Toast.makeText(this, "謎1が解けたよ！", Toast.LENGTH_SHORT).show();
            //画面の移動(インテント)
            Intent intent = new Intent(this, Stage2Start.class);
            startActivity(intent);
        } else { //鍵がない
            Toast.makeText(this, "謎1が解けてないよ！", Toast.LENGTH_SHORT).show();
        }

    }

}
