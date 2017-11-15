package services;

import interfaces.ILog;
import interfaces.ISelecionadorDeArquivoEntrada;
import utils.GlobalVariables;

import java.io.File;
import java.util.Scanner;

public class SelecionadorDeArquivoEntrada implements ISelecionadorDeArquivoEntrada {
    private ILog _logger;
    private String _inputPath;

    public SelecionadorDeArquivoEntrada (ILog logger, String inputPath){
        _logger = logger;
        _inputPath = inputPath;
    }

    @Override
    public File[] selecionarArquivosParaProcessar() {
        Scanner scanner = new Scanner(System.in);

        _logger.println("Pasta onde está localizado os arquivos input's: ");
        _logger.println(GlobalVariables.absolutePathProjectArquivoEntrada);
        _logger.println("");

        _logger.println("Arquivos localizados: ");
        _logger.println("0. Começar");

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

        _logger.println("\nArquivos selecionados:");
        printarTodosOsArquivos(arquivosSelecionados);

        return arquivosSelecionados;
    }

    private File[] todosOsArquivosDisponiveis(){
        File file = new File(_inputPath);
        File[] directores = file.listFiles();

        return directores;
    }

    private void printarTodosOsArquivos(File[] directores){
        for (int i = 0; i < directores.length; i++) {
            if (directores[i] != null)
                _logger.println(String.format("%s. %s", i+1, directores[i].getName()));
        }
    }
}
