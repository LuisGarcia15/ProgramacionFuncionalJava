package matchers;

import java.util.List;

public class Ejemplo {
    public static void main(String[] args) {

        /*Matchers Itera a traves de un predicado numerico.
        * Es por ello que las implementaciones de matchers se
        * encuentran en IntStream*/
        List<String> palabras = List.of("hola", "pera", "peca", "bocina");

        System.out.println(palabras);
        //Matchers ayuda para saber si una colección cumple con una condición

        System.out.println("ALLMATCH");
        //allMatch()
        System.out.println(palabras.stream()
                .allMatch(palabra -> palabra.length() % 2 == 0));

        System.out.println("ANYMATCH");
        //anyMatch()
        System.out.println(palabras.stream()
                .anyMatch(palabra -> palabra.length() % 2 != 0));

        System.out.println("NONEMATCH");
        //noneMatch()
        System.out.println(palabras.stream()
                .noneMatch(palabra -> palabra.length() % 2 != 0));
    }
}
