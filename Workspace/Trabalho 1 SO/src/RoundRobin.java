import java.util.ArrayList;

public class RoundRobin {
	private ArrayList<Pedido> list;
	public float tempoDecorrido;
	private int quantum;

	public RoundRobin(ArrayList<Pedido> list) {
		setList(list);
		setTempoDecorrido(0);
		setQuantum(5);
		executa();
	}
	public RoundRobin(ArrayList<Pedido> list,int quantum) {
		setList(list);
		setTempoDecorrido(0);
		setQuantum(quantum);
		executa();
	}
	public RoundRobin() {
		setTempoDecorrido(0);
		setQuantum(7);
		executa();
	}
	public RoundRobin(int quantum) {
		setTempoDecorrido(0);
		setQuantum(quantum);
		executa();
	}

	
	public float executa() {
		while(!terminou()) {
			for(int i=0;i<list.size();i++) {
				if(!list.get(i).isDone()) {
					if(list.get(i).getTempoDecorrido()==0)
						list.get(i).setStartedTime(tempoDecorrido);

					if(list.get(i).getDurationLeft() > quantum) {
						list.get(i).setTempoDecorrido(quantum);
						tempoDecorrido+=quantum;//list.get(i).getDurationLeft() ?
					}else {
						list.get(i).setTempoDecorrido(list.get(i).getDurationLeft());
						tempoDecorrido+=quantum;
					}
					
					if(list.get(i).isDone())
						if(list.get(i).getTimeDelivered() == 0)
							list.get(i).setTimeDelivered(tempoDecorrido);

					tempoDecorrido+=0.25;
				}
			}

		}
		return tempoDecorrido;

	}

	public boolean terminou() {
		boolean terminou = true;
		for(int i=0;i<list.size() && terminou;i++)
			terminou = list.get(i).isDone();
		return terminou;
	}

	public int getComEntrega() {
		int comEntrega = 0;
		for(int i=0;i<list.size();i++)
			if(list.get(i).hasDelivery())
				comEntrega++;
		return comEntrega;
	}
	
	public int getEntreguesNoPrazo() {
		int entregues=0;
		for(int i=0;i<list.size();i++)
			if(list.get(i).getDeliveryTime() !=0 && list.get(i).getTimeDelivered()<=list.get(i).getDeliveryTime())
				entregues++;
		return entregues;
	}

	public float getMediaRetorno() {
		float tempoRetorno=0;
		for(int i=0;i<list.size();i++) {
			tempoRetorno += list.get(i).getTimeDelivered();
		}
		tempoRetorno /= list.size();
		return tempoRetorno;
	}

	public float getMediaResposta() {
		float tempoDeResposta=0;
		for(int i=0;i<list.size();i++) {
			tempoDeResposta += list.get(i).getStartedTime();
		}
		tempoDeResposta /= list.size();
		return tempoDeResposta;
	}	

	public void setList(ArrayList<Pedido> list) {
		this.list = list;
	}

	public float getTempoDecorrido() {
		return tempoDecorrido;
	}

	public void setTempoDecorrido(float tempoDecorrido) {
		this.tempoDecorrido = tempoDecorrido;
	}
	
	public int getQuantum() {
		return quantum;
	}
	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}
}