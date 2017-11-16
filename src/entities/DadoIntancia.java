package entities;

public class DadoIntancia {
    private String[] values;
    public DadoIntancia(String linha) {
        this.values = linha.split(" ");
    }

    public String[] getValues() {
        return values;
    }
}
