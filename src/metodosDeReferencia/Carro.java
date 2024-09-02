package metodosDeReferencia;

public class Carro {

    private String nombreMarca;

    public Carro(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public void claxon(String marca){
        System.out.println("El auto de marca | " + marca + " | hace ruido");
    }

    @Override
    public String toString() {
        return "Carro{" +
                "nombreMarca='" + nombreMarca + '\'' +
                '}';
    }
}
