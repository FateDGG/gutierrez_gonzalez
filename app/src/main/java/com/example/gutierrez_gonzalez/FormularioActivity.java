package com.example.gutierrez_gonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FormularioActivity extends AppCompatActivity {


    TextView tvNombreReg, tvPrecioReg, tvImgReg;
    Button btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        tvNombreReg = findViewById(R.id.tv_nombreReg);
        tvPrecioReg = findViewById(R.id.tv_precioReg);
        btnRegistrar = findViewById(R.id.btn_Registrar);
        tvImgReg = findViewById(R.id.tv_imgRegistro);
    }
}