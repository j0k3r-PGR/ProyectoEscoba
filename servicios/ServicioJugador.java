
package servicios;

import entidades.Carta;
import entidades.Jugador;
import java.util.ArrayList;

public class ServicioJugador {
    
    public static void tomarCartaDeLaBaraja(Jugador jugador){
        jugador.getMisCartasEnJuego().add(ServicioBaraja.tomarCarta());
    }
    
    public static void recibirCarta(Jugador jugador, Carta carta){
        jugador.getMisCartasEnJuego().add(carta);
    }
    
    public static void cartasAMiMonton(Jugador jugador, ArrayList<Carta> cartasLevantadas){
        for (Carta cartasLevantada : cartasLevantadas) {
            jugador.getMiMontonCartas().add(cartasLevantada);
        }
    }
    
    public static Carta tirarCartaEnMesa(Jugador jugador,int index){
        return jugador.getMisCartasEnJuego().remove(index);
    }
    
    public static void cartasEnMano(Jugador jugador){
        int i = 1;
        for (Carta carta : jugador.getMisCartasEnJuego()) {
            System.out.println(i++ + "-" + carta);
        }
    }
    
}
