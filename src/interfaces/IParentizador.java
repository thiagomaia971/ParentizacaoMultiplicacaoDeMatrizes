package interfaces;

import entities.ArquivoEntrada;

import java.util.ArrayList;

public interface IParentizador {
    void processarArquivo(ArrayList<ArquivoEntrada> arquivosDeEntrada);
}
