package com.example.a21_pc5.tareanivelacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class JuegoIniciado extends AppCompatActivity {

    Button btnPiedra, btnPapel, btnTijera;
    TextView txtGanados, txtPerdidos, txtEmpatados, txtPuntos;
    int JugadorPuntaje=0;
    int CPUpuntaje=0;
    int empate=0;
    //int puntos=0;
    ImageView imgJugador, imgCPU;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_iniciado);

        btnPiedra=(Button)findViewById(R.id.btnPiedra);
        btnPapel=(Button)findViewById(R.id.btnPapel);
        btnTijera=(Button)findViewById(R.id.btnTijera);

        txtGanados=(TextView)findViewById(R.id.txtGanados);
        txtEmpatados=(TextView)findViewById(R.id.txtEmpatados);
        txtPerdidos=(TextView)findViewById(R.id.txtPerdidos);

        imgJugador = (ImageView)findViewById(R.id.imgJugador);
        imgCPU = (ImageView)findViewById(R.id.imgCPU);

    btnPiedra.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
             imgJugador.setImageResource(R.drawable.piedra);
             String mensaje = turno("PIEDRA");
            Toast.makeText(JuegoIniciado.this,mensaje,Toast.LENGTH_LONG).show();
            txtGanados.setText("JUGADOR: "+Integer.toString(JugadorPuntaje));
            txtPerdidos.setText("CPU: "+Integer.toString(CPUpuntaje));
            txtEmpatados.setText("EMPATE: "+Integer.toString(empate));
            //txtPuntos.setText("PUNTOS: "+Integer.toString(JugadorPuntaje=JugadorPuntaje+6));

        }
    });

        btnPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgJugador.setImageResource(R.drawable.papel);
                String mensaje = turno("PAPEL");
                Toast.makeText(JuegoIniciado.this,mensaje,Toast.LENGTH_LONG).show();
                txtGanados.setText("JUGADOR: "+Integer.toString(JugadorPuntaje));
                txtPerdidos.setText("CPU: "+Integer.toString(CPUpuntaje));
                txtEmpatados.setText("EMPATE: "+Integer.toString(empate));
                //txtPuntos.setText("PUNTOS: "+Integer.toString(JugadorPuntaje=JugadorPuntaje+6));

            }
        });
        btnTijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgJugador.setImageResource(R.drawable.tijeras);
                String mensaje = turno("TIJERAS");
                Toast.makeText(JuegoIniciado.this,mensaje,Toast.LENGTH_LONG).show();
                txtGanados.setText("JUGADOR: "+Integer.toString(JugadorPuntaje));
                txtPerdidos.setText("CPU: "+Integer.toString(CPUpuntaje));
                txtEmpatados.setText("EMPATE "+Integer.toString(empate));
               //txtPuntos.setText("PUNTOS: "+Integer.toString(JugadorPuntaje=JugadorPuntaje+6));

            }
        });

    }

    public String turno(String elegido) {

        String dispositivo_selecciono = " ";
        Random r = new Random();
        int dispos_selecciono_numero = r.nextInt(3) + 1;
        if (dispos_selecciono_numero == 1) {
            dispositivo_selecciono = "PIEDRA";
        } else if (dispos_selecciono_numero == 2) {
            dispositivo_selecciono = "PAPEL";
        } else if (dispos_selecciono_numero == 3) {
            dispositivo_selecciono = "TIJERA";
        }

        if (dispositivo_selecciono=="PIEDRA") {
            imgCPU.setImageResource(R.drawable.piedra);
        }else if (dispositivo_selecciono=="PAPEL"){
            imgCPU.setImageResource(R.drawable.papel);
        }else if (dispositivo_selecciono=="TIJERAS") {
            imgCPU.setImageResource(R.drawable.tijeras);

        }
        if (dispositivo_selecciono==elegido){
            empate++;
            //puntos=puntos+6;
            return "EMPATADOS";
        }
        else if (elegido=="PIEDRA"&&dispositivo_selecciono=="TIJERAS"){
            JugadorPuntaje++;
            //puntos=puntos+6;
            return "PIEDRA GANA A TIJERAS, FELICIDADES GANASTE...";
        }
        else if (elegido=="PIEDRA"&&dispositivo_selecciono=="PAPEL"){
            CPUpuntaje++;
            //puntos=puntos-3;
            return "PAPEL GANA A PIEDRA, PERDISTE...";
        }
        else if (elegido=="TIJERAS"&&dispositivo_selecciono=="PIEDRA"){
            CPUpuntaje++;
            ////puntos--;
            return "PIEDRA ROMPE A TIJERAS, PERDISTE...";
        }
        else if (elegido=="TIJERAS"&&dispositivo_selecciono=="PAPEL"){
            JugadorPuntaje++;
            //puntos=puntos+6;
        return "TIJERAS GANA A PAPEL, FELICIDADES GANASTE";
        }
        else if (elegido=="PAPEL"&&dispositivo_selecciono=="PIEDRA") {
            JugadorPuntaje++;
            //puntos=puntos+6;
            return "PAPEL GANA A PIEDRA, FELICIDADES GANASTE";
        }
        else if (elegido=="PAPEL"&&dispositivo_selecciono=="TIJERAS") {
            CPUpuntaje++;
            //puntos=puntos-3;
            return "TIJERAS GANA A PAPEL, PERDISTE";
        } else return "CPU NO SELECCIONA, VUELVE A SELECCIONAR";
    }
}

