package funtionForEach.ejemplo;

import java.util.List;

public class Ejemplo {
    public static void main(String[] args) {
        //Definir la colección
        List<Integer> numeros = List.of(1,2,3,4,5,6,7,8,9,10);
        //Llamada a la función forEach() de la interfaz Iterable
        //recordando que una colecciíon implementa siemple la interfaz
        //Iterable
        numeros.forEach(numero -> System.out.println(numero*100));
    }
}
