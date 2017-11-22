package services.parentizadores;

import entities.ArquivoEntrada;
import entities.DadoIntancia;
import entities.Matriz;
import entities.Parentizacao;
import interfaces.IParentizador;
import services.Log;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ParentizadorPorAlgoritmoGuloso implements IParentizador {
    @Override
    public void processarArquivo(ArquivoEntrada arquivosDeEntrada) {
        Log.println("\n##Parentização de Matrizes por Algoritmo Guloso: ");

        for (DadoIntancia instancia : arquivosDeEntrada.getInstancias()) {
            int[] p = instancia.getValues();

            Log.println(" " + c(p, 1, p.length - 1));
        }
    }

    private int c(int[] p, int i, int j) {
        if (i == j) {
            Log.print("A" + i);
            return 0;
        }
        int valor = p[i - 1] * p[i] * p[j];
        int auxK = i;

        for (int k = i; k < j - i + 1; k++) {
            int x = p[i - 1] * p[k] * p[j];
            if (x < valor){
                valor = x;
                auxK = k;
            }
        }

        Log.print("(");
        valor += c(p, i, auxK);
        valor += c(p, auxK + 1, j);
        Log.print(")");

        return valor;
    }
}
