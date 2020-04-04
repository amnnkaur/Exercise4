package com.example.c0782918_ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ComplaintActivity extends AppCompatActivity {

    private TextView firstName;
    private TextView lastName;
    private TextView number;
    private TextView designation;
    private TextView issue;
    private TextView issueDate;
    private TextView address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        firstName = findViewById(R.id.textViewFirstName1);
        lastName = findViewById(R.id.textViewLastName1);
        number = findViewById(R.id.textViewNumber1);
        designation = findViewById(R.id.textViewDesignation1);
        issue = findViewById(R.id.textViewIssue1);
        issueDate = findViewById(R.id.textViewDate1);
        address = findViewById(R.id.textViewAddress1);

    }
}
