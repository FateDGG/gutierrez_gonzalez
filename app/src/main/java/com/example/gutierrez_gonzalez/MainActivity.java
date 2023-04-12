package com.example.gutierrez_gonzalez;

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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Producto> listaPrincipalProductos;
    private RecyclerView rvListadoProductos;
    private Button btnAgregar;
    private TextView tvInicio;
    private ImageButton btnLogout;

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
        AdaptadorPersonalizado miAdaptador = new AdaptadorPersonalizado(listaPrincipalProductos);

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
            }
        });

        rvListadoProductos.setAdapter(miAdaptador);
        rvListadoProductos.setLayoutManager(new LinearLayoutManager(this));
    }
    public void clickAgregarProducto(View view){
        Intent addIntent = new Intent(this, FormularioActivity.class);
        startActivity(addIntent);
    }

    public void cargarDatos() {
        Producto producto1 = new Producto("Computador HP", 8000000.0, "https://th.bing.com/th/id/OIP.98hN4ZRasR6n-rojQowvAgHaFj?pid=ImgDet&rs=1");
        Producto producto2 = new Producto("Teclado", 150000.0, "https://th.bing.com/th/id/OIP.KVqVOGthP6w2TneHvxlo3QHaHa?pid=ImgDet&rs=1");
        Producto producto3 = new Producto("Mouse", 120000.0, "https://th.bing.com/th/id/R.c204891c88787c3f25e60e61bb32a21d?rik=sBmNO0RlCmFfeA&pid=ImgRaw&r=0");
        listaPrincipalProductos = new ArrayList<>();
        listaPrincipalProductos.add(producto1);
        listaPrincipalProductos.add(producto2);
        listaPrincipalProductos.add(producto3);
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