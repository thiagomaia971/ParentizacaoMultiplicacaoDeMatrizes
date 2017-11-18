package entities;

import interfaces.IGerenciadorDeIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoEntrada {
    private int quantidadeDeInstancias;
    private ArrayList<DadoIntancia> instancias;
    private IGerenciadorDeIO _gerenciadorDeIO;

    public ArquivoEntrada(IGerenciadorDeIO gerenciadorDeIO) {
        this._gerenciadorDeIO = gerenciadorDeIO;
        this.instancias = new ArrayList<DadoIntancia>();
    }

    public void processarFileSelected(File file) throws IOException {
        ArrayList<String> linhas = _gerenciadorDeIO.getStrings(file.getAbsolutePath());
        this.quantidadeDeInstancias = Integer.parseInt(linhas.get(0));
        linhas.remove(0);
        for (String linha : linhas) {
            this.instancias.add(new DadoIntancia(linha));
        }
    }

    public int getQuantidadeDeInstancias() {
        return quantidadeDeInstancias;
    }

    public ArrayList<DadoIntancia> getInstancias() { return instancias; }
}
