package com.example.simple_login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity
{

    private EditText name;
    private EditText password;
    private TextView info;
    private Button login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.txtUserName);
        password = (EditText)findViewById(R.id.txtPassword);
        info = (TextView)findViewById(R.id.txtInfo);
        login = (Button)findViewById(R.id.btnLogin);

        info.setText("Number of attempts remaining: 5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(), password.getText().toString());
            }
        });
    }
    private void validate(String userName, String userPassword)
    {
        if((userName.equals("roozbeh") && (userPassword.equals("1234"))))
        {
            Intent startIntent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(startIntent);
        }
        else
            counter--;

        info.setText("Number of attempts remaining: " + counter);

        if (counter == 0)
        {
            login.setEnabled(false);
        }

    }
}
