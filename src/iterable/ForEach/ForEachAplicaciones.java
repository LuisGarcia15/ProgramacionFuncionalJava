package iterable.ForEach;

public class ForEachAplicaciones {
    public static void main(String[] args) {
        ColeccionPropia lista = new ColeccionPropia(5);
        lista.add(1);
        System.out.println(lista.estaLleno());
        lista.add(2);
        System.out.println(lista.estaLleno());
        lista.add(3);
        System.out.println(lista.estaLleno());
        lista.add(4);
        System.out.println(lista.estaLleno());

        for(Integer n: lista){
            System.out.println(n);
        }
    }
}
