package com.sukusuku.dero;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
//import android.widget.EditText;
//import android.text.SpannableStringBuilder;
//
//
//
import com.sukusuku.android.dero.R;

public class Stage2Question extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        EditText editText = new EditText(this);
//        editText.setHeight(50);
//        setContentView(editText);
//
//        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) editText.getText();
////        CharSequence  = editText.getText();


//
        setContentView(R.layout.activity_stage2_question);



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
    public void toStage2HikidashiFromQuestion(View v) {
        Intent intent = new Intent(this,Stage2_hikidashi.class);
        startActivity(intent);
    }

}
