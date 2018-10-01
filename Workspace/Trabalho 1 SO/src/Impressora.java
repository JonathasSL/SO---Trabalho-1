import java.util.ArrayList;

public class Impressora {
	private int tempoDecorrido;
	private Pedido p;
	private ArrayList<Pedido> list;
	
	public Impressora() {
		setTempoDecorrido(0);
	}
	
	public void imprimirFilaDePrioridade() {
		FilaDePrioridade fila = new FilaDePrioridade(list);
		
	}
	
	public void imprimirFila() {
		Fila fila = new Fila(list);
	}
	
	
	


		public int getTempoDecorrido() {
		return tempoDecorrido;
	}
	public void setTempoDecorrido(int tempoDecorrido) {
		this.tempoDecorrido = tempoDecorrido;
	}

	public Pedido getP() {
		return p;
	}
	public void setP(Pedido p) {
		this.p = p;
	}
	
	public ArrayList<Pedido> getList() {
		return list;
	}
	public void setList(ArrayList<Pedido> list) {
		this.list = list;
	}
}
