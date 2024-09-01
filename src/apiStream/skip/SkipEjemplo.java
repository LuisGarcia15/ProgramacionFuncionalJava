package apiStream.skip;

import apiStream.skip.modelos.Auto;

import java.util.List;

public class SkipEjemplo {
    public static void main(String[] args) {
        /*Ejemplo hipotetico de una lista de autos, los cuales
        * estan ordenados, como primeros n elementos están los
        * autos que no estan dañados, los siguientes elementos
        * son los autos que estan dañados y que necesitamos
        * obtener de esa lista para un registro y así arreglarlos*/

        //Lista ordenada de autos
        List<Auto> autos = List.of(
              new Auto("X5", false),
                new Auto("X5", false),
                new Auto("X6", false),
                new Auto("X6", false),
                new Auto("X5", true),
                new Auto("X6", true)
        );

        /*Obtenemos el número de Autos que estan daniados gracias
        * a filter.
        *  - La fuente de datos es la lista de autos ordenada con autos
        * descompuestos y autos en buen estado
        * - La operacion intermedia es la funcion filter() que filtra
        * los elementos, obteniendo así elementos que NO estan daniados
        * - La operacion terminal es la funcion count() que devuelve el
        * numero de elementos en el stream*/
        long numAutosDaniados = autos.stream().filter(
                auto -> !auto.getEstaDaniado()
        ).count();

        /*Obtenemos los autos que estan daniados gracias a la función skip(),
        * este ejemplo funciona ya que la lista original esta ordenada y podemos
        * descartar los primeros n elementos sabiendo cuales autos no estan
        * en mal estado.
        * - La fuente de datos es la lista de autos ordenada con autos
        * descompuestos y autos en buen estado.
        * - La operación itermedia es la función skip() que salta aquellos autos
        * en buen estado gracias a que sabemos cuantos elementos en buen estado
        * hay en la lista.
        * - La operación terminal es la funcion toList() que, los Autos que restan
        * y que estan en mal estado en el Stream, los convierte a una lista y asi
        * obtener una lista solo con aquellos elementos deseados*/
        List<Auto> autosDaniados = autos.stream().skip(numAutosDaniados).toList();

        //Imprimimos la lista con los autos en mal estado
        System.out.println(autosDaniados);
    }
}
