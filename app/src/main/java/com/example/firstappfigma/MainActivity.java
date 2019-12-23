package com.example.firstappfigma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    //for database purpose variable declaration
    DatabaseHelper db;

    private ImageView imageView;
    private Animation smalltobig, btta, btta2;
    private TextView textView,textView2,text5, subtitle_header;
    private Button button,btn1;
    private EditText editText, editText2,editText3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //for database purpose

        db=new DatabaseHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s1=editText.getText().toString();
                String s2=editText2.getText().toString();
                String s3=editText3.getText().toString();

                if (s1.equals("") || s2.equals("")|| s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Field are empty",Toast.LENGTH_SHORT).show();}
                else
                {
                    if (s2.equals(s3)){

                        Boolean chkemail=db.chkemail(s1);
                        if (chkemail==true){
                            Boolean insert=db.insert(s1,s2,s3);
                            if (insert==true){
                                Toast.makeText(getApplicationContext(),"Registered Successfully!!!",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Username already exist!!",Toast.LENGTH_SHORT).show();

                        }
                    }
                    Toast.makeText(getApplicationContext(),"Password do not match!!",Toast.LENGTH_SHORT).show();
                }

            }
        });



        //Button Sign Up onclick listener
        button=(Button)findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              openActivity2();

            }

        });

        //Button Login onClick Listener
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                        "\\@" +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                        "(" +

                        "\\." +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                        ")+";
            String email=editText.getText().toString();
                Matcher matcher= Pattern.compile(validemail).matcher(email);
                if (matcher.matches()){
                    Toast.makeText(getApplicationContext(),"true",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Enter valid Username",Toast.LENGTH_LONG).show();
                }
            editText2.setError("Enter valid password!!!");
            }
        });

        // load this animation
        smalltobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);
        btta = AnimationUtils.loadAnimation(this, R.anim.btta);
        btta2 = AnimationUtils.loadAnimation(this, R.anim.btta2);

        //Initialise variables
        imageView = (ImageView) findViewById(R.id.imageView);

        textView = (TextView) findViewById(R.id.textView);
        textView2= (TextView) findViewById(R.id.textView2);
        text5 = (TextView) findViewById(R.id.text5);
        subtitle_header =(TextView) findViewById(R.id.subtitle_header);

        button =(Button) findViewById(R.id.button);
        btn1 =(Button) findViewById(R.id.btn1);

        editText = (EditText) findViewById(R.id.editText);
        editText2 =(EditText) findViewById(R.id.editText2);


        // passing animation and start it
        imageView.startAnimation(smalltobig);

        textView.startAnimation(btta);
        textView2.startAnimation(btta);

        subtitle_header.startAnimation(btta);

        button.startAnimation(btta2);
        btn1.startAnimation(btta2);

        editText.startAnimation(btta2);
        editText2.startAnimation(btta2);


    }
    //Sign Up form onclick listner

    public void openActivity2(){
        Intent intent=new Intent(this,krutika2.class);
        startActivity(intent);
    }

    //Login page Validation

}
