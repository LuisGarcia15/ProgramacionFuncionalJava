package comparator;

import java.util.Comparator;

public class ComparatorImplemetacion implements Comparator<String> {
    //Retorna -1 si o1 < o2
    //Retorna 0 si o1 = o2
    //Retorna 1 si o1 > o2
    @Override
    public int compare(String o1, String o2) {
        if(o1.length() < o2.length()){
            return -1;
        }else{
            if(o1.length() > o2.length()){
                return  1;
            }else{
                return 0;
            }
        }
    }
    /*El único fin de Comparator es retornar un valor numerico dependiendo
    * de la evaluación de dos parametros pasados como argumento al método
    * abstracto compare()*/
}
