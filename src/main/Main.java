package main;

import entities.ArquivoEntrada;
import interfaces.IGerenciadorDeIO;
import interfaces.ILog;
import interfaces.IParentizador;
import interfaces.ISelecionadorDeArquivoEntrada;
import services.*;
import utils.GlobalVariables;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static ILog logger;
    private static ISelecionadorDeArquivoEntrada _selecionadorDeArquivoEntrada;
    private static List<IParentizador> _parentizadores;
    private static IGerenciadorDeIO _gerenciadorDeIO;

    public static void main(String[] args) {
        prepararServicos();
        File[] arquivosSelecionados = _selecionadorDeArquivoEntrada.selecionarArquivosParaProcessar();
        ArrayList<ArquivoEntrada> arquivosDeEntrada = processarFiles(arquivosSelecionados);

        for (IParentizador parentizador : _parentizadores) {
            parentizador.processarArquivo(arquivosDeEntrada);
        }
    }

    private static void prepararServicos() {
        logger = new Log();
        _selecionadorDeArquivoEntrada = new SelecionadorDeArquivoEntrada(logger, GlobalVariables.absolutePathProjectArquivoEntrada);
        _gerenciadorDeIO = new GerenciadorDeIO();

        _parentizadores = new ArrayList<IParentizador>();
        _parentizadores.add(new ParentizadorPorProgramacaoDinamica());
        _parentizadores.add(new ParentizadorPorAlgoritmoGuloso());
    }

    private static ArrayList<ArquivoEntrada> processarFiles(File[] files) {
        ArrayList<ArquivoEntrada> arquivosDeEntrada = new ArrayList<ArquivoEntrada>();
        for (int i = 0; i < files.length; i++) {
            try {
                ArquivoEntrada arquivoEntrada = new ArquivoEntrada(_gerenciadorDeIO);
                arquivoEntrada.processarFileSelecionado(files[i]);
                arquivosDeEntrada.add(arquivoEntrada);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return arquivosDeEntrada;
    }
}
