package com.example.morevalidations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtEmail, txtPassword;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
    }

    private boolean validarCampos() {
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        
        if (password.length() < 7) {
            txtPassword.setError("La contraseña debe ser de un largo mayor a 7 caracteres.");
            return false;
        }
        
        if (email.length() < 3) {
            txtEmail.setError("El largo del email debe ser mayor a 3 caracteres.");
            return false;
        }

        if (!email.contains("@")) {
            txtEmail.setError("El email no contiene ningun @");
            return false;
        }
        
        return true;
    }
    
    public void next(View view) {
        if (validarCampos()) {
            Intent i = new Intent(this, ConfirmationActivity.class);

            startActivity(i);
        } else {
            Toast.makeText(this, "Corrija los errores", Toast.LENGTH_SHORT).show();
        }
        
        
    }
}