package burbuja;
import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestBurbuja {
    public static void main(String args[]){
        //Instanciamos la clase Burbuja para poder usar el método de ordenamiento en las listas dinamicas
        Burbuja burbuja = new Burbuja();
        //Creamos 3 listas dinamicas cada una guardara los mismos datos, sólo que estaran diferentemente desacomodamos
        ListaSE lpoco = new ListaSE();
        ListaSE lmedio = new ListaSE();
        ListaSE lmuy = new ListaSE();
        /*
            Leemos el CSV y guardamos los 100,000 datos en cada lista.
            Hay 3 columnas cada una tiene los mismos datos, sólo que desordenados diferentemente.
        */
        try {
            CsvReader datos = new CsvReader("Datos.csv");
            datos.readHeaders();
            while (datos.readRecord()) {
                lpoco.addNodo(Integer.parseInt(datos.get("Poco_Desordenados")));
                lmedio.addNodo(Integer.parseInt(datos.get("Medio_Desordenados")));
                lmuy.addNodo(Integer.parseInt(datos.get("Muy_Desordenados")));
            }
            datos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //Ordenamos listas
        burbuja.sortListSE(lpoco);
        burbuja.sortListSE(lmedio);
        burbuja.sortListSE(lmuy);
    }
}
