package flatMap.flatMapToInt;

import java.util.Arrays;

public class Ejemplo {
    public static void main(String[] args) {
        /*Imaginemos que tenemos un coleccion con más colecciones
        * dentro. Una lista con mas listas o un array con mas array
        * (Array Bidimencional)*/

        /*Es necesario transformar ese array bidimecional en un array
        * unidimecional*/

        //Definimos el Array Bidimecional para el ejemplo
        int[][] pares = {{2,4,6},{8,12},{14,16}};

        //Forma Imperativa
        //Definimos el tamaño del array unidimencional apartir
        //del mapeo de un array bidimecional
        int[] paresLista = new int[tamanioArrayBidir(pares)];
        //Definimos una variable para apuntar al indice en el
        //array unidimencional
        int indice = 0;

        //Itera cada indice del array bidimencional
        //cada indice tiene un array unidimencional
        for (int[] arr: pares) {
            //Itera cada indice del array bidimencional
            //ya que son array unidimencionales
            for (int element: arr) {
                //Por cada iteración, añade el elemento
                //encontrado al array unidimencioanl paresLista
                paresLista[indice] = element;
                //Aumenta en una unidad la variable para apuntar
                //a la siguiente dirección en memoria y almacenar
                //el elemento
                indice++;
            }
        }
        //Imprime el resultado, transformando un array bidimencional
        //en un array unidimencional en forma imperativa
        System.out.println("Forma imperativa");
        System.out.println(Arrays.toString(paresLista));

        //Forma declarativa
        int[] paresListaFunc = Arrays.stream(pares)
                .flatMapToInt(Arrays::stream)
                .toArray();
        /*En forma declarativa, se convierte en un flujo de Stream
        * de Array[] el arreglo bidimencional, con flatMap transformar cada
        * array[] en un stream de int (con la espcialización IntStram)
        * para al final compactar cada stream de int[] en un solo Stream de int
        * (o IntStream) continuo. La operación terminal es toArray() para convertir el
        * stream en un array unidimencional*/

        //Imprime el resultado, transformando un array bidimencional
        //en un array unidimencional en forma declarativa
        System.out.println("Forma declarativa");
        System.out.println(Arrays.toString(paresListaFunc));

    }
    //Función que obtiene el numero de elementos en un array
    //bidimencional y crear el array unidimencional
    public static int tamanioArrayBidir(int[][] arrb){
        //Definimos una variable para el tamanio final
        int tamanio = 0;
        //Iteramos el array bidimencional, por cada array
        //unidimencioal que tenga, obtenemos su longitud
        for (int[] arr: arrb) {
            tamanio += arr.length;
        }
        //retorna el numero de elementos que tiene el array
        //bidimencional
      return tamanio;
    };
}
