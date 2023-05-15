package javaapplication5;

import entidades.Carta;
import servicios.IAplayer;
import entidades.Jugador;
import java.util.ArrayList;
import servicios.ServicioBaraja;
import servicios.Serviciojuego;

public class JavaApplication5 {

    public static void main(String[] args) {

        ServicioBaraja.crearMazo("es");
        ServicioBaraja.mezclarCartas();
        
        Jugador j1 = new Jugador("maquina");
        Jugador j2 = new Jugador("mauricio");
        
        Serviciojuego.repartirCartas(j1, j2);
        Serviciojuego.mostrarJuego(j1,j2);
        // Hasta aca funciona perfecto 
        
        if (IAplayer.puedeLevantar(j2, Serviciojuego.cartasEnMesa)){
            if (!IAplayer.getPosibilidades().isEmpty()){
                for (ArrayList<Carta> opciones : IAplayer.getPosibilidades()) {
                    System.out.println(opciones.toString());
                }
            }
        }
    }
}
