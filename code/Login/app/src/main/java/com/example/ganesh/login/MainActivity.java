package com.example.ganesh.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    protected void logInClicked(View v){

        if(v.getId()==R.id.logIn){

            EditText e1=(EditText)findViewById(R.id.userName);
            String s1=e1.getText().toString();
            EditText e2=(EditText)findViewById(R.id.password);
            String s2=e2.getText().toString();

            if((s1.equals("admin") && s2.equals("abc")) || (s1.equals("user") && s2.equals("def"))){
                Intent i=new Intent(MainActivity.this,Layout.class);
                startActivity(i);
            }

            else{
                Toast.makeText(this, "Username and Passwords dont match", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
