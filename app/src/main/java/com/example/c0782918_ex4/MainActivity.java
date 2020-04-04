package com.example.c0782918_ex4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTxtFirstName, editTxtLastName, editTxtPhone, editTxtEmail;
    private EditText editTxtStreetNo, editTxtStreetName, editTxtCity;
    private TextView issueDate, txtFirstName, txtLastName, txtPhone, txtEmail, txtStreetNo, txtStreetName, txtCity;
    private RadioButton rbFullTime, rbPartTime, rbTrainee;

    private Spinner spinnerSuffix, spinnerCode, spinnerCountry, spinnerDesignation;

    private CheckBox checkBoxNetwork, checkBoxSystem, checkBoxInternet, checkBoxPerformance;

    public Button btnSubmit;
    public RatingBar ratingBarSeverity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTxtFirstName = findViewById(R.id.editTxtFirstName);
        editTxtLastName = findViewById(R.id.editTxtLastName);
        editTxtEmail = findViewById(R.id.editTxtEmail);
        editTxtPhone = findViewById(R.id.editTxtNumber);
        editTxtStreetNo = findViewById(R.id.editTxtStreetNo);
        editTxtStreetName = findViewById(R.id.editTxtStreetName);
        editTxtCity = findViewById(R.id.editTxtCity);
        issueDate = findViewById(R.id.txtDate);
        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhone = findViewById(R.id.txtPhone);
        txtStreetNo = findViewById(R.id.txtStreetNo);
        txtStreetName = findViewById(R.id.txtStreetName);
        txtCity = findViewById(R.id.txtCity);


        rbFullTime = findViewById(R.id.radioButtonFullTime);
        rbPartTime = findViewById(R.id.radioButtonPartTime);
        rbTrainee = findViewById(R.id.radioButtonTrainee);

        spinnerCode = findViewById(R.id.spinnerCode);
        spinnerSuffix = findViewById(R.id.spinnerSuffix);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        spinnerDesignation = findViewById(R.id.spinnerDesignation);

        checkBoxInternet = findViewById(R.id.checkBoxInternet);
        checkBoxNetwork = findViewById(R.id.checkBoxNetwork);
        checkBoxPerformance = findViewById(R.id.checkBoxPerformance);
        checkBoxSystem = findViewById(R.id.checkBoxSystem);

        btnSubmit = findViewById(R.id.btnSubmit);

        ratingBarSeverity = findViewById(R.id.ratingBarSeverity);


        getCountry();
        getCountryCode();
        getDesignation();
        getSuffix();

        ArrayAdapter<CharSequence> adapterSuffix = ArrayAdapter.createFromResource(this,
                R.array.suffixArray, android.R.layout.simple_spinner_item);
        adapterSuffix.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSuffix.setAdapter(adapterSuffix);

        ArrayAdapter<CharSequence> adapterCode = ArrayAdapter.createFromResource(this,
                R.array.countryCode, android.R.layout.simple_spinner_item);
        adapterCode.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCode.setAdapter(adapterCode);

        ArrayAdapter<CharSequence> adapterCountry = ArrayAdapter.createFromResource(this,
                R.array.country, android.R.layout.simple_spinner_item);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapterCountry);

        ArrayAdapter<CharSequence> adapterDesignation = ArrayAdapter.createFromResource(this,
                R.array.designation, android.R.layout.simple_spinner_item);
        adapterDesignation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDesignation.setAdapter(adapterDesignation);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTxtFirstName.getText().toString().isEmpty()) {
                    editTxtFirstName.setError("Please enter your First Name");
                } else if (editTxtLastName.getText().toString().isEmpty()) {
                    editTxtLastName.setError("Please enter your Last Name");
                } else if (editTxtEmail.getText().toString().isEmpty()) {
                    editTxtEmail.setError("Please enter your Email");
                } else if (editTxtPhone.getText().toString().isEmpty()) {
                    editTxtPhone.setError("Please enter your phone number");
                }else{
                    new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Complaint Filed!")
                        .setMessage("Are you sure to proceed with this complaint?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent mIntent = new Intent(MainActivity.this, ComplaintActivity.class);

                                mIntent.putExtra("firstName", txtFirstName.getText().toString());
                                mIntent.putExtra("LastName", txtLastName.getText().toString());
                                mIntent.putExtra("phoneNumber", txtPhone.getText().toString());
                                mIntent.putExtra("designation", spinnerDesignation.getSelectedItem().toString());
                                mIntent.putExtra("issueDate", issueDate.getText().toString());

                                startActivity(mIntent);

                              //  ComplaintDetail complaintDetails = new ComplaintDetail(txtFirstName,txtLastName);
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                    ;}
            } ;

        });

        ratingBarSeverity.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String ratingSeverity = String.valueOf(rating);
                Toast.makeText(MainActivity.this, String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getSuffix(){

        int suffixPos = spinnerSuffix.getSelectedItemPosition();
        String suffixTitle = String.valueOf(spinnerSuffix.getItemAtPosition(suffixPos));

    }
    private void getCountryCode(){

        int codePos = spinnerCode.getSelectedItemPosition();
        String countryCode = String.valueOf(spinnerCode.getItemAtPosition(codePos));

    }
    private void getCountry(){

        int countryPos = spinnerCountry.getSelectedItemPosition();
        String country = String.valueOf(spinnerCountry.getItemAtPosition(countryPos));

    }
    private void getDesignation(){

        int designationPos = spinnerDesignation.getSelectedItemPosition();
        String designation = String.valueOf(spinnerDesignation.getItemAtPosition(designationPos));

    }

    private ArrayList Address(){
        ArrayList address = new ArrayList<>();
        address.add(editTxtStreetNo.getText().toString());
        address.add(editTxtStreetName.getText().toString());
        address.add(editTxtCity.getText().toString());
        return address;
    }
}
