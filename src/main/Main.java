package main;

import entities.ArquivoEntrada;
import interfaces.IGerenciadorDeIO;
import interfaces.IParentizador;
import interfaces.ISelecionadorDeArquivoEntrada;
import services.*;
import services.parentizadores.ParentizadorPorAlgoritmoGuloso;
import services.parentizadores.ParentizadorPorProgramacaoDinamica;
import utils.GlobalVariables;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static ISelecionadorDeArquivoEntrada _selecionadorDeArquivoEntrada;
    private static List<IParentizador> _parentizadores;
    private static IGerenciadorDeIO _gerenciadorDeIO;

    public static void main(String[] args) {
        prepararServicos();
        File arquivosSelecionados = _selecionadorDeArquivoEntrada.selecionarArquivoParaProcessar();
        ArquivoEntrada arquivosDeEntrada = lerArquivoSelecionado(arquivosSelecionados);

        for (IParentizador parentizador : _parentizadores) {
            parentizador.processarArquivo(arquivosDeEntrada);
            parentizador.printar();
        }
    }

    private static void prepararServicos() {
        _selecionadorDeArquivoEntrada = new SelecionadorDeArquivoEntrada(GlobalVariables.absolutePathProjectArquivoEntrada);
        _gerenciadorDeIO = new GerenciadorDeIO();

        _parentizadores = new ArrayList<IParentizador>();
        _parentizadores.add(new ParentizadorPorProgramacaoDinamica());
        _parentizadores.add(new ParentizadorPorAlgoritmoGuloso());
    }

    private static ArquivoEntrada lerArquivoSelecionado(File file) {
        try {
            ArquivoEntrada arquivoEntrada = new ArquivoEntrada(_gerenciadorDeIO);
            arquivoEntrada.processarFileSelected(file);
            return arquivoEntrada;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
