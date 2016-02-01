package com.sukusuku.android.dero;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.sukusuku.dero.Stage4Message;


public class MainActivity extends AppCompatActivity {

    public ImageButton imageButton;
    public ImageButton Right;
    public ImageButton Left;
    public ImageButton key;
    public ImageButton door;


    private boolean keyCheck = false;

    public OpenDoor openInstance;
    public CloseDoor closeInstance;
    public WalkSound walkInstance;

    public MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


        imageButton = (ImageButton)findViewById(R.id.start);

        openInstance = new OpenDoor(this.getApplicationContext()) ;
        closeInstance = new CloseDoor(this.getApplicationContext()) ;
        walkInstance = new WalkSound(this.getApplicationContext());

        mp = MediaPlayer.create(this, R.raw.music);
        mp.start();
        mp.setLooping(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //stage2へ
    public void goStage2(View v) {
        Intent intent = new Intent();
        //原が作ったものと異なるパッケージにしたのでここを参考にして画面遷移してください　http://techbooster.org/android/application/8346/
        intent.setClassName(this,"com.sukusuku.dero.Stage2Start");
        startActivity(intent);
    }
    public void goStage3(View v) {
        Intent intent = new Intent();
        //原が作ったものと異なるパッケージにしたのでここを参考にして画面遷移してください　http://techbooster.org/android/application/8346/
        intent.setClassName(this,"com.sukusuku.dero.Stage3Start");
        startActivity(intent);
    }
    //stage4へ
    public void goStage4(View v) {
        Intent intent = new Intent();
        //原が作ったものと異なるパッケージにしたのでここを参考にして画面遷移してください　http://techbooster.org/android/application/8346/
        intent.setClassName(this,"com.sukusuku.dero.Stage4StartActivity");
        startActivity(intent);
    }


    //---------------start---------------------

    public void start(View v){

        setContentView(R.layout.activity_front);
        Right = (ImageButton) findViewById(R.id.frontRight);
        Left = (ImageButton) findViewById(R.id.frontLeft);
        door = (ImageButton)findViewById(R.id.door);

    }

    //-----------------------------------------


    //---------------front---------------------

    //frontViewの右ボタン
    public void frontRight(View v) {
        walkInstance.play();
        setContentView(R.layout.activity_right);
        Right = (ImageButton) findViewById(R.id.rightRight);
        Left = (ImageButton) findViewById(R.id.rightLeft);

    }

    //frontViewの左ボタン
    public void frontLeft(View v){
        walkInstance.play();
        setContentView(R.layout.activity_left);
        Right = (ImageButton) findViewById(R.id.leftRight);
        Left = (ImageButton) findViewById(R.id.leftLeft);

    }

    //frontViewのドア
    public void goal(View v){
        if (keyCheck == true) { //鍵がある
            openInstance.play();
            setContentView(R.layout.activity_goal);
        } else { //鍵がない
            closeInstance.play();
            Toast.makeText(this, "鍵がかかっている", Toast.LENGTH_SHORT).show();
        }
    }

    //-----------------------------------------



    //---------------right---------------------

    //rightViewの右ボタン
    public void rightRight(View v) {
        walkInstance.play();
        setContentView(R.layout.activity_back);
        Right = (ImageButton) findViewById(R.id.backRight);
        Left = (ImageButton) findViewById(R.id.backLeft);
        key = (ImageButton) findViewById(R.id.key);

        //鍵をとっていれば
        if (keyCheck == true) {
            //鍵を見えなくする
            key.setVisibility(View.INVISIBLE);
        }

    }

    //rightViewの左ボタン
    public void rightLeft(View v){
        walkInstance.play();
        setContentView(R.layout.activity_front);
        Right = (ImageButton) findViewById(R.id.frontRight);
        Left = (ImageButton) findViewById(R.id.frontLeft);
        door = (ImageButton)findViewById(R.id.door);
    }

    //-----------------------------------------



    //----------------back---------------------

    //backViewの右ボタン
    public void backRight(View v) {
        walkInstance.play();
        setContentView(R.layout.activity_left);
        Right = (ImageButton) findViewById(R.id.leftRight);
        Left = (ImageButton) findViewById(R.id.leftLeft);

    }

    //backViewの左ボタン
    public void backLeft(View v){
        walkInstance.play();
        setContentView(R.layout.activity_right);
        Right = (ImageButton) findViewById(R.id.rightRight);
        Left = (ImageButton) findViewById(R.id.rightLeft);

    }

    //backViewの鍵
    public void clickKey(View v) {
        //トーストを表示
        Toast.makeText(this, "鍵を手に入れた", Toast.LENGTH_SHORT).show();
        keyCheck = true;
        //鍵を見えなくする
        key.setVisibility(View.INVISIBLE);

    }

    //-----------------------------------------


    //---------------left---------------------

    //leftViewの右ボタン
    public void leftRight(View v) {
        walkInstance.play();
        setContentView(R.layout.activity_front);
        Right = (ImageButton) findViewById(R.id.frontRight);
        Left = (ImageButton) findViewById(R.id.frontLeft);
        door = (ImageButton)findViewById(R.id.door);
    }

    //leftViewの左ボタン
    public void leftLeft(View v){
        walkInstance.play();
        setContentView(R.layout.activity_back);
        Right = (ImageButton) findViewById(R.id.backRight);
        Left = (ImageButton) findViewById(R.id.backLeft);
        key = (ImageButton) findViewById(R.id.key);
        //鍵をとっていれば
        if (keyCheck == true) {
            //鍵を見えなくする
            key.setVisibility(View.INVISIBLE);
        }
    }

    //-----------------------------------------

}
