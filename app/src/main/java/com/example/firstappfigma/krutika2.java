package com.example.firstappfigma;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class krutika2 extends AppCompatActivity {



    private ImageView imageView;
    private CheckBox checkBox;
    private Button button2;
    private EditText editText,editT,eT;
    private TextView textView,textView4, text5,abc;
    private Animation smalltobig,btta,btta2;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_krutika2);

        // load this animation
        smalltobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);
        btta = AnimationUtils.loadAnimation(this, R.anim.btta);
        btta2 = AnimationUtils.loadAnimation(this, R.anim.btta2);



        //Initialize variables
        imageView =(ImageView) findViewById(R.id.imageView);

        text5 =(TextView) findViewById(R.id.text5);
        textView =(TextView) findViewById(R.id.textView);
        textView4 = (TextView) findViewById(R.id.textView4);
        abc =(TextView) findViewById(R.id.abc);

        checkBox = (CheckBox) findViewById(R.id.checkBox);

        editText = (EditText) findViewById(R.id.editText);
        editT =(EditText) findViewById(R.id.editT);
        eT =(EditText) findViewById(R.id.eT);

        button2= findViewById(R.id.button2);


        // passing animation and start it
        (imageView).startAnimation(smalltobig);

        (text5).startAnimation(btta);
        (textView4).startAnimation(btta);
        (abc).startAnimation(btta);

        (checkBox).startAnimation(btta);

        (editText).startAnimation(btta);
        (editT).startAnimation(btta);
        (eT).startAnimation(btta);

        (button2).startAnimation(btta2);







    }
}
