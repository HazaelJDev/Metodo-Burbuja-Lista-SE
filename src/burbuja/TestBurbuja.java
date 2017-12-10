package burbuja;
public class TestBurbuja {
    public static void main(String args[]){
        Burbuja burbuja = new Burbuja();
        int arreglo[] = {80,39,7,1,25};
        ListaSE lista =  new ListaSE();
        for (int var : arreglo) {
            lista.addNodo(var);
        }
        System.out.println("\tArreglo");
        for (int var : arreglo) {
            System.out.print("|"+var+"|");
        }
        System.out.println("\n\tArreglo Ordenado");
        burbuja.sortArray(arreglo);
        for (int var : arreglo) {
            System.out.print("|"+var+"|");
        }
        System.out.println("\tLista");
        lista.showList();
        System.out.println("\tLista Ordenada");
        burbuja.sortListSE(lista);
        lista.showList();
    }
}
