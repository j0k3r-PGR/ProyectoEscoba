package javaapplication5;

import servicios.IAplayer;
import entidades.Jugador;
import servicios.ServicioBaraja;
import servicios.Serviciojuego;

public class JavaApplication5 {

    public static void main(String[] args) {

        ServicioBaraja.crearMazo("es");
        ServicioBaraja.mezclarCartas();
        // Hasta aca funciona perfecto
        Jugador j1 = new Jugador("maquina");
        Jugador j2 = new Jugador("mauricio");
        
        Serviciojuego.repartirCartas(j1, j2);
        Serviciojuego.mostrarJuego(j1,j2);

        System.out.println(IAplayer.puedeLevantar(j2, Serviciojuego.cartasEnMesa));
    }
}
