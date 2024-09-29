package joinYIterarCadenaFuncional;

import java.util.Arrays;

public class Ejemplo {
    public static void main(String[] args) {
        /*Como vimos en reduce(), es posible concatenar
        * Strings medicante una operación binaria asoiciativa.*/

        String[] palabras = {"Java", "JS", "Python"};
        System.out.println("Reduce");
        System.out.println(Arrays.stream(palabras)
                .reduce((pal1, pal2) ->pal1 + " - " + pal2).orElseThrow());

        /* Esto no es la mejor opción, ya que existe una implementación
        * de esta operación en la Api de String*/

        System.out.println("Implemetación String");
        System.out.println(String.join(" |---$---| ", palabras));

        /*Como iterar sobre una cadena de forma funcional
        * String no tiene ningún método que devueva un Stream de datos
        * pero tiene un método que devuelve un IntStream
        *
        * Devuelve un IntStream pues devuelve la representación de cada
        * letra de la cadena en código ASCII (valor númerico), siempre
        * que sea posible*/
    }
}
