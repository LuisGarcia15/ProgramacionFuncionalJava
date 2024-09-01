package apiStream.filter;

import java.util.List;
import java.util.stream.Stream;

public class FilterEjemplo {
    public static void main(String[] args) {

        //Definimos una lista inmutable, que será la fuente para
        //generar un flujo
        List<Integer> numeros = List.of(100, 200, 300, 400, 500, 600, 700, 800, 900, 1000);

        //Imprimimos la lista original antes de evaluar un predicado
        System.out.println("----- Lista sin predicado -----");
        System.out.println(numeros);

        //Aplicamos un flujo a la lista, un flujo siempre retorna
        //un Stream<T>, donde T es el tipo de la fuente
        Stream<Integer> flujo = numeros.stream();

        //Definimos una lista donde se almacenará la evaluación de
        //la lista original para obtener una lista filtrada
        final List<Integer> numerosFiltrados;

        //Aplicamos las operaciones intermedias al flujo y aplicamos
        //una operación terminal para obtener la lista filtrada

        //La operación intermedia es filter(), filter() necesita una implementación
        //de Predicate para generar una evaluación booleana en forma de expresión lambda

        //La interfaz Pedicate es una interfaz funcional, que solo tiene un
        //método abstracto que recibe un valor y obtiene un resultado booleana
        //de la evaluación del valor que recibe

        //La operaciíon terminal es toList(), ya que las operaciones intermedias
        //devulven un Stream<T> donde T es el tipo de la fuente. toList() convierte
        //ese flujo a una lista que puede almacenarse en la lista de filtrado
        numerosFiltrados = flujo.filter(numero -> numero > 500).toList();

        //Imprimimmos el resultado de la lista mutada
        System.out.println("----- Lista filtrada -----");
        System.out.println(numerosFiltrados);
    }
}
