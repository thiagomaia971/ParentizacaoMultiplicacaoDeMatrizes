package main;

import interfaces.ILog;
import interfaces.IParentizador;
import interfaces.ISelecionadorDeArquivoEntrada;
import services.Log;
import services.ParentizadorPorAlgoritmoGuloso;
import services.ParentizadorPorProgramacaoDinamica;
import services.SelecionadorDeArquivoEntrada;
import utils.GlobalVariables;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static ILog logger;
    private static ISelecionadorDeArquivoEntrada _selecionadorDeArquivoEntrada;
    private static List<IParentizador> _parentizadores;

    public static void main(String[] args) {
        prepararServicos();
        File[] arquivosSelecionados = _selecionadorDeArquivoEntrada.selecionarArquivosParaProcessar();
//        ArquivoEntrada arquivo new ArquivoEntrada()

        for (IParentizador parentizador : _parentizadores) {
            parentizador.processarArquivo();
        }
    }

    private static void prepararServicos() {
        logger = new Log();
        _selecionadorDeArquivoEntrada = new SelecionadorDeArquivoEntrada(logger, GlobalVariables.absolutePathProjectArquivoEntrada);

        _parentizadores = new ArrayList<IParentizador>();
        _parentizadores.add(new ParentizadorPorProgramacaoDinamica());
        _parentizadores.add(new ParentizadorPorAlgoritmoGuloso());
    }
}
