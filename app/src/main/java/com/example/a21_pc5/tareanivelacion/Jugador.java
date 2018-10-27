package com.example.a21_pc5.tareanivelacion;

import java.io.Serializable;

public class Jugador implements Serializable {
    String Nombre;
    String Puntaje;

    public Jugador(String Nombre){
        this.Nombre = Nombre;
        this.Puntaje = Puntaje;

    }
    public String getNombre() { return Nombre;
    }
    public void setNombre(String Nombre){this.Nombre = Nombre;}

    public String getPuntaje(){return Puntaje;
    }

    public void setPuntaje(String Puntaje) {
        this.Puntaje = Puntaje;
    }
}
