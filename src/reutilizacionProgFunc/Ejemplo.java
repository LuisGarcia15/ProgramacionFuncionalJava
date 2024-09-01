package reutilizacionProgFunc;

import java.util.List;
import java.util.function.Function;;

public class Ejemplo {
    public static void main(String[] args) {

        //Colecciones de datos a operar
        List<Integer> puntosA = List.of(1,2,3,4,5);
        List<Integer> puntosB = List.of(2,4,6,8,10);
        List<Integer> puntosC = List.of(3,6,9,12,15);
        List<Integer> puntosD = List.of(4,8,12,16,20);

        /*Representación del flujo del paradigma de programación funcional. No esta simplificada*/
        Function<Integer, Function<Integer, Integer>> modifPuntosFunct = numModifPuntos -> {
            return numero -> numero * numModifPuntos;
        };

        /*Representación del flujo del paradigma de programación funcional. Esta simplificada*/
        Function<Integer, Function<Integer, Integer>> finalModifPuntosFuct = numModifPuntos ->
                                                                             numero ->
                                                                             numero * numModifPuntos;

/*Definición básica de la programación funcional. La expresión lambda se define explicitamente en operación intermedia
* map(). En caso de definir varias lambda cuyo proposito sea el mismom el mantenimiento puede complicarse*/
        List<Integer> puntosAModif = puntosA
                .stream()
                .map(numero -> numero * 2)
                .toList();
        System.out.println(puntosAModif);

/*Definición de una función de orden superior. La expresión lambda se retorna por parte de la función y es la llamada
* a la función lo que se coloca como argumento en la operación intermedia map(). El mantenimiento a código mejora*/
        List<Integer> puntosBModif = puntosB
                .stream()
                .map(modificarPuntos(2))
                .toList();
        System.out.println(puntosBModif);

/*Definición de una función de orden superior. La definición del retorno de flujo de funciones se define en cuestiones
* del paradigma funcional. Se coloca la variable que almacena el flujo de trabajo como parametro de map() y al ser esta
* variable la representación de la interfaz funcional, se tiene que llamar a su método abstracto para comenzar el
* flujo y de hecho pasar como parámetro el numero con el cual multiplica cada elemento de la colección. La mejor
* representación del flujo en terminos de programación funcional. Falta simplificar*/
        List<Integer> puntosCModif = puntosC
                .stream()
                .map(modifPuntosFunct.apply(2))
                .toList();
        System.out.println(puntosCModif);

/*Definición de una función de orden superior. La definición del retorno de flujo de funciones se define en cuestiones
* del paradigma funcional. Se coloca la variable que almacena el flujo de trabajo como parametro de map() y al ser esta
* variable la representación de la interfaz funcional, se tiene que llamar a su método abstracto para comenzar el
* flujo y de hecho pasar como parámetro el numero con el cual multiplica cada elemento de la colección. La mejor
* representación del flujo en terminos de programación funcional ya que encadena llamadas a expresiones lambda, es
* de hecho, la representación mas abstracta de la programación funcional*/
        List<Integer> puntosDModif = puntosD
                .stream()
                .map(finalModifPuntosFuct.apply(2))
                .toList();
        System.out.println(puntosDModif);
    }
    /*Definición de una función de orden superior con el fin de retornar una expresión lambda que toma el parametro de
    * la función para devolver un valor operado. Combina la Programación Funcional con la Programación Orientada A
    * Objetos*/
    public  static Function<Integer, Integer> modificarPuntos(Integer numModifPuntos){
      return numero -> numero * numModifPuntos;
    };
}
