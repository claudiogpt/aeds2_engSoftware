import java.util.NoSuchElementException;

class Celula<T> {
    private final T item;
    private Celula<T> anterior;
    private Celula<T> proximo;

    public Celula() {
        item = null;
        anterior = null;
        proximo = null;
    }

    public Celula(T item) {
        this.item = item;
        anterior = null;
        proximo = null;
    }

    public Celula(T item, Celula<T> proximo) {
        this.item = item;
        this.anterior = null;
        this.proximo = proximo;
    }

    public T getItem() {
        return item;
    }

    public Celula<T> getProximo() {
        return proximo;
    }

    public Celula<T> getAnterior() {
        return anterior;
    }

    public void setProximo(Celula<T> proximo) {
        this.proximo = proximo;
    }

    public void setAnterior(Celula<T> anterior) {
        this.anterior = anterior;
    }
}

class Fila<E> {
    private Celula<E> frente;
    private Celula<E> tras;

    public Fila() {
        frente = new Celula<E>();
        tras = frente;
    }

    public boolean vazia() {
        return frente == tras;
    }

    public void enfileirar(E item) {
        tras.setProximo(new Celula<E>(item));
        //Tras é uma sentinela, idealmente não modificada
        //tras = tras.getProximo();
    }

    public E desenfileirar() {
        if (vazia()) {
            throw new NoSuchElementException("Erro: fila vazia");
        }
        Celula<E> aux = frente;
        frente = frente.getProximo();
        return frente.getItem();
    }
}

public class questao3{
    public static void main(String[] args) {
        Fila<Integer> fila = new Fila<Integer>();
    }
}