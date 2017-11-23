package services;

import utils.GlobalVariables;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private static Date date = new Date();
    private static final String PATH = GlobalVariables.LOCAL_LOG + "RESULTADO_" + identificador() + ".txt";
//    private static final String PATH = GlobalVariables.LOCAL_LOG + "saida" + ".txt";

    public static void print(String mensagem) {
        System.out.print(mensagem);
        File file = new File(PATH);

        try (FileWriter out = new FileWriter(file, true)) {
            out.append(mensagem);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void println(String mensagem) {
        System.out.println(mensagem);
        File file = new File(PATH);
        
        try {
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter out = new FileWriter(file, true)) {
            out.append(mensagem + "\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String identificador() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HHmmss");
        return dateFormat.format(date);
    }
}
