package com.example.gutierrez_gonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FormularioActivity extends AppCompatActivity {

    ImageView ivRegistro;
    TextView tvNombreReg, tvPrecioReg;
    Button btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        ivRegistro = findViewById(R.id.iv_registro);
        tvNombreReg = findViewById(R.id.tv_nombreReg);
        tvPrecioReg = findViewById(R.id.tv_precioReg);
        btnRegistrar = findViewById(R.id.btn_Registrar);
    }
}