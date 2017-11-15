package interfaces;

import java.io.IOException;
import java.util.ArrayList;

public interface IGerenciadorDeIO {
    void gravarString(String diretorio, ArrayList<String> conteudo) throws IOException;
    ArrayList<String> getStrings(String diretorio) throws IOException;
}
