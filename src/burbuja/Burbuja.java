package burbuja;
public class Burbuja{
    long i=0,j=0;
    int aux=0; //variable auxiliar para guardar el numero menor por un momento
    Nodo na=null,ns=null; //na: Nodo actual; ns = Nodo siguiente;
    //Método de ordenamiento burbuja para arreglos
    public void sortArray(int a[]){
        for (int i=1;i<a.length;i++){
            for(int j=0;j<(a.length-i);j++){
                if(a[j]>a[j+1]){
                    aux = a[j];
                    a[j] = a[j+1];
                    a[j+1] = aux;
                }
            }
        }
    }
    //Método de ordenamiento burbuja para listas simplemente enlazadas
    public void sortListSE(ListaSE list){
        for(i=1;i<list.length;i++){
            na = list.primero;
            ns = na.sig;
            for(j=0;j<(list.length-i);j++){
                if(na.dat>ns.dat){
                    aux = na.dat;
                    na.dat = ns.dat;
                    ns.dat = aux;
                }
                na = na.sig;
                ns = ns.sig;
            }
        }
    }
}
