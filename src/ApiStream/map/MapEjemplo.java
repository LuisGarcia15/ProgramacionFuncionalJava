package ApiStream.map;

import java.util.List;
import java.util.stream.Stream;

public class MapEjemplo {
    public static void main(String[] args) {

        //Definimos una lista inmutable, que será la fuente para
        //generar un flujo
        List<String> nombres = List.of("Luis", "Jaime", "Jessica", "Alejandro");

        //Imprimimos la lista original antes de mutarse
        System.out.println("----- Lista sin mutar -----");
        System.out.println(nombres);

        //Aplicamos un flujo a la lista, un flujo siempre retorna
        //un Stream<T>, donde T es el tipo de la fuente
        Stream<String> flujo = nombres.stream();

        //Definimos una lista donde se almacenará la mutación de
        //la lista original
        final List<String> nombresMutacion;

        //Aplicamos las operaciones intermedias al flujo y aplicamos
        //una operación terminal para obtener la lista mutada

        //La operación intermedia es map(), map() necesita una implementación
        //de Function para generar una función en forma de expresión lambda

        //La interfaz Function es una interfaz funcional, que solo tiene un
        //método abstracto que recibe un valor, y retorna un valor

        //La operaciíon terminal es toList(), ya que las operaciones intermedias
        //devulven un Stream<T> donde T es el tipo de la fuente. toList() convierte
        //ese flujo a una lista que puede almacenarse en la lista de mutación
        nombresMutacion = flujo.map(nombre -> {
            nombre += " [" + nombre.length() + "]";
            return nombre;
        }).toList();

        //Imprimimmos el resultado de la lista mutada
        System.out.println("----- Lista mutada -----");
        System.out.println(nombresMutacion);
    }
}
