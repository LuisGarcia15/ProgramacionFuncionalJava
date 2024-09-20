package reduceBasico;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Ejemplo {
    public static void main(String[] args) {
     /*reduce()
     * Es una función terminal que necesita una REDUCCION en los
     * elementos del stream, usando una función de acumulación
     * ASOCIATIVA y retornando un OPTIONAL
     *
     * reducción: En Java una reducción es un proceso que toma una
     * secuencia de elementos y los combina en un solo resultado
     * por la repetición de una operación de combinación
     *
     * asociativa: operación binaria que aplica una operación
     * a n valores, pero no importa el orden en que la operación
     * sea aplicada, importa el orden de los elementos.
     *
     * reduce() necesita de la interfaz funcional BinaryOperation
     *  para poder ejecutarse
     *
     * BinaryOperation no incluye directamente un SAM, pero hereda
     * la interfaz funcional BiFunction que si incluye un SAM por lo
     * que indirectamente el SAM de una BinaryOperation es el SAM de
     * la BiFunction
     * */

     //Ejercicio: Encontrar el valor más cercano a cero
     List<Integer> numbers = Arrays.asList(-10, 5, 3, -2, 8, 32, 2);
     //La operación asociativa es obtener con compareUnsigned el valor mayor
     //y como Java los compara de una forma especial, obtenemos el valor
     //más cercano a cero.

     //¿Cómo los evalua Java?
     /*
     * compareUnsigned() compara sumando al valor minimo definido para un
     * int al numero x e y, de ahi obtiene el valor mayor. Para un valor
     * con signo, puede causar un desbordamiento, resultando en un valor
     * positivo
     * */
     //De esta forma de evaluación, los numeros con signo pueden ser mayores
     //a los numeros sin signo
        System.out.println(numbers.stream().reduce((num1, num2) -> {
            if(Integer.compareUnsigned(num1, num2) > 0){
                return num1;
            }else{
                if(Integer.compareUnsigned(num1, num2) < 0){
                    return num2;
                }else{
                    return num1;
                }
            }
        }));
    }
}
