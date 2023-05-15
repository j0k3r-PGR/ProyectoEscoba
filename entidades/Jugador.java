
package entidades;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Carta> misCartasEnJuego = new ArrayList();
    private ArrayList<Carta> miMontonCartas = new ArrayList();
    private int puntos = 0;
    
    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Carta> getMisCartasEnJuego() {
        return misCartasEnJuego;
    }

    public ArrayList<Carta> getMiMontonCartas() {
        return miMontonCartas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
}
