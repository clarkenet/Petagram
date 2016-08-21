package com.kenneth.android.petagram.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kenneth.android.petagram.R;
import com.kenneth.android.petagram.database.BaseDatos;
import com.kenneth.android.petagram.model.ConstructorMascota;

public class MainActivity extends AppCompatActivity {

    Button btnEntrar;
    Button btnInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnInicial = (Button) findViewById(R.id.btnInicial);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ListadoActivity.class);
                startActivity(intent);
//                finish();

            }
        });

        btnInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstructorMascota constructor = new ConstructorMascota(getBaseContext());
                constructor.insertarMascotasDummy(new BaseDatos(getBaseContext()));
                Toast.makeText(MainActivity.this, "Se han insertado datos Dummy a la BD!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
