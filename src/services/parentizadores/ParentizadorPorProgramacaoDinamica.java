package services.parentizadores;

import entities.ArquivoEntrada;
import entities.DadoIntancia;
import interfaces.IParentizador;
import services.Log;

public class ParentizadorPorProgramacaoDinamica implements IParentizador {
    @Override
    public void processarArquivo(ArquivoEntrada arquivoDeEntrada) {
        Log.println("\n##Parentização de Matrizes por Programação Dinâmica!!");
        for (DadoIntancia instancia : arquivoDeEntrada.getInstancias()) {
            programacaoDinamica(instancia);
        }
    }

    /***
     *
     * @param instancia
     */
    private void programacaoDinamica(DadoIntancia instancia) {
        int[] p = instancia.getValues();
        int[][] m = new int[p.length][p.length];
        int[][] s = new int[p.length][p.length];

        for (int l = 2; l < p.length; l++) {
            for (int i = 1; i <= p.length - l; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + (p[i - 1] * p[k] * p[j]);
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        printar(s, 1, p.length - 1);
        System.out.println(" " + m[1][p.length - 1]);
    }

    private void printar(int[][] s, int i, int j) {
        if (i == j)
            System.out.print("A" + i);
        else {
            System.out.print("(");
            printar(s, i, s[i][j]);
            printar(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

}
