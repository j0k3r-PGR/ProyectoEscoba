package servicios;

import entidades.Carta;
import entidades.Jugador;
import java.util.ArrayList;
import java.util.Random;

public class IAplayer {
    private static final Carta ORO7 = new Carta("7","ORO");
    private static final Carta COPA7 = new Carta("7","COPA");
    private static final Carta ESPADA7 = new Carta("7","ESPADA");
    private static final Carta BASTO7 = new Carta("7","BASTO");
    private static ArrayList<ArrayList<Carta>> posibilidades;
    private static ArrayList<ArrayList<Carta>> aux = new ArrayList();
    // Falta mejorar cuando toca con la pos [0,(1),2,(3)] - 1 y 3 por ejemplo
    // parece que quedo solucionado... seguimos en prueba
    
    /**
     * Funcion que sirve para verificar todas las posibilidades que tiene el jugador
     * de levantar las cartas que sumen 15 y las agrega al ArrayList posibilidades
     * que se encuentra en la clase y despues trabajar con ello en el metodo
     * analizarJugadaIaYLevantar() que se encuentra en esta misma clase
     * 
     * @param jugador Jugador jugador que le toca el turno
     * @param cartasEnMesa ArrayList cartas sobre la mesa
     * @return retorna true si almenos tiene una posibilidad, y false si no encontro
     * ninguna posibilidad
     */
    public static boolean puedeLevantar(Jugador jugador, ArrayList<Carta> cartasEnMesa) {
        int suma;
        posibilidades = new ArrayList();
        posibilidades.clear();
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
                        pos.add(cartasEnMesa.indexOf(cartasEnMesa.get(i)));
                        suma = (7 < Integer.parseInt(carta.getNumero()) ? Integer.parseInt(carta.getNumero()) - 2 : Integer.parseInt(carta.getNumero()))+ (7 < Integer.parseInt(cartasEnMesa.get(i).getNumero()) ? Integer.parseInt(cartasEnMesa.get(i).getNumero()) - 2 : Integer.parseInt(cartasEnMesa.get(i).getNumero()));
                        for (int j = i + h; j < cartasEnMesa.size(); j++) {
                            pos.add(cartasEnMesa.indexOf(cartasEnMesa.get(j)));
                            suma += (7 < Integer.parseInt(cartasEnMesa.get(j).getNumero()) ? Integer.parseInt(cartasEnMesa.get(j).getNumero()) - 2 : Integer.parseInt(cartasEnMesa.get(j).getNumero()));
                            if (suma == 15) {
                                aux.add(carta);
                                for (Integer posicion : pos) {
                                    aux.add(cartasEnMesa.get(posicion));
                                }
                                posibilidades.add(aux);
                                aux = new ArrayList();
                                levanta = true;
                            }else if(suma > 15){
                                aux.clear();
                                pos.clear();
                            }
                        }
                        pos.clear();
                    }
                }
            }
        }
        if(levanta){
            return true;
        }else{
            posibilidades.clear();
            System.out.println(posibilidades);
            return false;
        }
    }

    /*
        En este metodo tenemos que analizar la mejor jugada posible
        por ejemplo si en nuestro ArrayList hay una combinacion que 
        contenga el 7 de oro que utilize esa y la agregue a su monton
        si no seguir viendo posibilidades del juego para que la ia 
        juegue como una persona y simular su pensamiento
    */
    public static void analizarJugadaIaYLevantarOtirar(Jugador jugador, ArrayList<Carta> cartasEnMesa){
        
        
        System.out.println(contains7());
        if(contains7() > 1){
            System.out.println("-------"+mejorJugadaOro());
        }else if (contains7() == 1){
            System.out.println("-------"+aux.get(0));
        }
        
        for (ArrayList<Carta> posibilidad : posibilidades) {
            System.out.println(posibilidad);
        }
        
    }
    
    
    public static ArrayList<ArrayList<Carta>> getPosibilidades() {
        return posibilidades;
    }
    
    
    private static int contains7(){
        for (ArrayList<Carta> posibilidad : posibilidades) {
            for (Carta carta : posibilidad) {
                if(ORO7.equals(carta)){
                    aux.add(posibilidad);
                    
                }else if (COPA7.equals(carta) || ESPADA7.equals(carta) || BASTO7.equals(carta)){
                    aux.add(posibilidad);
                }
            }
        }
        return aux.size();
    }
    
    private static ArrayList<Carta> mejorJugadaOro(){
        ArrayList<Carta> mejor = new ArrayList();
        int oroMayor = 0, oroActual;
        for (ArrayList<Carta> jugada : IAplayer.aux) {
            oroActual = buscarOro(jugada);
            if (oroMayor < oroActual){
                oroMayor = oroActual;
                mejor = jugada;
            }
        }
        return mejor;
     }
    
    private static int buscarOro(ArrayList<Carta> cartas){
        int contador = 0;
        
        for (Carta carta : cartas) {
            if (carta.getPalo().equals("ORO")){
                contador++;
            }
        }
        return contador;
    }
    
}



/*
        Sirve para elejir un juego al azar de los posibles!
        */
//        Random rn = new Random();
//        if(puedeLevantar(jugador, cartasEnMesa)){
//            ArrayList<Carta> azar = posibilidades.get(rn.nextInt(posibilidades.size()));
//            int azarLongitud = azar.size();
//            for (int i = 0; i < azarLongitud; i++) {
//                jugador.getMiMontonCartas().add(azar.get(i));
//                if (i == 0){
//                    System.out.println(azar.get(i));
//                    jugador.getMisCartasEnJuego().remove(azar.get(i));
//                }else {
//                    System.out.println(azar.get(i));
//                    cartasEnMesa.remove(azar.get(i));
//                }
//            }
//        }else {
//            int aux = rn.nextInt(jugador.getMisCartasEnJuego().size());
//            cartasEnMesa.add(jugador.getMisCartasEnJuego().remove(aux));
//        }