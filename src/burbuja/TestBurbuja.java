package burbuja;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestBurbuja {
    public static void main(String args[]){
        //Creamos variables para medir los tiempos
        long tini =0, tfin=0,tlpoc=0,tlmed=0,tlmuy=0;
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
        System.out.println("\tCreando listas...");
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
        System.out.println("Ordenando lista 1...");
        tini = System.currentTimeMillis();
        burbuja.sortListSE(lpoco);
        tfin = System.currentTimeMillis();
        tlpoc = (tfin - tini);
        System.out.println("Ordenando lista 2...");
        tini = System.currentTimeMillis();
        burbuja.sortListSE(lmedio);
        tfin = System.currentTimeMillis();
        tlmed = (tfin - tini);
        System.out.println("Ordenando lista 3...");
        tini = System.currentTimeMillis();
        burbuja.sortListSE(lmuy);
        tfin = System.currentTimeMillis();
        tlmuy = (tfin - tini);
        System.out.println("Exportando datos ordenados a archivo CSV...");
        //Guardamos los datos ordenados en un archivo Csv
        String outputFile = "DatosOrdenados.csv";
        boolean alreadyExists = new File(outputFile).exists();
        try {
            if (alreadyExists) {
                new File(outputFile).delete();
                new File(outputFile).createNewFile();
            }
            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
            csvOutput.write("Poco_Desordenados");
            csvOutput.write("Medio_Desordenados");
            csvOutput.write("Muy_Desordenados");
            csvOutput.endRecord();
            Nodo auxp = lpoco.primero;
            Nodo auxmed = lmedio.primero;
            Nodo auxmuy = lmuy.primero;
            while (auxp != null && auxmed != null && auxmuy != null) {
                csvOutput.write(String.valueOf(auxp.dat));
                csvOutput.write(String.valueOf(auxmed.dat));
                csvOutput.write(String.valueOf(auxmuy.dat));
                csvOutput.endRecord();
                auxp = auxp.sig;
                auxmed = auxmed.sig;
                auxmuy = auxmuy.sig;
            }
            csvOutput.endRecord();
            csvOutput.endRecord();
            csvOutput.endRecord();
            csvOutput.write("");
            csvOutput.write("Tiempos");
            csvOutput.endRecord();
            csvOutput.write("Poco Desordenados:");
            csvOutput.write(String.valueOf(tlpoc)+" milis.");
            csvOutput.endRecord();
            csvOutput.write("Medio Desordenados:");
            csvOutput.write(String.valueOf(tlmed)+" milis.");
            csvOutput.endRecord();
            csvOutput.write("Muy Desordenados:");
            csvOutput.write(String.valueOf(tlmuy)+" milis.");
            csvOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n\tTiempos de Ordenacion de Datos con el Metodo de Burbuja");
        System.out.println("Poco Desordenados: "+tlpoc+" milis.");
        System.out.println("Medio Desordenados: "+tlmed+" milis.");
        System.out.println("Muy Desordenados: "+tlmuy+" milis.");
    }
}
