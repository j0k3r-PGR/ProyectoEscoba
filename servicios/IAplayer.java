package servicios;

import entidades.Carta;
import entidades.Jugador;
import java.util.ArrayList;

public class IAplayer {

    private static ArrayList<ArrayList<Carta>> opciones = new ArrayList();

    // Falta mejorar cuando toca con la pos [0,(1),2,(3)] - 1 y 3 por ejemplo
    // parece que quedo solucionado... seguimos en prueba
    public static boolean puedeLevantar(Jugador jugador, ArrayList<Carta> cartasEnMesa) {
        int suma;
        IAplayer.opciones = null;
        if (!cartasEnMesa.isEmpty()) {
            for (Carta carta : jugador.getMisCartasEnJuego()) {
                for (int i = 0; i < cartasEnMesa.size(); i++) {
                    suma = (7 < Integer.parseInt(carta.getNumero()) ? Integer.parseInt(carta.getNumero()) - 2 : Integer.parseInt(carta.getNumero()));
                    suma += (7 < Integer.parseInt(cartasEnMesa.get(i).getNumero()) ? Integer.parseInt(cartasEnMesa.get(i).getNumero()) - 2 : Integer.parseInt(cartasEnMesa.get(i).getNumero()));
                    if (suma == 15) return true;
                    for (int h = 1; h < cartasEnMesa.size() - i; h++) {
                        suma = (7 < Integer.parseInt(carta.getNumero()) ? Integer.parseInt(carta.getNumero()) - 2 : Integer.parseInt(carta.getNumero()))+ (7 < Integer.parseInt(cartasEnMesa.get(i).getNumero()) ? Integer.parseInt(cartasEnMesa.get(i).getNumero()) - 2 : Integer.parseInt(cartasEnMesa.get(i).getNumero()));
                        for (int j = i + h; j < cartasEnMesa.size(); j++) {
                            suma += (7 < Integer.parseInt(cartasEnMesa.get(j).getNumero()) ? Integer.parseInt(cartasEnMesa.get(j).getNumero()) - 2 : Integer.parseInt(cartasEnMesa.get(j).getNumero()));
                            if (suma == 15)  return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    

}
