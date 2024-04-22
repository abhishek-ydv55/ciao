package com.abhi.ciao.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.hbb20.CountryCodePicker;

public class LoginActivity extends AppCompatActivity {


    CountryCodePicker countryCodePicker;
    EditText phoneInput;
    Button sendOtpBtn;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        countryCodePicker = findViewById(R.id.login_countrycode);
        phoneInput = findViewById(R.id.login_mobile_number);
        sendOtpBtn = findViewById(R.id.send_otp_btn);
        progressBar = findViewById(R.id.login_progress_bar);

        progressBar.setVisibility(View.GONE);

        countryCodePicker.registerCarrierNumberEditText(phoneInput);
        sendOtpBtn.setOnClickListener((v) -> {
            if(!countryCodePicker.isValidFullNumber()){
                phoneInput.setError("Invalid Phone Number");
                return;
            }
            Intent intent = new Intent(LoginActivity.this, LoginOtpActivity.class);
            intent.putExtra("phone", countryCodePicker.getFullNumberWithPlus());
            startActivity(intent);
        });

    }
}