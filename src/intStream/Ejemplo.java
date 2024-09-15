package intStream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Ejemplo {
    public static void main(String[] args) {

        int[] numero = {0,1,2,5,3,6,8,7,1,56,5,4,9,5,63,65,65};

        //Sumar todos los elementos de una colección
        System.out.println("SUMA - INTSTREAM");
        System.out.println(Arrays.stream(numero).sum());

        //Encuentra el elemento minimo en una colección
        System.out.println("MIN - INTSTREAM");
        System.out.println(Arrays.stream(numero).min().orElseThrow());

        //Encuentra el elemento maximo en una colección
        System.out.println("MAX - INTSTREAM");
        System.out.println(Arrays.stream(numero).max().orElseThrow());

        //Encuentra el promedio en una colección
        System.out.println("AVERAGE - INTSTREAM");
        System.out.println(Arrays.stream(numero).average().orElseThrow());

        //Encuentra el número de elementos en una colección
        System.out.println("COUNT - INTSTREAM");
        System.out.println(Arrays.stream(numero).count());

        //Devuelve una colección sin elementos repetidos
        System.out.println("DISTINCT - INTSTREAM");
        System.out.println(Arrays.toString(Arrays.stream(numero).distinct().toArray()));

        //Devuelve una colección con los elementos ordenaos
        System.out.println("SORT - INTSTREAM");
        System.out.println(Arrays.toString(Arrays.stream(numero).sorted().toArray()));

        /*Método especial cuyo proposito es convertir un Array en un flujo de datos,
        * apartir de eso puedes convertir el flujo en una lista.
        * Un array no puede convertirse directamente en una Lista
        * Una Lista si puede convertirse directamente en un Array*/
        System.out.println("BOXED - INTSTREAM");
        System.out.println(Arrays.stream(numero).distinct().boxed().toList());
    }
}
