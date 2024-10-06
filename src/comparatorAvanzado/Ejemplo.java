package comparatorAvanzado;

import java.util.Comparator;
import java.util.List;

public class Ejemplo {
    public static void main(String[] args) {
        //Lista de ejemplo
        List<String> palabras = List.of(
                "nintendo",
                "apple",
                "IA" ,
                "universidad",
                "perro",
                "mouse",
                "sol");
        List<String> palabrasDos = List.of(
                "Corazon",
                "Amigos",
                "Espacio",
                "Cultura",
                "Exprso",
                "Alpis");

        //Implementación del SAM de Comparator
        Comparator<String> comparator = Ejemplo::impComparatorUno;
        //Ordena la lista por la implementación de SAM, donde ordena por longitud de palabras de menor a mayor
        imp(palabras.stream().sorted(comparator).toList());
        //Ordena la lista por la implementación de SAM, donde ordena por longitud de palabras, además
        //devuelve el comparador con el ordenamiento al revez, por lo que ordena de mayor a menor con .reversed()
        imp(palabras.stream().sorted(comparator.reversed()).toList());
        /*sorted() sabe como ordenar cadenas, comparando la primera letra de cada palabra y ordenando por códgio ascii,
        * las palabras con menor valor en el código ascii van primero*/
        imp(palabras.stream().sorted().toList());
        /*A esa implementación de ordenamiento de sorted() de las cadenas, llamamos al método estatico reverseOrder()
        * que devulelve el ordenamiento al revez , ahora la palabras con mayor valor en el código ascii van primero*/
        imp(palabras.stream().sorted(Comparator.reverseOrder()).toList());

        //Comparing()

        /*Esta implementación de comparing necesita la implementación del SAM de Funtion, dado una key de los elementos
        * a comparar, crear un comparator para odenar con esa key, odenar las palabras con menor valor en el código
        * ascii dada su tercera letra*/
        imp(palabras.stream().sorted(Comparator.comparing(Ejemplo::obtenerLetras)).toList());

        /*Esta implementación de comparing necesita la implementación del SAM de Funtion, dado una key de los elementos
        * a comparar, y una implementación del SAM de Comparator que ordene por la key del SAM de Function. Devolvera
        * un comparador que tenga la lógica de ambos SAM's. En este caso obtedra de cada palabra su letra en la tercera
        * posición y ordenara en una lista las pabras con menor valor en el códgio ascii de menor a mayor*/
        imp(palabrasDos.stream().sorted(Comparator.comparing(Ejemplo::obtenerCaracter, Ejemplo::impComparatorDos)).toList());

        //thenComparing()

        /*thenComparing es una segunda capa de ordenamiento cuando la capa anterior no pudo ordnar por que la estructura
        * del dato es la misma y es por ello que debe utilizar esa segunda capa*/
        imp(palabrasDos.stream().sorted(
                Comparator.comparing(
                        Ejemplo::obtenerCaracter, Ejemplo::impComparatorDos).thenComparing(Ejemplo::impComparatorUno)
                ).toList()
                /*En este caso obtedra de cada palabra su letra en la tercera
                 * posición y ordenara en una lista las palabras con base en su terceca letra con  valor en el
                 * códgio ascii de menor a mayor, pero si la palabra es la misma, entonces thenComparing ejecutara
                 * su segunda capa de ordenamiento, lo hara ordenando esas palabras donde la letra en la tercera
                 * posición es la misma y las ordenara por logitud de tamaño de palabra */
        );
    }
    //Implementación del SAM de Comparator, compara por la longitud de palabras
    public static int impComparatorUno(String palabraUno, String palabraDos){
        return palabraUno.length() - palabraDos.length();
    }
    //Implementación del SAM de Comparator, compara por código ascii dos caracteres
    public static int impComparatorDos(char caracterUno, char caracterDos){
        return caracterUno - caracterDos;
    }

    public static void imp(Object o){
        System.out.println(o);
    }
    //Implementación del SAM de Function, Obtiene una key de una palabra
    public static String obtenerLetras(String palabra){
        return palabra.substring(palabra.length()-1);
    }
    //Implementación del SAM de Function, Obtiene una key de una palabra
    public static char obtenerCaracter(String palabra){
        return palabra.charAt(2);
    }
}
