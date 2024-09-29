package reduceAvanzado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejemplo {
    public static void main(String[] args) {
        List<String> palabras = Arrays.asList("Uno", "Dos", "Tres");

        /*Para el contexto de reduce podemos tomar el concepto de monoides mátematicos
        * en teoria de conjuntos, sea (A, *, e), donde A es un conjuto A no vacio, * es
        * una operación binaria asociativa y e un valor neutro existente en A cuya operación
        * conmutativa es valida para cada elemento de A e * a = a * e. El elemento neutro es
        * un valor que al operarse por una operación binaria junto a un elemento del conjunto
        * A no se afecto el elemento*/

        /*El conjuto es la colección al que sera sometido por un flujo Stream
        *
        *La identidad es similar al elemeto neutroe en un monoide, no debe modificar
        * ningun elemento del conjunto
        *
        * la operación binaria es una bifunción que produce un resumen de todos
        * los elementos del conjunto o colección. Es un acumulador
        *
        *La combinación es una bifunción que combina los  sub-flujos que se procesan en paralelo,
         cada sub-flujo puede tener su propio resultado acumulado. Esto solo es usado en programación
         en paralelo
         * */

        //El método reduce() sobrecardado de uno y dos parámetros siempre se utilizan en operaciones
        //paralelas

        //El método reduce() de dos parametros utiliza un elemento identidad y un acumulador
        String resultado1 = palabras.stream().reduce("", (a,b) -> a + " " + b);
        /*El método toma el valor de la identidad y lo junto al primer elemento de la colección,
        * su resultado lo une al segundo elemento de la colección y así sucesivamente.*/

        //El método reduce() sobrecardado de tres parámetros solo utiliza el primer y segundo parametro
        //en una operación No parela, utilizara el tercer parametro en una operación paralela


        //El método reduce() sobrecardado de tres parámetros solo utiliza el primer y segundo parametro
        //en una operación NO parela, utilizara el tercer parametro(combinador) en una operación paralela
       ArrayList<String> resultado2 = palabras.stream()
               .reduce(new ArrayList<String>(),
                       (lista, elemento) -> {
                        lista.add(elemento);
                    return lista;
                       },
                       (lista1, lista2) -> {
                        lista1.addAll(lista2);
                        lista1.add("Cuatro");
                   return lista1;
               });

        System.out.println(resultado1);
        System.out.println(resultado1.getClass());

        System.out.println(resultado2);
        System.out.println(resultado2.getClass());

    }
}
