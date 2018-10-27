package com.example.a21_pc5.tareanivelacion;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import java.util.List;

public class JugadorAdapter extends ArrayAdapter<Jugador>{
    //TODO constructor con 2 parametros : el contexto y la lista de objetos (Contacto)
    public JugadorAdapter(Context context, List<Jugador> objects) {
        super(context, 0, objects);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obteniendo el dato
        Jugador jugador = getItem(position);
        //TODO inicializando el layout correspondiente al item (Contacto)
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_jugador, parent, false);
        }

        TextView lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
        TextView lblNumero = (TextView) convertView.findViewById(R.id.lblNumero);
        TextView txtPuntaje = (TextView) convertView.findViewById(R.id.txtPuntos);

        // mostrar los datos
        String correlativo = Integer.toString(position + 1);
        lblNumero.setText(correlativo);
        lblNombre.setText(jugador.getNombre());
        txtPuntaje.setText(jugador.getPuntaje());
        // Return la convertView ya con los datos
        return convertView;
    }
}
