package servicios;

import entidades.Carta;
import entidades.Jugador;
import java.util.ArrayList;

public class Serviciojuego {
    public static ArrayList<Carta> cartasEnMesa;
    
    public static void repartirCartas(Jugador j1, Jugador j2){
        ArrayList<Carta> aRepartir = ServicioBaraja.repartirCartas(2, 3);
        int cont = 0;
        for (Carta carta : aRepartir) {
            if (cont%2 == 0){
                j1.getMisCartasEnJuego().add(carta);
            }else{
                j2.getMisCartasEnJuego().add(carta);
            }
            cont++;
        }
        cartasEnMesa = ServicioBaraja.repartirCartas(1, 4);
    }
    
    public static void mostrarJuego(Jugador jugador1, Jugador jugador2){
        int i = 1;
        System.out.println("Cartas PC:");
        ServicioJugador.cartasEnMano(jugador1);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Cartas en mesa: ");
        for (Carta carta : cartasEnMesa) {
            System.out.println(i++ +"- "+carta);
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\nCartas Mias:");
        ServicioJugador.cartasEnMano(jugador2);
    }
    
}
