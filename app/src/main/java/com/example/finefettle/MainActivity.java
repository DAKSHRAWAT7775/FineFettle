package com.example.finefettle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText id,pswd;
    Button btn;
    CheckBox chkRememberMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id=findViewById(R.id.Username);
        pswd=findViewById(R.id.ePassword);
        btn=findViewById(R.id.button66);
        chkRememberMe=findViewById(R.id.checkBox);

        final SharedPreferences sf=getSharedPreferences("Data", Context.MODE_PRIVATE);
        final String type=sf.getString("Username","");
        if(type.isEmpty()){
            Toast.makeText(this, "Please Login", Toast.LENGTH_SHORT).show();
        }else{
            id.setText(type);
            pswd.setText(sf.getString("Password",""));
            chkRememberMe.setChecked(true);
            Toast.makeText(this, "Auto Login Successful", Toast.LENGTH_SHORT).show();
            Intent i3=new Intent(MainActivity.this,MainActivity3.class);
            startActivity(i3);
            finish();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=id.getText().toString();
                String password=pswd.getText().toString();

                if(chkRememberMe.isChecked()){
                    SharedPreferences.Editor editor=sf.edit();
                    editor.putString("Username",username);
                    editor.putString("Password",password);
                    editor.commit();
                }

                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent i3=new Intent(MainActivity.this,MainActivity3.class);
                startActivity(i3);
                finish();
            }
        });

    }
}
