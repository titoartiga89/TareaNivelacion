package com.example.a21_pc5.tareanivelacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class    Puntajes extends AppCompatActivity {
    private ListView lstPuntajes;
    private JugadorAdapter AdaptadorJugador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);
        lstPuntajes = (ListView) findViewById(R.id.lstPuntajes);

        //Iniciar el ArrayList y Adaptador
        AdaptadorJugador = new JugadorAdapter(Puntajes.this, MainActivity.lstPuntajes);

        //Configurando el Adaptador al ListView
        lstPuntajes.setAdapter(AdaptadorJugador);
    }
}
