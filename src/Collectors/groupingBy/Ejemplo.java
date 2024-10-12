package Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejemplo {
    public static void main(String[] args) {
        /*Clase Collector
        * Realiza un operación mutable de reducción, y que opcionalmente transforma
        * el resultado acumulado en una representación final luego de que todos los
        * elementos hayan sido procesados
        *
        * Collectors
        * Implementación de Collector que implementa varias operaciones útiles de reucción.
        * realizando operaciones de reducción y operaciones mutables de reducción*/

        /*Operación de reducción
        * Dada una entrada de datos, combina cada elemento en un resultado resumen,
        * por la aplicación de una operación de acumulación. Como la suma o sum().
        *
        * Reducción mutable
        * Acumula elementos de entrada en un contenedor mutable como resultado, como
        * un Collection o un StringBuilder*/
        List<Herramienta> herramientas = List.of(
                new Herramienta("Cocina", "Cuchara"),
                new Herramienta("Carpinteria", "Martillo"),
                new Herramienta("Cocina", "Espatula"),
                new Herramienta("Carpinteria", "Tornillo"),
                new Herramienta("Cocina", "Coladera"),
                new Herramienta("Carpinteria", "Serrucho"),
                new Herramienta("Cocina", "Sartén"),
                new Herramienta("Programación", "Computadora")
        );
        /*El ejemplo es una lista de objetos de tipo Herramienta, donde tiene
        * un atributo tipo que es a que trabajo corresponde la herramenta y
        * un atributo nombre que es el nombre de la herramienta.
        *
        * El objetivo es agrupar las herramientas a partir de su tipo. Por lo que
        * el MAP resultante es un Map cuyas llaves son String y son el tipo de
        * herramienta que existen en la lista y la lista que almacena a cada
        * llave sera de tipo Herramientas.
        *
        * La función de clasificación obtendra entonces el tipo de herramienta
        * que es y estos mismos seran las llaves del Map.*/
        Map<String, List<Herramienta>> map = herramientas.stream()
                .collect(Collectors.groupingBy(Ejemplo::obtenerTipo));
        //collect()
        //Realiza una operación mutable de reducción en un Stream usando un Collector

        //groupingBy()
        /*Implementa una operación de agrupamiento. Agrupa elementos de acuerdo a una
        * función de clasificación (que necesita el método). Retorna los agrupamientos en un Map.
        * Es una operación de reducción por que opera a cada elemento y lo agrupa bajo un
        * valor, gracias a la función de agrupación.
        *
        * Las llaves del Map serán el resultado de la la función de clasificación y asociará
        * a una Lista del tipo original de datos procesados.*/

        System.out.println(map);

    }

    public static String obtenerTipo(Herramienta herramienta){
        return herramienta.getTipo();
    }
}
