package com.example.gutierrez_gonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class LoginActivity extends AppCompatActivity {

    ImageView ivLogin;
    EditText etUser, etPassword;
    private SharedPreferences myPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ivLogin = findViewById(R.id.iv_login);
        referenciar();
        myPreferences = getSharedPreferences("tienda_app", MODE_PRIVATE);

        //Verificar si está logueado

        if(myPreferences.getBoolean("logueado", false)){
            Intent logIntent = new Intent(this, MainActivity.class);
            startActivity(logIntent);
            finish();
        }
    }

    private void referenciar() {
        etUser = findViewById(R.id.et_correo);
        etPassword = findViewById(R.id.et_userPassword);
    }

    public void clickIniciarSesion(View view) {
        String Pass = "Avga1221";
        String user = "anghelandres12@gmail.com";
        String passUser = etPassword.getText().toString();
        String username = etUser.getText().toString();
        if (Pass.equals(passUser) && user.equals(username)) {

            SharedPreferences.Editor myEditor = myPreferences.edit();
            myEditor.putBoolean("logueado",true);
            myEditor.apply();

            Intent logIntent = new Intent(this, MainActivity.class);
            startActivity(logIntent);
            finish();
        } else {
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }
    }
}