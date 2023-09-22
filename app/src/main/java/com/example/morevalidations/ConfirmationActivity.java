package com.example.morevalidations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConfirmationActivity extends AppCompatActivity {

    String password = null;
    EditText txtConfirmationPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        txtConfirmationPassword = findViewById(R.id.txtConfirmationPassword);

        Intent i = getIntent();

        password = i.getStringExtra("Password");

    }

    public void back(View view) {
        finish();
    }

    public void next(View view) {
        if (password.equals(txtConfirmationPassword.getText().toString())) {
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Equivocado", Toast.LENGTH_SHORT).show();
        }
    }
}