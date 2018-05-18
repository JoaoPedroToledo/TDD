package pilha;

	public class Pilha {
	    
	    private Object[] elementos;
	    private int quant = 0;
	    
	    public Pilha(int maximo){
	        elementos = new Object[maximo];
	    }

	    public boolean isVazia(){
	        return (quant == 0);
	    }
	    
	    public int tamanho(){
	        return quant;
	    }
	    
	    public void empilha(Object elemento){
	        if(quant == elementos.length)
	            throw new PilhaCheiaException("Não é possível empilhar mais elementos");
	        this.elementos[quant] = elemento;
	        quant++;
	    }
	    
	    public Object topo(){
	        return elementos[quant-1];
	    }
	    
	    public Object desempilha(){
	        if(isVazia())
	            throw new PilhaVaziaException("Não é possível desempilhar.");
	        Object topo = topo();
	        quant--;
	        return topo;
	    }

		public int soma(int a, int b) {
			return a+b;
		}

		public int subtracao(int a, int b) {
			return a - b;
		}

		public int mult(int a, int b) {
			return a * b;
		}

		public int div(int a, int b) {
			return a / b;
		}

		public String expressao(int a, int b) {
			return null;
		}
		
		
		
		
	}
