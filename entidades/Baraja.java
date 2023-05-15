package entidades;

import java.util.ArrayList;

/**
 *
 * @author j0k3r
 */
public class Baraja {
    private final static String PALOSES = "ORO,ESPADA,COPA,BASTO";
    private final static String VALORESES = "1,2,3,4,5,6,7,10,11,12";
    private final static String PALOSFR = "PICAS,DIAMANTE,CORAZON,TREBOL";
    private final static String VALORESFR = "A,2,3,4,5,6,7,8,9,10,J,Q,K";
    private ArrayList<Carta> baraja;

    
    /**
     * metodo constructor para crear baraja de cartas españolas "es"
     * o cartas Francesas "fr"
     * @param ingreso "es" or "fr" para crear baraja de cartas
     */
    public Baraja(String ingreso){
        if ("es".equals(ingreso)){
            crearBaraja(PALOSES,VALORESES);
        }else if(ingreso.equals("fr")){
            crearBaraja(PALOSFR,VALORESFR);
        } else{
            System.out.println("adios");
            System.out.println("Parametro ingresado incorrecto, No existe la baraja");
            baraja = null;
        }
    }
    
    private void crearBaraja(String palos,String valores){
        baraja = new ArrayList();
        String[] valoresVector = valores.split(",");
        String[] palosVectores = palos.split(",");
        for (int i = 0; i < palosVectores.length ; i++) {
            for (int j = 0; j < valoresVector.length; j++) {
                baraja.add(new Carta(valoresVector[j],palosVectores[i]));
            }
        }
        //baraja.add(new Carta("JOKER","Blanco"));
        //baraja.add(new Carta("JOKER","Negro")); // aca toy yo!
    }
    
    public ArrayList<Carta> getBaraja() {
        return baraja;
    }
}










/*
    private void crearFrancesas(){
        baraja = new ArrayList();
        String palos = "PICAS,DIAMANTE,CORAZON,TREBOL";
        String valores = "A,2,3,4,5,6,7,8,9,10,J,Q,K";
        String[] valoresVector = valores.split(",");
        String[] palosVectores = palos.split(",");
        for (int i = 0; i < palosVectores.length ; i++) {
            for (int j = 0; j < valoresVector.length; j++) {
                baraja.add(new Carta(valoresVector[j],palosVectores[i]));
            }
        }
        baraja.add(new Carta("JOKER","Blanco"));
        baraja.add(new Carta("JOKER","Negro")); // aca toy yo!
    }
*/
    