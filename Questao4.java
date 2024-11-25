class Celula<T> {

	private final T item;
	private Celula<T> anterior;
	private Celula<T> proximo;

	public Celula() {
		this.item = null;
		setAnterior(null);
		setProximo(null);
	}

	public Celula(T item) {
		this.item = item;
		setAnterior(null);
		setProximo(null);
	}

	public Celula(T item, Celula<T> anterior, Celula<T> proximo) {
        this.item = item;
        this.anterior = anterior;
        this.proximo = proximo;
    }
	
	public T getItem() {
		return item;
	}

	public Celula<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(Celula<T> anterior) {
		this.anterior = anterior;
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

	//Getters
	public Celula<E> getPrimeiro() {
		return primeiro;
	}

	public Celula<E> getUltimo() {
		return ultimo;
	}	

	public int getTamanho() {
		return tamanho;
	}

	//Setters
	public void setPrimeiro(Celula<E> primeiro) {
		this.primeiro = primeiro;
	}

	public void setUltimo(Celula<E> ultimo) {
		this.ultimo = ultimo;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
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

	public void mesclarAlternadamente (Lista<E> outraLista) {
		Lista<E> aux = new Lista<E>();

		Celula<E> atual = this.primeiro;
		Celula<E> outroAtual = outraLista.getPrimeiro();

		while(!outraLista.vazia()) {
			if(atual.getProximo() == null) {
				break;
			}
			//O anterior do proximo vai ser o outroAtual
			atual.getProximo().setAnterior(outroAtual);
			//O proximo do atual vai ser o outroAtual
			atual.setProximo(outroAtual);
			//Percorre na outraLista
			outroAtual = outroAtual.getProximo();
			//Percorre na atual ignorando o elemento adicionado
			atual = atual.getProximo().getProximo();
		}
		ultimo = atual;
		while(!outraLista.vazia()) {
			atual.setProximo(outroAtual);
			outroAtual.setAnterior(atual);
			atual = atual.getProximo();
		}
		ultimo = atual;
		atual.setProximo(null);
	}


}


public class Questao4 {
    public static void main(String[] args) {
        
    }   
}
