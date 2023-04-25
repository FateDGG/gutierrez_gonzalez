package com.example.gutierrez_gonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class FormularioActivity extends AppCompatActivity {


    EditText etNombreReg, etPrecioReg, etImgReg;
    Button btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        etNombreReg = findViewById(R.id.et_nombre);
        etPrecioReg = findViewById(R.id.et_valor);
        btnRegistrar = findViewById(R.id.btn_Registrar);
        etImgReg = findViewById(R.id.et_imagen);
    }


    public void clickGuardar(View view){
        String nombre = etNombreReg.getText().toString();
        Double precio = Double.parseDouble(etPrecioReg.getText().toString());
        String url = etImgReg.getText().toString();
        Producto nuevoProducto = new Producto(nombre,precio,url);

    }

    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

}