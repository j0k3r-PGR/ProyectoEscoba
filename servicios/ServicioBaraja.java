
package servicios;

import entidades.Baraja;
import entidades.Carta;
import java.util.ArrayList;
import java.util.Collections;

public class ServicioBaraja {
    
    private static Baraja dentroDeLaBaraja;
    private static ArrayList<Carta> fueraDeLaBaraja = new ArrayList();

    /**
     * Creamos nuestra baraja de cartas para iniciar el juego
     * @param es "es" = español \n "fr" = francesa (poker)
     */
    public static void crearMazo(String es) {
        dentroDeLaBaraja = new Baraja(es);
    }
        
    /**
     * Metodo para mezclar las cartas en el juego
     */
    public static void mezclarCartas(){
        Collections.shuffle(dentroDeLaBaraja.getBaraja());
    }

    /**
     * Metodo para que el jugador tome una carta del mazo en juego
     * @return retorna una Carta que se le agregara al jugador
     */
    public static Carta tomarCarta(){
        Carta carta = dentroDeLaBaraja.getBaraja().remove(0);
        fueraDeLaBaraja.add(carta);
        return carta;
    }
    
    /**
     * Metodo el cual toma cartas dentro de la baraja del juego 
     * 
     * @param cantJugadores cantidad de jugadores
     * @param cantPorJugador cantidad de cartas para cada jugador
     * @return 
     */
    public static ArrayList<Carta> repartirCartas(int cantJugadores, int cantPorJugador){
        ArrayList<Carta> salida = new ArrayList();
        int totalCartas = cantJugadores*cantPorJugador;
        if (totalCartas <= dentroDeLaBaraja.getBaraja().size()){
            for (int i = 0; i < totalCartas; i++) {
                salida.add(ServicioBaraja.tomarCarta());
            }
        }
        return salida;
    }
    
    /**
     * Consultar la baraja actual
     * @return la baraja del juego
     */
    public static Baraja getDentroDeLaBaraja() {
        return dentroDeLaBaraja;
    }
    
}
