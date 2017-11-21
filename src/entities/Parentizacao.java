package entities;

public class Parentizacao {
    private Matriz left;
    private Matriz rigth;

    public Parentizacao(Matriz matriz, Matriz matriz1) {
        left = matriz;
        rigth = matriz1;
    }

    public Parentizacao(Matriz matriz) {
        left = matriz;
    }
}
