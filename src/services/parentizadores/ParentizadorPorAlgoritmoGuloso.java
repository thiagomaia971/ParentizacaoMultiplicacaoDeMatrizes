package services.parentizadores;

import entities.ArquivoEntrada;
import entities.DadoIntancia;
import entities.Parentizacao;
import interfaces.IParentizador;
import services.Log;

import java.util.ArrayList;
import java.util.List;

public class ParentizadorPorAlgoritmoGuloso implements IParentizador {
    @Override
    public void processarArquivo(ArquivoEntrada arquivosDeEntrada) {
        for (DadoIntancia instancia : arquivosDeEntrada.getInstancias()) {
            int[] p = instancia.getValues();
            int valorTotal = 0;
            List<Parentizacao> parentizacaos = new ArrayList<Parentizacao>();
            for (int i = 1; i < instancia.getValues().length; i++) {
                parentizacaos.add(new Parentizacao(p[i - 1], p[i]));
            }

            for (int i = 1; i < parentizacaos.size() - 1; i++) {
                Parentizacao left = parentizacaos.get(i - 1);
                Parentizacao midle = parentizacaos.get(i);

                Parentizacao rigth = parentizacaos.get(i + 1);

                int parentizacaoAEsquerda = left.getLinha() * left.getColuna() * midle.getColuna();
                int parentizacaoADireita = midle.getLinha() * midle.getColuna() * rigth.getColuna();

                if (parentizacaoAEsquerda < parentizacaoADireita) {
                    Log.print("(A" + (i - 1) + "A" + (i) + ")");
                } else {
                    Log.print("A" + (i - 1));
                    Log.print("(A" + (i) + "A" + (i + 1) + ")");
                }
                i++;
                if (i >= parentizacaos.size() - 1){
                    Log.print("(A" + i + ")");
                    continue;
                }
            }
            Log.println("");
        }
    }

    public void printar() {

    }
}
