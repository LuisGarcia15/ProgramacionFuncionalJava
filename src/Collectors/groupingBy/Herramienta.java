package Collectors.groupingBy;

public class Herramienta {

    private String tipo;
    private String nombre;

    public Herramienta(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Utencilio{" +
                "tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                "}\n";
    }
}
