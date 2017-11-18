package services;

import interfaces.ISelecionadorDeArquivoEntrada;
import utils.GlobalVariables;

import java.io.File;
import java.util.Scanner;

public class SelecionadorDeArquivoEntrada implements ISelecionadorDeArquivoEntrada {
    private String _inputPath;

    public SelecionadorDeArquivoEntrada(String inputPath) {
        _inputPath = inputPath;
    }

    @Override
    public File[] selecionarArquivosParaProcessar() {
        Scanner scanner = new Scanner(System.in);

        Log.println("Pasta onde está localizado os arquivos input's: ");
        Log.println(GlobalVariables.absolutePathProjectArquivoEntrada);
        Log.println("");

        Log.println("Arquivos localizados: ");
        Log.println("0. Começar");

        File[] directores = todosOsArquivosDisponiveis();
        printarTodosOsArquivos(directores);

        int quantidadeSelecionados = 0;
        File[] arquivosSelecionados = new File[directores.length];
        int indexSelecionado;

        do {
            System.out.println("\nEscolha os arquivos: ");
            indexSelecionado = scanner.nextInt();

            if (indexSelecionado > 0)
                arquivosSelecionados[quantidadeSelecionados] = directores[indexSelecionado - 1];

            quantidadeSelecionados++;
        } while (indexSelecionado != 0);

        Log.println("\nArquivos selecionados:");
        printarTodosOsArquivos(arquivosSelecionados);

        return arquivosSelecionados;
    }

    @Override
    public File selecionarArquivoParaProcessar() {
        Scanner scanner = new Scanner(System.in);

        Log.println("Pasta onde está localizado os arquivos input's: ");
        Log.println(GlobalVariables.absolutePathProjectArquivoEntrada);
        Log.println("");

        Log.println("Arquivos localizados: ");

        File[] directores = todosOsArquivosDisponiveis();
        printarTodosOsArquivos(directores);

        File arquivoSelecionado = null;
        int indexSelecionado;

        do {
            System.out.println("\nEscolha o arquivo: ");
            indexSelecionado = scanner.nextInt();
            if (indexSelecionado > 0)
                arquivoSelecionado = directores[indexSelecionado - 1];
        } while (arquivoSelecionado == null);

        Log.println("\nArquivo selecionado:");
        printarArquivo(arquivoSelecionado, null);

        return arquivoSelecionado;
    }

    private File[] todosOsArquivosDisponiveis() {
        File file = new File(_inputPath);
        File[] directores = file.listFiles();

        return directores;
    }

    private void printarTodosOsArquivos(File[] directores) {
        for (int i = 0; i < directores.length; i++)
            printarArquivo(directores[i], i + 1);
    }

    private void printarArquivo(File directore, Integer i) {
        if (directore != null && i != null)
            Log.println(String.format("%s. %s", i, directore.getName()));
        else if (directore != null)
            Log.println(String.format("%s", directore.getName()));
    }
}
