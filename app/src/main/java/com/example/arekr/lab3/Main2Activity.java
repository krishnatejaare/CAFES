package com.example.arekr.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    private Button bcafe,brest,bbak,bsearch;
    private EditText etsearch;
    public static String cafe;
    public String e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bcafe=(Button)findViewById(R.id.bcafe);
        brest=(Button)findViewById(R.id.brest);
        etsearch=(EditText)findViewById(R.id.etsearch) ;
         e=etsearch.getText().toString();
        System.out.println( e);
        bcafe.setOnClickListener(this);
        bbak=(Button)findViewById(R.id.bbak);


        bbak.setOnClickListener(this);
        bsearch=(Button)findViewById(R.id.bsearch);

        bsearch.setOnClickListener(this);
        brest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bcafe:
             cafe = "cafe";
                    break;
            case R.id.brest:
                 cafe = "restaurants";
                break;
            case R.id.bbak:
                cafe = "bakery";
                break;
            case R.id.bsearch:
                cafe = e;
                System.out.println( e);
                break;


        }

       Intent i = new Intent(Main2Activity.this, MapsActivity.class);

      startActivity(i);
        System.out.println( e);
        System.out.println("Hello"+e);
    }
}
