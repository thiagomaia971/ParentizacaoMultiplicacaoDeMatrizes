package entities;

public class DadoIntancia {
    private int[] values;
    public DadoIntancia(String linha) {
        String[] a = linha.split(" ");
        values = new int[a.length - 1];
        for (int i = 1; i < a.length; i++) {
            values[i - 1] = Integer.parseInt(a[i]);
        }
    }

    public int[] getValues() {
        return values;
    }
}
