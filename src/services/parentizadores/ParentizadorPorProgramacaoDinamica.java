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
            int[] p = instancia.getValues();
            int n = p.length;

            int[][] m = new int[n][n];
            int[][] s = new int[n][n];

            for (int l = 1; l < n; l++) {
                for (int i = 0; i < n - l; i++) {
                    int j = i + l;
                    m[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j - 1; k++) {
                        int q = m[i][k] + m[k + 1][j] + (p[i] * p[k] * p[j]);
                        if (q < m[i][j]) {
                            m[i][j] = q;
                            s[i][j] = k;
                        }
                    }
                }
            }

            printar(s, 0, p.length - 1);
        }
    }

    public void printar(int[][] s, int i, int j) {
        if (i == j)
            Log.print("A" + i);
        else {
            Log.print("(");
            printar(s, i, s[i][j]);
            printar(s, s[i][j] + 1, j);
            Log.print(")");
        }
    }

}
