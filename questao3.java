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

    public Celula<E> getFrente() {
        return frente;
    }

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

    public E consultarPrimeiro() {
        if (vazia()) {
            throw new NoSuchElementException("Erro: fila vazia");
        }
        return frente.getProximo().getItem();
    }

    public void imprimir() {
        Celula<E> aux = frente.getProximo();
        while (aux != null) {
            System.out.print(aux.getItem() + " ");
            aux = aux.getProximo();
        }
        System.out.println();
    }

    private void moverPrimeiro(Celula<E> celula) {
        //Settar o proximo do anterior para o próximo do atual
        celula.getAnterior().setProximo(celula.getProximo());
        //Settar o anterior do proximo para o anterior do atual
        celula.getProximo().setAnterior(celula.getAnterior());
        celula.setAnterior(null);

    }

    public void getPrioridade (E item) {
        Celula<E> atual = this.getFrente();
        while(atual != null){
            if(atual.getItem().equals(item)){
                tras = atual.getAnterior();
            }
            this.moverPrimeiro(atual);
            return;
        }
        throw new NoSuchElementException("Elemento não encontrado!");
    }
}

public class questao3{
    public static void main(String[] args) {
        Fila<Integer> fila = new Fila<Integer>();
    }
}
