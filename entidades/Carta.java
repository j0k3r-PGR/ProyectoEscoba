
package entidades;

public class Carta {
    private String numero;
    private String palo;

    public Carta(String numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public String getNumero() {
        return numero;
    }

    public String getPalo() {
        return palo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("numero= ").append(numero);
        sb.append("-- palo= ").append(palo);
        return sb.toString();
    }

}
