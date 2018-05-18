package pilha;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import pilha.Pilha;
import pilha.PilhaCheiaException;
import pilha.PilhaVaziaException;

public class TestPilha {
    
    private Pilha p;
    
    @Before
    public void inicializaPilha(){
        p = new Pilha(10);
    }
    
    @Test
    public void pilhaVazia(){
        assertTrue(p.isVazia());
        assertEquals(0,p.tamanho());
    }
    
    @Test
    public void empilhaUmElemento(){
        p.empilha("primeiro");
        assertFalse(p.isVazia());
        assertEquals(1,p.tamanho());
        assertEquals("primeiro", p.topo());
    }
    
    @Test
    public void empilhaEDesempilha(){
        p.empilha("primeiro");
        p.empilha("segundo");
        assertEquals(2,p.tamanho());
        assertEquals("segundo", p.topo());
        Object desempilhado = p.desempilha();
        assertEquals(1,p.tamanho());
        assertEquals("primeiro", p.topo());
        assertEquals("segundo", desempilhado);
    }
    
    @Test(expected = PilhaVaziaException.class)
    public void removeDaPilhaVazia(){
        p.desempilha();
    }
    
    @Test
    public void adicionaNaPilhaCheia(){
        for (int i = 0; i < 10; i++) {
            p.empilha("elemento"+i);
        }
        try {
            p.empilha("empilhou");
            fail();
        } catch (PilhaCheiaException e) {}
    }
    
	@Test
    public void testaExpressao() {
     	String exp = "(a * b)";
		for(int i = 0; i < 10; i++) {
			if(exp.charAt(i) == '(') {
				p.empilha('(');
			}else if (exp.charAt(i) == ')') {
                if (p.isVazia()) {
                    System.out.println("Erro");
                    break;
                } else {
                    p.desempilha();
                    if (exp.length() - 1 == i && p.isVazia()) {
                        System.out.println("Expressão Valida");
                        break;
                    }
                }
                assertEquals(p.expressao(5, 6), 30);
			}
		}
	}
	@Test
	public void testaSoma() {
		assertEquals(p.soma(3, 2), 5);
	}
	
	
	@Test
	public void testaSubtracao() {
		assertEquals(p.subtracao(3, 2), 1);
	}
	
	@Test
	public void testaMultiplicacao() {
		assertEquals(p.mult(4, 7), 28);
	}
	
	@Test 
	public void testaDivisao() {
		assertEquals(p.div(12, 3), 4);
	}
}
    
