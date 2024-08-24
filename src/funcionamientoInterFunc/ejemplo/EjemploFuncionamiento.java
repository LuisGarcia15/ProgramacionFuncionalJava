package funcionamientoInterFunc.ejemplo;

import funcionamientoInterFunc.Implementacion.ImplementacionInterFuncPropia;
import funcionamientoInterFunc.interfazFuncional.InterfazFuncionalPropia;

public class EjemploFuncionamiento {
    public static void main(String[] args) {
        //Existen tres formas de usar un método abstracto de una interfaz funcional

        //Forma 1-. Una clase implementa la interfaz funcional
        // la clase define la lógica del método abstracto
        ImplementacionInterFuncPropia objeto = new ImplementacionInterFuncPropia();
        //La clase sabe como define la lógica y se ejecuta al llamarla desde
        //un objeto instanciado
        System.out.println(objeto.multiplicaPorNumeroDado(3,6));

        //Forma 2-. Se usa una clase anónima para usar el método abstracto
        //Una clase anónima es una clase sin nombre que se define e instancia
        //en el mismo lugar donde se define

        InterfazFuncionalPropia funcion = new InterfazFuncionalPropia() {
            /*Una clase anónima puede usar las variables definidas fuera de ella
             * y las variables que se definen en ella. Dado que "implementa"
             * la interfaz funcional, esta obligada a implementar el método
             * abstracto junto con su lógica*/

            //definimos una clase anónima que implementa el métod abstracto,
            //cuando llamemos la función desde la variable "funcion", ejecutará
            //la lógica del método abstracto
            @Override
            public int multiplicaPorNumeroDado(Integer numero, Integer multiplo) {
                System.out.println("---------- CLASE ANÓNIMA ----------");
                return numero * multiplo;
            }
        };
        //Llamada al método abtracto desde la clase anónima, almacenada en
        //la variable "funcion"
        System.out.println(funcion.multiplicaPorNumeroDado(6,6));

        //Forma 3-. Usando expresiones lambda
        //Similar a almacenar la instancia de una clase anónima en una variable,
        //almacenamos la lógica del método abstrcto en una variable con expresion
        //lambda. La variable tiene que ser del tipo de la interfaz que tiene el
        //método abstracto
        InterfazFuncionalPropia lambda = (x,y) -> {
            System.out.println("---------- EXPRESION LAMBDA ----------");
            return x*y;
        };
        //cuando llamamos al método abstracto desde la variable que almacena la
        //lógica del método abtract (lambda en este caso), se ejecutará la lógica
        //de la expresión lamda

        //La lógica de una expresión lamda siempre esta respaldada por la firma
        //de un método abstracto de una interfaz funcional. sin la firma de un
        //método abstracto no se puede usar las expresiones lamda
        System.out.println(lambda.multiplicaPorNumeroDado(5,5));
    }
}
