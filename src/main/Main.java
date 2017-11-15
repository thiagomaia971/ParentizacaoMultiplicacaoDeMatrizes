package main;

import interfaces.ILog;
import interfaces.ISelecionadorDeArquivoEntrada;
import services.Log;
import services.SelecionadorDeArquivoEntrada;
import utils.GlobalVariables;

import java.io.File;

public class Main {
    private static ILog logger;
    private static ISelecionadorDeArquivoEntrada _selecionadorDeArquivoEntrada;

    public static void main(String[] args) {
        logger = new Log();
        _selecionadorDeArquivoEntrada = new SelecionadorDeArquivoEntrada(logger, GlobalVariables.absolutePathProjectArquivoEntrada);
        File[] arquivosSelecionados = _selecionadorDeArquivoEntrada.selecionarArquivosParaProcessar();

    }
}
