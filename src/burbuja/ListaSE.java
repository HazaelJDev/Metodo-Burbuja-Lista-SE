package burbuja;
import javax.swing.JOptionPane;
public class ListaSE {
    Nodo primero=null,ultimo=null;
    long length=0;
    public void addNodo(int d){
        Nodo nuevo = new Nodo(d);
        if(primero == null){
            primero = ultimo = nuevo;
        }else{
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }
        length++;
    }
    public void deleteFirstNode(){
        if(itsEmpty()){
            JOptionPane.showMessageDialog(null,"¡No hay elementos que eliminar en la lista!","¡Lista vacia!",JOptionPane.ERROR_MESSAGE);
        }else{
            primero = primero.sig;
            length--;
        }
    }
    public void deleteLastNode(){
        if(itsEmpty()){
            JOptionPane.showMessageDialog(null,"¡No hay elementos que eliminar en la lista!","¡Lista vacia!",JOptionPane.ERROR_MESSAGE);
        }else{
            Nodo r = primero;
            while(r.sig != ultimo){
                r = r.sig;
            }
            ultimo = r;
            ultimo.sig = null;
            length--;
        }
    }
    public boolean itsEmpty(){
        if(primero==null){
            return true; 
        }else{
            return false;
        }
    }
    public void showList(){
        Nodo r = primero;
        while(r != null){
            System.out.print("|"+r.dat+"|-->");
            r = r.sig;
        }
        System.out.print(" null\n");
    }
}
