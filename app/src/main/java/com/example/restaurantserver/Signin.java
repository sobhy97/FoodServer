package com.example.restaurantserver;

import android.app.ProgressDialog;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.restaurantserver.Common.Common;
import com.example.restaurantserver.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signin extends AppCompatActivity {

    EditText edtPhone,edtPass;
    Button signIn;
    FirebaseDatabase db;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        edtPhone = findViewById(R.id.editphone);
        edtPass = findViewById(R.id.editpass);
        signIn = findViewById(R.id.bttnsignin);

        db = FirebaseDatabase.getInstance();
        users = db.getReference("User");

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInUser(edtPhone.getText().toString(),edtPass.getText().toString());
            }
        });

    }

    private void signInUser(String phone, String password) {

        final ProgressDialog progressDialog = new ProgressDialog(Signin.this);
        progressDialog.setMessage("Please Waiting....");
        progressDialog.show();

        final String localPhone = phone;
        final String localpassword = password;


        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.child(localPhone).exists())
                {
                    progressDialog.dismiss();
                    User user = dataSnapshot.child(localPhone).getValue(User.class);
                    user.setPhone(localPhone);

                    if (Boolean.parseBoolean(user.getIsStaff())) //if isstaff = true
                    {
                        if (user.getPassword().equals(localpassword))
                        {
                            //login ok
                            Intent intent = new Intent(Signin.this,Home.class);
                            Common.currentUser = user;
                            startActivity(intent);
                            finish();


                        }
                        else
                            Toast.makeText(Signin.this,"Wrong password!",Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(Signin.this,"Please loging with Staff account!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    progressDialog.dismiss();
                    Toast.makeText(Signin.this,"User not exist in database!",Toast.LENGTH_LONG).show();



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
