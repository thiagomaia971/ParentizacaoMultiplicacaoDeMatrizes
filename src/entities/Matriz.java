package entities;

import services.Log;

public class Matriz {
    private int id;
    private int linha;
    private int coluna;

    public Matriz(int id, int i, int i1) {
        linha = i;
        coluna = i1;
        this.id = id;
    }

    public int getLinha() {
        return linha;
    }
    public int getColuna() {
        return coluna;
    }
    public String toString() {
        return "A" + this.id;
    }
    public void print() {
        Log.print(this.toString());
    }
}
