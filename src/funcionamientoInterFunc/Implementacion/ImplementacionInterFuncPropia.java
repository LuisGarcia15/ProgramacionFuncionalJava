package funcionamientoInterFunc.Implementacion;

import funcionamientoInterFunc.interfazFuncional.InterfazFuncionalPropia;

public class ImplementacionInterFuncPropia implements InterfazFuncionalPropia {

    //Implementa la lógica del método abstracto de la interfaz funcional
    @Override
    public int multiplicaPorNumeroDado(Integer numero, Integer multiplo) {
        System.out.println("---------- IMPLEMENTACIÓN DE LA INTERFAZ FUNCIONAL ----------");
        return numero * multiplo;
    }
}
