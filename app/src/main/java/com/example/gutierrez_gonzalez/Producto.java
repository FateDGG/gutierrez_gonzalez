package com.example.gutierrez_gonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Producto extends AppCompatActivity {
    public Producto(String nombre, Double precio, String url) {
        this.Nombre = nombre;
        this.Precio = precio;
        this.Url = url;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String Nombre;
    public Double Precio;
    public String Url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_lista_productos);
    }


}