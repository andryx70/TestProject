package com.andry.testproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Upload_Data_Activity extends AppCompatActivity {

    EditText etName, etAge, etHigh, etNumber;
    Button upData;
    Members members;
    DatabaseReference reference;
    long maxid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload__data_);

        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);
        etHigh = findViewById(R.id.et_high);
        etNumber = findViewById(R.id.et_number);
        upData =findViewById(R.id.up_data);
        members = new Members();
        reference = FirebaseDatabase.getInstance().getReference().child("Members");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxid = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        upData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age = Integer.parseInt(etAge.getText().toString().trim());
                Float high = Float.parseFloat(etHigh.getText().toString().trim());
                Long number = Long.parseLong(etNumber.getText().toString().trim());

                members.setName(etName.getText().toString().trim());
                members.setAge(age);
                members.setHigh(high);
                members.setNumber(number);

                reference.child(String.valueOf(maxid+1)).setValue(members);

            }
        });




    }
}
