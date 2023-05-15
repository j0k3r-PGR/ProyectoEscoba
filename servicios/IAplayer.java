package servicios;

import entidades.Carta;
import entidades.Jugador;
import java.util.ArrayList;

public class IAplayer {

    private static ArrayList<ArrayList<Carta>> posibilidades = new ArrayList();

    // Falta mejorar cuando toca con la pos [0,(1),2,(3)] - 1 y 3 por ejemplo
    // parece que quedo solucionado... seguimos en prueba
    
    /**
     * Funcion que sirve para verificar todas las posibilidades que tiene el jugador
     * de levantar las cartas que sumen 15
     * 
     * 
     * @param jugador Jugador jugador que le toca el turno
     * @param cartasEnMesa ArrayList cartas sobre la mesa
     * @return retorna true si almenos tiene una posibilidad, y false si no encontro
     * ninguna posibilidad
     */
    public static boolean puedeLevantar(Jugador jugador, ArrayList<Carta> cartasEnMesa) {
        int suma;
        boolean levanta = false;
        ArrayList<Carta> aux = new ArrayList();
        ArrayList<Integer> pos = new ArrayList();
        if (!cartasEnMesa.isEmpty()) {
            for (Carta carta : jugador.getMisCartasEnJuego()) {
                for (int i = 0; i < cartasEnMesa.size(); i++) {
                    suma = (7 < Integer.parseInt(carta.getNumero()) ? Integer.parseInt(carta.getNumero()) - 2 : Integer.parseInt(carta.getNumero()));
                    suma += (7 < Integer.parseInt(cartasEnMesa.get(i).getNumero()) ? Integer.parseInt(cartasEnMesa.get(i).getNumero()) - 2 : Integer.parseInt(cartasEnMesa.get(i).getNumero()));
                    if (suma == 15) {
                        aux.add(carta);
                        aux.add(cartasEnMesa.get(i));
                        posibilidades.add(aux);
                        aux = new ArrayList();
                        levanta = true;
                    } else if (suma>15 || (i == (cartasEnMesa.size()-1) && suma < 15) ){
                        aux.clear();
                    }
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
        if(levanta){
            return true;
        }else{
            posibilidades.clear();
            return false;
        }
    }
    
}
