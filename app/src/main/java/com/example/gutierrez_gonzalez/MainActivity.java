package com.example.gutierrez_gonzalez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Producto> listaPrincipalProductos = new ArrayList<>();
    private RecyclerView rvListadoProductos;
    private Button btnAgregar;
    private TextView tvInicio;
    private ImageButton btnLogout;

    private AdaptadorPersonalizado miAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.txt_Listado));
        cargarDatos();
        tvInicio = findViewById(R.id.tv_inicio);
        btnAgregar =findViewById(R.id.btn_agregar);
        btnLogout = findViewById(R.id.ib_cerrarSesion);


        rvListadoProductos = findViewById(R.id.rv_listado_productos);
        miAdaptador = new AdaptadorPersonalizado(listaPrincipalProductos);

        miAdaptador.setOnItemClickListener(new AdaptadorPersonalizado.OnItemClickListener() {
            @Override
            public void onItemClick(Producto miProducto, int posición) {
                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("producto", miProducto);
                startActivity(intent);
            }

            @Override
            public void onItemBtnEliminarClick(Producto miProducto, int position) {
                listaPrincipalProductos.remove(position);
                miAdaptador.setListadoInformacion(listaPrincipalProductos);
                FirebaseFirestore firestore = FirebaseFirestore.getInstance();
                firestore.collection("productos").document(miProducto.getId()).delete();

            }

        });

        rvListadoProductos.setAdapter(miAdaptador);
        rvListadoProductos.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaPrincipalProductos.clear();
        cargarDatos();
    }

    public void clickAgregarProducto(View view){
        Intent addIntent = new Intent(this, FormularioActivity.class);
        startActivity(addIntent);
    }



    public void cargarDatos() {

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection("productos").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(DocumentSnapshot document : task.getResult()) {
                        Producto productoAtrapado = document.toObject(Producto.class);
                        productoAtrapado.setId(document.getId());
                        listaPrincipalProductos.add(productoAtrapado);
                    }
                    miAdaptador.setListadoInformacion(listaPrincipalProductos);
                }else{
                    Toast.makeText(MainActivity.this, "No se pudo conectar al servidor", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    public void clickCerrarSesion(View view){
        SharedPreferences myPreference = getSharedPreferences("tienda_app", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = myPreference.edit();
        myEditor.clear();
        myEditor.apply();

        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

}