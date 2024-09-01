package apiStream.skip.modelos;

//Representación de un Auto. Puede estar daniado o no
public class Auto {
    private final String marca = "Ford";
    private String modelo;
    private Boolean estaDaniado;

    public Auto(String modelo, Boolean estaDaniado) {
        this.modelo = modelo;
        this.estaDaniado = estaDaniado;
    }

    public Boolean getEstaDaniado() {
        return estaDaniado;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", estaDaniado=" + estaDaniado +
                '}';
    }
}
