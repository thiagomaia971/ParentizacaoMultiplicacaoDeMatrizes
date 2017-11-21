package services.parentizadores;

import entities.ArquivoEntrada;
import entities.DadoIntancia;
import entities.Matriz;
import entities.Parentizacao;
import interfaces.IParentizador;
import services.Log;

import java.util.ArrayList;
import java.util.List;

public class ParentizadorPorAlgoritmoGuloso implements IParentizador {
    @Override
    public void processarArquivo(ArquivoEntrada arquivosDeEntrada) {
        Log.println("\n##Parentização de Matrizes por Algoritmo Guloso: ");

        for (DadoIntancia instancia : arquivosDeEntrada.getInstancias()) {
            int[] p = instancia.getValues();
            List<Matriz> matrizes = carregarMatrizes(p);
            List<Parentizacao> parentizacaos = carregarParentizacoes(matrizes);
            int valorTotalParentizacoes = carregarValorTotalParentizacoes(parentizacaos);

            Log.println("");
        }
    }

    private List<Matriz> carregarMatrizes(int[] p) {
        List<Matriz> matrizes = new ArrayList<Matriz>();
        for (int i = 1; i < p.length; i++) {
            matrizes.add(new Matriz(i, p[i - 1], p[i]));
        }
        return matrizes;
    }

    private List<Parentizacao> carregarParentizacoes(List<Matriz> matrizes) {
        List<Parentizacao> parentizacoes = new ArrayList<Parentizacao>();
        Log.print("(");

        for (int i = 1; i < matrizes.size(); i++) {
            if (i >= matrizes.size() - 1) {
                printarParentizacao(matrizes, i -1, i);
                continue;
            }

            Matriz left = matrizes.get(i - 1);
            Matriz midle = matrizes.get(i);
            Matriz rigth = matrizes.get(i + 1);

            int valorParentizacaoAEsquerda = left.getLinha() * left.getColuna() * midle.getColuna();
            int valorParentizacaoADireita = midle.getLinha() * midle.getColuna() * rigth.getColuna();

            if (valorParentizacaoAEsquerda < valorParentizacaoADireita) {
                parentizacoes.add(new Parentizacao(matrizes.get(i-1), matrizes.get(i)));
                printarParentizacao(matrizes, i -1, i);
            } else {
                parentizacoes.add(new Parentizacao(matrizes.get(i-1)));
                parentizacoes.add(new Parentizacao(matrizes.get(i), matrizes.get(i + 1)));

                printarParentizacao(matrizes, i -1);
                printarParentizacao(matrizes, i, i + 1);

                i++;
            }
            i++;
            if (i >= matrizes.size() - 1) {
                parentizacoes.add(new Parentizacao(matrizes.get(i)));
                printarParentizacao(matrizes, i);
            }
        }

        Log.print(")");
        return parentizacoes;
    }

    private int carregarValorTotalParentizacoes(List<Parentizacao> parentizacaos) {
        return 0;
    }

    private void printarParentizacao(List<Matriz> matrizes, int i, int j) {
        Log.print("(" + matrizes.get(i) + matrizes.get(j) + ")");
    }

    private void printarParentizacao(List<Matriz> matrizes, int i) {
        Log.print("(" + matrizes.get(i) + ")");
    }
}
