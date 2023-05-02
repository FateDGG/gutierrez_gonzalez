package com.example.gutierrez_gonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {

    private TextView tvTitulo_detalle;
    private TextView tvPrecio_detalle;
    private ImageView ivImagenPrincipal;

    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Producto miProductoAtrapado = (Producto) getIntent().getSerializableExtra("producto");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        setTitle(getString(R.string.txtDetalle));
        tvTitulo_detalle = findViewById(R.id.tvTituloDetalle);
        tvPrecio_detalle = findViewById(R.id.tvPrecioDetalle);
        ivImagenPrincipal = findViewById(R.id.ivImagenDetalle);
        Button btnEditar = findViewById(R.id.btn_editar);



        tvTitulo_detalle.setText(miProductoAtrapado.getNombre());
        tvPrecio_detalle.setText(miProductoAtrapado.getPrecio().toString());
        Picasso.get()
                .load(miProductoAtrapado.getUrl())
                .error(R.drawable.ic_launcher_background)
                .into(ivImagenPrincipal);
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    }

    public void clickEditarProducto(View view){
        Producto product = (Producto) getIntent().getSerializableExtra("producto");
        Intent addIntent = new Intent(this, EditarActivity.class);
        addIntent.putExtra("editar", "1");
        addIntent.putExtra("id", s );
        addIntent.putExtra("nam", product.getNombre());
        startActivity(addIntent);
        finish();

    }
}