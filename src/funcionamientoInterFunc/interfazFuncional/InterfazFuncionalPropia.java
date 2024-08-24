package funcionamientoInterFunc.interfazFuncional;

@FunctionalInterface
public interface InterfazFuncionalPropia {
    //Una interfaz funcional tiene solo un método abstracto
    //pero puede teenr tantos métodos default como se quiera

    //Solo es posible usar expresiones lambda en métodos abstractos
    int multiplicaPorNumeroDado(Integer numero,Integer multiplo);
}
