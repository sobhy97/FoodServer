package com.example.restaurantserver;

import android.content.Intent;
import android.graphics.Typeface;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button signinBtnn;
    TextView txtSlogan;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signinBtnn = findViewById(R.id.signin);
        txtSlogan = findViewById(R.id.slogan);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"font/NABILA.TTF");
        txtSlogan.setTypeface(typeface);

        signinBtnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Signin.class);
                startActivity(intent);
            }
        });

    }
}
