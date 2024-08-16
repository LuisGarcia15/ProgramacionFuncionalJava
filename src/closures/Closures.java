package closures;

import InterfacesFuncionales.EjemploUno;

public class Closures {
    public static void main(String[] args) {
        String palabraUno = "Uno", palabraDos = "Dos", palabraTres = "Tres";

        /*Una expresion lamda o funcion anonima conoce el mundo exterior (permite
        capturar y usar variables en el contexto en que se crean)*/
        EjemploUno interfaz = () -> {
            return palabraUno + " " + palabraDos + " " + palabraTres;
        };

        System.out.println(interfaz.getString());

        interfaz = () -> {
            //palabraUno = "Dos"; - Variable Capturada | no puede cambiar su valor
            String palabraCuatro = "Cuatro"; //Variable local | puede cambiar su valor
            /*Las variables capturadas usadas en una expresion lambda deben ser
            * finales o efectivamente finales. Estas variables son aquellas
            * definidas en el contexto externo de la lamda. Todas la variables
            * definidas o locales en la lamda pueden cambiar su valor sin
            * restricción*/
            palabraCuatro = "Cinco";
            return palabraCuatro;
        };

        System.out.println(interfaz.getString());
    }
}
