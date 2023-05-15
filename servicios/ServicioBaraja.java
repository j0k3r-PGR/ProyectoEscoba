
package servicios;

import entidades.Baraja;
import entidades.Carta;
import java.util.ArrayList;
import java.util.Collections;

public class ServicioBaraja {
    
    private static Baraja dentroDeLaBaraja;
    private static ArrayList<Carta> fueraDeLaBaraja = new ArrayList();
    
    public static void crearMazo(String es) {
        dentroDeLaBaraja = new Baraja(es);

    }
    
    public static void mezclarCartas(){
        Collections.shuffle(dentroDeLaBaraja.getBaraja());
    }

    public static Carta tomarCarta(){
        Carta carta = dentroDeLaBaraja.getBaraja().remove(0);
        fueraDeLaBaraja.add(carta);
        return carta;
    }
    
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

    public static Baraja getDentroDeLaBaraja() {
        return dentroDeLaBaraja;
    }
    
}
