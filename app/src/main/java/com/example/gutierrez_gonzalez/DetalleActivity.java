package com.example.gutierrez_gonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {

    private TextView tvTitulo_detalle;
    private TextView tvPrecio_detalle;
    private ImageView ivImagenPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        setTitle(getString(R.string.txtDetalle));
        tvTitulo_detalle = findViewById(R.id.tvTituloDetalle);
        tvPrecio_detalle = findViewById(R.id.tvPrecioDetalle);
        ivImagenPrincipal = findViewById(R.id.ivImagenDetalle);

        Producto miProductoAtrapado = (Producto) getIntent().getSerializableExtra("producto");

        tvTitulo_detalle.setText(miProductoAtrapado.getNombre());
        tvPrecio_detalle.setText(miProductoAtrapado.getPrecio().toString());
        Picasso.get()
                .load(miProductoAtrapado.getUrl())
                .error(R.drawable.ic_launcher_background)
                .into(ivImagenPrincipal);

    }
}