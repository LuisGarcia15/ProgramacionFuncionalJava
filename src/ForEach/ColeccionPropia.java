package ForEach;

import java.util.Iterator;

public class ColeccionPropia implements Iterable<Integer>{
    private Integer[] lista;
    private int indiceActual;

    public ColeccionPropia(int tamanio) {
        this.lista = new Integer[tamanio];
        this.indiceActual = 0;
    }

    public int add(Integer numero){
        if(this.indiceActual == this.lista.length){
            return -1;
        }else{
            this.lista[indiceActual] = numero;
            this.indiceActual++;
            return 1;
        }
    }

    public boolean estaLleno(){
        return indiceActual < lista.length;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>(){

            private int indice = 0;

            @Override
            public boolean hasNext() {
                return indice < lista.length && lista[indice] != null;
            }

            @Override
            public Integer next() {
                int numero = lista[indice];
                indice++;
                return numero;
            }
        };
    }
}
