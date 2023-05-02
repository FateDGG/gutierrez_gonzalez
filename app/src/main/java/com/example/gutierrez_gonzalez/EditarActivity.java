package com.example.gutierrez_gonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class EditarActivity extends AppCompatActivity {

    EditText etNombreEdi, etPrecioEdi, etImgEdi;
    Button btnEdit;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        etNombreEdi = findViewById(R.id.et_edinombre);
        etPrecioEdi = findViewById(R.id.et_edivalor);
        btnEdit = findViewById(R.id.btn_edit);
        etImgEdi = findViewById(R.id.et_edimagen);
    }
    public void clickRegistrar(View view) {
        String name = etNombreEdi.getText().toString();
        Double precio = Double.parseDouble(etPrecioEdi.getText().toString());
        String url = etImgEdi.getText().toString();

        Intent addIntent = getIntent();
        String n = addIntent.getStringExtra("nam");
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        Map<String, Object> datos = new HashMap<>();
        datos.put("nombre", name);
        datos.put("precio", precio);
        datos.put("url", url);

        CollectionReference collectionRef = firestore.collection("productos");
        Query query = collectionRef.whereEqualTo("nombre", n);
        query.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot querySnapshot = task.getResult();
                if (!querySnapshot.isEmpty()) {
                    DocumentSnapshot documentSnapshot = querySnapshot.getDocuments().get(0);
                    String documentId = documentSnapshot.getId();
                    Log.d("TAG", "ID del documento: " + documentId);
                    DocumentReference docRef = firestore.collection("productos").document(documentId);
                    docRef.update(datos);
                    finish();
                }
            } else {
                Log.d("TAG", "Error obteniendo documentos: ", task.getException());
            }
        });





    }
}