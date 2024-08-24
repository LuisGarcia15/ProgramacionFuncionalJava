package iterable.HOFCallbacks;

import iterable.InterfacesFuncionales.EjemploUno;

public class HOFCallbacks {
    public static void main(String[] args) {

        /*CallBacks: Aquella función que se pasa como parámetro
        * a otra función*/
        System.out.println(HOFParametros(()->{
            return "Hola mundo desde HOFParametros";
        }));

        System.out.println("*******************************");

        /*CallBacks: Aquella función que se pasa como parámetro
         * a otra función*/
        System.out.println(HOFParametros(HOFreturn()));

    }

    /*High Orden Function que acepta funciones como parámetro*/
    public static String HOFParametros(EjemploUno funct){
        String result = funct.getString();
        return result;
    }

    /*High Order Function que retorna una función como valor de retorno*/
    public static EjemploUno HOFreturn(){
        return () -> {
            return "Hola mundo desde HOFReturn";
        };
    }
}
