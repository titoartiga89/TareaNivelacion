package com.example.a21_pc5.tareanivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private Button BtnNuevoJugador;
    private Button BtnIniciarJuego;
    private Button BtnPuntajes;
    public static ArrayList<Jugador> lstPuntajes = new ArrayList<Jugador>();
    public static int GUARDADO = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.BtnNuevoJugador = (Button) findViewById(R.id.BtnNuevoJugador);
        this.BtnIniciarJuego = (Button) findViewById(R.id.BtnIniciarJuego);
        this.BtnPuntajes = (Button) findViewById(R.id.BtnPuntajes);
        this.BtnNuevoJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Nuevo_Contrincante.class);
                startActivity(intent);
            }
        });
        this.BtnIniciarJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, JuegoIniciado.class);
                startActivity(intent);
            }
        });
        this.BtnPuntajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Puntajes.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GUARDADO && resultCode == RESULT_OK) {
            Jugador jugador = (Jugador) data.getSerializableExtra("JUGADOR");

            lstPuntajes.add(jugador);
            BtnPuntajes.setText("Lista de Puntajes " + lstPuntajes.size());
        }
    }
}
