package comparator;

import java.util.Arrays;

public class Ejemplo {
    public static void main(String[] args) {
        String[] palabras = {"adios", "ola", "celular"};
        ComparatorImplemetacion comparatorImplemetacion = new ComparatorImplemetacion();
        String bandera;
        //Ejemplo sencillo de compare()
        System.out.println(Arrays.toString(palabras));

        for (int i = 0; i < palabras.length; i++) {
            if(i < palabras.length - 1){
                int valor = comparatorImplemetacion.compare(palabras[i], palabras[i + 1]);
                //Si valor es 1 significa que los valores de los indices están volteados
                //por lo que se debe ordenar
                if(valor == 1){
                    bandera = palabras[i];
                    palabras[i] = palabras[i + 1];
                    palabras[i + 1] = bandera;
                }
            }
        }
        System.out.println("Array luego de usar Comparator");
        System.out.println(Arrays.toString(palabras));
    }
}
