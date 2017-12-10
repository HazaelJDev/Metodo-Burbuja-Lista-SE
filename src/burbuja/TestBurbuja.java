package burbuja;
import java.util.Random;
public class TestBurbuja {
    public static void main(String args[]){
        Burbuja burbuja = new Burbuja();
        int arreglo[] = {80,39,7,1,25,3,1839,2,45};
        Random r = new Random();
        ListaSE lista =  new ListaSE();
        /*for (int var : arreglo) {
            lista.addNodo(var);
        }*/
        for(int i=1; i<=500; i++){
            lista.addNodo(r.nextInt(4500));
        }
        System.out.println("\tArreglo");
        for (int var : arreglo) {
            System.out.print("|"+var+"|");
        }
        System.out.println("\n\n\tArreglo Ordenado");
        burbuja.sortArray(arreglo);
        for (int var : arreglo) {
            System.out.print("|"+var+"|");
        }
        System.out.println("\n\n\tLista");
        lista.showList();
        System.out.println("\n\tLista Ordenada");
        burbuja.sortListSE(lista);
        lista.showList();
    }
}
