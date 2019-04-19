package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;

    private EditText Password;

    private Button Login;

    private TextView Info;

    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Name = (EditText)findViewById(R.id.editName);
        Password = (EditText)findViewById(R.id.passWord);
        Login = (Button)findViewById(R.id.btn);
        Info = (TextView)findViewById(R.id.textV);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword){
        if((userName.equals("Admin"))&&(userPassword.equals("ABCDEF"))){
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }
        else
            counter--;
        Info.setText("Number of attempts remaining:" +String.valueOf(counter));
        if(counter==0){
            Login.setEnabled(false);
        }
    }
}
