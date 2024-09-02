package metodosDeReferencia;

import java.util.List;

public class Ejemplo {
    public static void main(String[] args) {
        /*La forma común de definir la lógica de un método
        * abstracto es usar una expresión lambda, cuyo contenido
        * es el algoritmo des método abstracto*/
        List<String> frutas = List.of("Sandia", "Naranja", "Mandarina");
        System.out.println(frutas
                .stream()
                .map(fruta -> fruta + " " + fruta.length())
                .toList()
        );
        /*Se observa que el parametro de la funcion map() es el algoritmo
        * de trasformacion*/

        //¿Qué pasa entonces si existen métodos a lo largo de la libreria de JAVA
        //o métodos que nosostros mismo tenemos definidos que hacen exactamente
        //la acción del algoritmo de una expresión lambda?

        //Metodos de referencia
        /*Las referencias a métodos en Java son una forma de hacer que el código
        sea más conciso y legible al referirse directamente a métodos que cumplen
        con las firmas de métodos abstractos de una interfaz funcional. En otras
        palabras, se utilizan para proporcionar una implementación de un método
        funcional sin tener que escribir explícitamente una expresión lambda.

        Un método de referencia puede hacer "referencia" a un método que cumpla las
        firmas del método abstracto que se necesita o hacer referencia a la
        expresión lambda que cumpla con la firma de la expresión lambda necesaria*/

        System.out.println("Referencia a un método estático: ClassName::staticMethodName");

        //1.Referencia a un método estático: ClassName::staticMethodName
        System.out.println(frutas.stream()
                .map(StringUtils::nombreMasNumLetras)
                .toList());
        /*El objetivo de este tipo de método de referencia es colocar el origen del método,
        * cuya acción ya esta desarrollada y no es necesaria una función lambda. La caracteristica
        * de este método de referencia es que el método existe en alguna clase y es estatico*/

        //2. Referencia a un método de instancia de un objeto específico: instance::instanceMethodName
        System.out.println("Referencia a un método de instancia de un objeto específico: instance::instanceMethodName");
        Carro carro = new Carro("Ford");
        Claxon claxon = carro::claxon;
        claxon.claxon(carro.getNombreMarca());
        /*Cuando usas una referencia a un método de instancia de un objeto específico, estás
        aprovechando un método existente en un objeto específico que coincide con la firma del
        método abstracto de una interfaz funcional. La interfaz funcional en este ejemplo es
        Claxon, el objeto especifico es carro de la clase Carro cuyo método que coincide con
        la firma es claxon()*/


        //3. Referencia a un constructor: ClassName::new
        System.out.println("Referencia a un constructor: ClassName::new");
        List<String> nombresCarros = List.of("Ford", "Volkswagen", "Hyundai", "Nissan");
        List<Carro> carros =nombresCarros.stream()
                .map(Carro::new)
                .toList();
        System.out.println(carros);
        /*Cuando se usa una referencia a un método de constructor, se aprovecha
        * de crear un objeto haciendo referencia al constructor de la clase que
        * se quiere instancias para obtener los objetos en vez de definir la
        * expresión lambda equivalente. Al final el consturcor hace lo mismo que
        * si lo definiras por lambda*/

        //4. Referencia a un método de instancia de un objeto arbitrario de una clase: ClassName::instanceMethodName
        System.out.println("Referencia a un método de instancia de un objeto arbitrario de una clase: ClassName::instanceMethodName");
        List<String> nombresCarrosDos = carros.stream()
                .map(Carro::getNombreMarca)
                .toList();
        System.out.println(nombresCarrosDos);
        /*Cuando se usa la referencia a un método de constructor, se aprovecha
        * de usar la lógica de un método definido para instancia en una clase,
        * de esta forma se hace referencia al método de instancia de la clase
        * en vez de definir una expresión lambda. Al final seria redundante definir
        * una lambda si ya existe un método que cumple la firma del método abtracto
        * al cual se hace referencia*/
    }
}
