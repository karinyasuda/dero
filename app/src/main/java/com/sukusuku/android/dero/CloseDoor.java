package com.sukusuku.android.dero;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Created by harayuri on 16/01/15.
 */
public class CloseDoor {

    private SoundPool soundPool;
    private int soundId;

    public CloseDoor(Context context){

        soundPool=new SoundPool(1, AudioManager.STREAM_MUSIC,0);

        soundId=soundPool.load(context,R.raw.close,1);
    }

    public void play(){
        soundPool.play(soundId,1.0f,1.0f,0,0,1.0f);
    }
}
