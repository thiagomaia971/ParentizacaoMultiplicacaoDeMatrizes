package entities;

import java.util.Arrays;

public class DadoIntancia {
    private int[] values;
    public DadoIntancia(String linha) {
//        this.values = Arrays.stream(linha.split(" ")).map(x -> Integer.getInteger(x));
        String[] a = linha.split(" ");
        this.values = Arrays.copyOfRange(a, 0, a.length, int[].class);
    }

    public int[] getValues() {
        return values;

    }
}
