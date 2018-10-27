package com.example.a21_pc5.tareanivelacion;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Nuevo_Contrincante extends AppCompatActivity {

    private EditText txtNombre;
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo__contrincante);

        txtNombre = findViewById(R.id.txtNombre);
        btnAceptar =  findViewById(R.id.btnAceptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNombre.getText().length() > 0) {

                    Jugador est = new Jugador(
                            txtNombre.getText().toString()
                    );

                    Intent intent = new Intent();
                    intent.putExtra("JUGADOR", est);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(Nuevo_Contrincante.this, "DEBE INTRODUCIR SU NOMBRE", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}