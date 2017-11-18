package entities;

public class DadoIntancia {
    private int[] values;
    public DadoIntancia(String linha) {
        String[] a = linha.split(" ");
        values = new int[a.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(a[i]);
        }
    }

    public int[] getValues() {
        return values;
    }
}
