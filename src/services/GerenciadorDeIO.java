package services;

import interfaces.IGerenciadorDeIO;

import java.io.*;
import java.util.ArrayList;

public class GerenciadorDeIO implements IGerenciadorDeIO {
    @Override
    public void gravarString(String diretorio, ArrayList<String> conteudo) throws IOException {
        File file = new File(diretorio);
        if (file.exists())
            file.delete();
        file.createNewFile();

        try (PrintWriter out = new PrintWriter(file)) {
            conteudo.stream().forEach(linha -> out.print(linha));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<String> getStrings(String diretorio) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(diretorio, "r");

        ArrayList<String> linhas = new ArrayList<String>();

        String linhaAux = null;
        do {
            linhaAux = randomAccessFile.readLine();
            if (linhaAux != null) {
                linhas.add(linhaAux);
            }
        } while (linhaAux != null);

        randomAccessFile.close();

        return linhas;
    }
}
