package com.andry.testproject;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextInputEditText textr1,textr2;
    Button buttonUp, otherActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonUp = findViewById(R.id.upload_data);
        otherActivity = findViewById(R.id.next_activity);

        buttonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textr1 = findViewById(R.id.dato1);
                textr2 = findViewById(R.id.dato2);

                if (textr1.getText().toString().isEmpty()&&textr2.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Todo vacio", Toast.LENGTH_SHORT).show();
                } else if (textr1.getText().toString().isEmpty()){
                    textr1.setError("Campo Oblidado");
                } else if (textr2.getText().toString().isEmpty()){
                    textr2.setError("obligado");
                }else {
                    Toast.makeText(MainActivity.this, "Todo bn parce", Toast.LENGTH_SHORT).show();
                }
            }
        });

        otherActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Upload_Data_Activity.class);
                startActivity(intent);
            }
        });


    }
}
