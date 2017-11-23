package services.parentizadores;

import entities.ArquivoEntrada;
import entities.DadoIntancia;
import interfaces.IParentizador;
import services.Log;

public class ParentizadorPorAlgoritmoGuloso implements IParentizador {
    @Override
    public void processarArquivo(ArquivoEntrada arquivosDeEntrada) {
        Log.println("\n##Parentização de Matrizes por Algoritmo Guloso!!");

        for (DadoIntancia instancia : arquivosDeEntrada.getInstancias()) {
            int[] p = instancia.getValues();
            int resultado = algoritmoGuloso(p, 1, p.length - 1);
            Log.println(" " + resultado);
        }
    }

    /***
     * n = (j - i)  => (1, p.length - 1)
     * Equação de recorrencia: T(n) = 2T(n/2) + n (?)
     * Divisão: sempre escolhendo um K e dividindo o problema em (i, k) e (k + 1, j)
     * Conquista: Somatório da divisão
     * Tudo antes da divisão => Teta(n)(?)
     *
     * Caso sempre o k = i for o menor valor, o seguinte codigo vai ser executado somente uma ver por cada chamada ao método:
     *     valor = x;
     *     auxK = k;
     *
     * @param p
     * @param i
     * @param j
     * @return
     */
    private int algoritmoGuloso(int[] p, int i, int j) {
        if (i == j) {
            Log.print("A" + i);
            return 0;
        }
        int valor = Integer.MAX_VALUE;
        int auxK = -1;

        for (int k = i; k < j; k++) {
            int x = p[i - 1] * p[k] * p[j];
            if (x < valor){
                valor = x;
                auxK = k;
            }
        }

        Log.print("(");
        valor += algoritmoGuloso(p, i, auxK);
        valor += algoritmoGuloso(p, auxK + 1, j);
        Log.print(")");

        return valor;
    }
}
