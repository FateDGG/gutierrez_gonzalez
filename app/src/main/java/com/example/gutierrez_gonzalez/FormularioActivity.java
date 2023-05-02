package com.example.gutierrez_gonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;

public class FormularioActivity extends AppCompatActivity {


    EditText etNombreReg, etPrecioReg, etImgReg;
    Button btnRegistrar;

    String idd = "0";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        etNombreReg = findViewById(R.id.et_nombre);
        etPrecioReg = findViewById(R.id.et_valor);
        btnRegistrar = findViewById(R.id.btn_Registrar);
        etImgReg = findViewById(R.id.et_imagen);

    }


    public void clickRegistrar(View view){
        String name = etNombreReg.getText().toString();
        Double precio = Double.parseDouble(etPrecioReg.getText().toString());
        String url = etImgReg.getText().toString();
        Producto nuevoproducto = new Producto();
        nuevoproducto.setNombre(name);
        nuevoproducto.setPrecio(precio);
        nuevoproducto.setUrl(url);


        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection("productos").add(nuevoproducto);
        Toast.makeText(this, "Se creo el producto", Toast.LENGTH_SHORT).show();
        finish();

    }



}