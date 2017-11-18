package services.parentizadores;

import entities.ArquivoEntrada;
import entities.DadoIntancia;
import interfaces.IParentizador;
import services.Log;

public class ParentizadorPorProgramacaoDinamica implements IParentizador {
    @Override
    public void processarArquivo(ArquivoEntrada arquivoDeEntrada) {
        Log.println("Iniciando algoritmo por Programação Dinâmica!");
        for (DadoIntancia instancia : arquivoDeEntrada.getInstancias()) {
            int n = instancia.getValues().length;
            int[][] m = new int[n][n];
            for (int l = 2; l < n; l++) {
                for (int i = 0; i < n - l + 1; i++) {
                    int j = i + l - 1;
                    m[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < j - 1; k++) {
                        int q = m[i][k] + m[k + 1][j] + (instancia.getValues()[i-1]);
                    }
                }
            }

        }
    }

    @Override
    public void printar() {

    }

}
