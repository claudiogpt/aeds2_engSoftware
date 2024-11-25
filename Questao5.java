class Celula<T> {

	private final T item;
	private Celula<T> proximo;

	public Celula() {
		this.item = null;
		setProximo(null);
	}

	public Celula(T item) {
		this.item = item;
		setProximo(null);
	}

	public Celula(T item, Celula<T> proximo) {
        this.item = item;
        this.proximo = proximo;
    }
	
	public T getItem() {
		return item;
	}

	public Celula<T> getProximo() {
		return proximo;
	}

	public void setProximo(Celula<T> proximo) {
		this.proximo = proximo;
	}
}

class Lista<E> {

	private Celula<E> primeiro;
	private Celula<E> ultimo;
	private int tamanho;
	
	public Lista() {
		
		Celula<E> sentinela = new Celula<>();
		
		this.primeiro = this.ultimo = sentinela;
		this.tamanho = 0;
	}
	
	public boolean vazia() {
		
		return (this.primeiro == this.ultimo);
	}
	
	public void inserir(E novo, int posicao) {
		
		Celula<E> anterior, novaCelula, proximaCelula;
		
		if ((posicao < 0) || (posicao > this.tamanho))
			throw new IndexOutOfBoundsException("Não foi possível inserir o item na lista: "
					+ "a posição informada é inválida!");
		
		anterior = this.primeiro;
		for (int i = 0; i < posicao; i++)
			anterior = anterior.getProximo();
				
		novaCelula = new Celula<>(novo);
			
		proximaCelula = anterior.getProximo();
			
		anterior.setProximo(novaCelula);
		novaCelula.setProximo(proximaCelula);
			
		if (posicao == this.tamanho)  // a inserção ocorreu na última posição da lista
			this.ultimo = novaCelula;
			
		this.tamanho++;		
	}
	
	public E remover(int posicao) {
		
		Celula<E> anterior, celulaRemovida, proximaCelula;
		
		if (vazia()) {
			throw new IllegalStateException("Não foi possível remover o item da lista: "
					+ "a lista está vazia!");
		}
		
		if ((posicao < 0) || (posicao >= this.tamanho )) {
			throw new IndexOutOfBoundsException("Não foi possível remover o item da lista: "
					+ "a posição informada é inválida!");
		}
			
		anterior = this.primeiro;
		for (int i = 0; i < posicao; i++)
			anterior = anterior.getProximo();
				
		celulaRemovida = anterior.getProximo();
				
		proximaCelula = celulaRemovida.getProximo();
				
		anterior.setProximo(proximaCelula);
		celulaRemovida.setProximo(null);
				
		if (celulaRemovida == this.ultimo)
			this.ultimo = anterior;
				
		this.tamanho--;
				
		return (celulaRemovida.getItem());	
	}

	Lista<E> intercalarListas(Lista<E> l1, Lista<E> l2) {
		Lista<E> resultado = new Lista<E>();
		int j = 0;
		//Enquanto ambas estiverem cheias
		while (!l1.vazia() && !l2.vazia()) {
			resultado.inserir(l1.remover(0), j);
			resultado.inserir(l2.remover(0), j + 1);
			j+=2;
		}
		//Se sobrou l1 preencher
		while (!l1.vazia()) {
			resultado.inserir(l1.remover(0), j);
			j++;
		}
		//Se sobrou l2 preencher
		while(!l2.vazia()) {
			resultado.inserir(l2.remover(0), j);
			j++;
		}
		return resultado;
	}
}

public class Questao5 {
    public static void main(String[] args) {
        Lista<Integer> list = new Lista<>();
        list.inserir(10, 1);
        list.inserir(20, 1);
        list.inserir(30, 1);
        list.inserir(40, 1);
        list.inserir(50, 1);
    }
}